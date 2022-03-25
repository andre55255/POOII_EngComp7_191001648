using Bakehouse.App.ViewObjects.User;
using Bakehouse.Domain.Entities;
using Bakehouse.Helpers;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.App.BBLs
{
    public class UserBBL
    {
        private UserRepository _userRepo;

        public UserBBL()
        {
            _userRepo = new UserRepository();
        }

        public async Task<Result> SignInAsync(CreateUserVO userVO)
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
                        return Result.Ok();
                    else
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
                    // Implementar envio de email com o token

                    return Result.Ok().WithSuccess(user.Username+","+user.Email);
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
    }
}