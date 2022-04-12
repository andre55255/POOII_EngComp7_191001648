using Bakehouse.App.ViewObjects.Email;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.Domain.Entities;
using Bakehouse.Helpers;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.App.BBLs
{
    public class UserBBL
    {
        private readonly UserRepository _userRepo;
        private readonly RoleRepository _roleRepo;
        private readonly EmailBBL _emailBBL;

        public UserBBL()
        {
            _userRepo = new UserRepository();
            _roleRepo = new RoleRepository();
            _emailBBL = new EmailBBL();
        }

        public async Task<Result> SignInAsync(SignInUserVO userVO)
        {
            try
            {
                Result valid = userVO.Valid();
                if (valid.IsSuccess)
                {
                    User user = await _userRepo.FindByUsernameAsync(userVO.Username);
                    if (user == null)
                        return Result.Fail(ConstantsMessagesUser.ErrorBBLUserNotFound);

                    Result result = await _userRepo.SignInAsync(user, userVO.Password);
                    if (result.IsSuccess)
                    {
                        Role role = await _roleRepo.FindByIdAsync(user.RoleId);

                        UserApplicationSingleton.GetInstance(user.Id, user.Email, user.Username, 
                                                             user.Contacts, role.Description);

                        return Result.Ok();
                    }
                    return Result.Fail(result.Errors.FirstOrDefault().Message);
                }
                return Result.Fail(valid.Errors.FirstOrDefault().Message);
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLSignIn + userVO.Username,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorBBLSignIn + userVO.Username);
            }
        }

        public async Task<Result> ResetPasswordGenerateToken(string username)
        {
            try
            {
                if (username.Trim().Length <= 0)
                    return Result.Fail("Nome de usuário deve ser informado");

                User user = await _userRepo.FindByUsernameAsync(username);
                if (user == null)
                    return Result.Fail(ConstantsMessagesUser.ErrorBBLUserNotFound);

                Result result = await _userRepo.ResetPasswordGenerateTokenAsync(user);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);
                else
                {
                    string token = result.Successes.FirstOrDefault().Message;

                    EmailDataVO mailVO = new EmailDataVO
                    {
                        Email = user.Email,
                        NameUser = user.Username,
                        Token = token
                    };
                    Result isEmailSent = await _emailBBL.SendMailResetPassword(mailVO);

                    if (isEmailSent.IsFailed)
                        return Result.Fail(isEmailSent.Errors.FirstOrDefault().Message);

                    return Result.Ok().WithSuccess(user.Username + "," + user.Email);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLResetPasswordGenerateToken + username,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorBBLResetPasswordGenerateToken + username);
            }
        }

        public async Task<Result> ResetPasswordTo(ResetPasswordUserVO userVO)
        {
            try
            {
                Result valid = userVO.Valid();
                if (valid.IsSuccess)
                {
                    User user = await _userRepo.FindByUsernameAsync(userVO.Username);
                    if (user == null)
                        return Result.Fail(ConstantsMessagesUser.ErrorBBLUserNotFound);

                    if (user.TokenResetPassword != userVO.Token)
                        return Result.Fail(ConstantsMessagesUser.ErrorBBLResetPasswordTokenInvalid + user.Email);

                    Result result = await _userRepo.ResetPasswordToAsync(user, userVO.Password);
                    if (result.IsFailed)
                        return Result.Fail(result.Errors.FirstOrDefault().Message);
                    else
                        return Result.Ok();
                }
                else
                {
                    return Result.Fail(valid.Errors.FirstOrDefault().Message);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLResetPasswordTo + userVO.Username,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorBBLResetPasswordTo + userVO.Username);
            }
        }
    
        public async Task<List<UserVO>> FindAllUsers()
        {
            try
            {
                List<UserVO> usersVO = new List<UserVO>();
                List<User> users = await _userRepo.FindAllAsync();

                foreach (User user in users)
                {
                    Role role = await _roleRepo.FindByIdAsync(user.RoleId);

                    UserVO aux = new UserVO
                    {
                        Id = user.Id,
                        Email = user.Email,
                        Username = user.Username,
                        Role = (role == null) ? "Sem perfil" : role.Description,
                        CreatedAt = user.CreatedAt,
                        DisabledAt = user.DisabledAt
                    };

                    usersVO.Add(aux);
                }

                return usersVO;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLFindAllUsers,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }
    
        public async Task<Result> CreateUser(CreateUserVO userVO)
        {
            try
            {
                Result valid = userVO.Valid();
                if (valid.IsFailed)
                    return Result.Fail(valid.Errors.FirstOrDefault().Message);

                User user = new User
                {
                    Username = userVO.Username,
                    Email = userVO.Email,
                    HashPassword = StaticMethods.CryptPassword(userVO.Password),
                    Contacts = userVO.Contacts ?? "",
                    CreatedAt = DateTime.Now,
                    UpdatedAt = DateTime.Now,
                    DisabledAt = null,
                    LockoutEnd = 0,
                    Status = false,
                    TokenResetPassword = null,
                    RoleId = userVO.RoleId
                };

                Result result = await _userRepo.InsertAsync(user);
                if (result.IsSuccess)
                    return Result.Ok().WithSuccess(result.Successes.FirstOrDefault().Message);

                return Result.Fail(result.Errors.FirstOrDefault().Message);
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLCreateUser + userVO.Username,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorBBLCreateUser + userVO.Username);
            }
        }
    
        public async Task<Result> DeleteUser(int id)
        {
            try
            {
                Result result = await _userRepo.DeleteAsync(id);
                if (result.IsSuccess)
                    return Result.Ok();

                return Result.Fail(result.Errors.FirstOrDefault().Message);
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorBBLDelete + id,
                                         ex.Message,
                                         this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorBBLDelete + id);
            }
        }
    }
}