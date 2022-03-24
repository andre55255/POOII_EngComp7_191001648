using Bakehouse.Domain.Entities;
using Bakehouse.Domain.Interfaces;
using Bakehouse.Helpers;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.Infra.Data.Repositories
{
    public class UserRepository : BaseRepository, IUserRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                User user = await FindByIdAsync(id);
                if (user == null)
                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataFindById);

                user.DisabledAt = DateTime.Now;
                user.UpdatedAt = DateTime.Now;

                _db.Entry(user).State = EntityState.Modified;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(user.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataDelete);
            }
        }

        public async Task<User> FindByEmailAsync(string email)
        {
            try
            {
                User user = await _db.Users
                                     .Where(x => x.Email == email && x.DisabledAt == null)
                                     .FirstOrDefaultAsync();

                return user;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataFindByEmail,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<User> FindByUsernameAsync(string username)
        {
            try
            {
                User user = await _db.Users
                                     .Where(x => x.Username == username && 
                                                 x.DisabledAt == null)
                                     .FirstOrDefaultAsync();

                return user;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataFindByUsername,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<IEnumerable<User>> FindAllAsync()
        {
            try
            {
                List<User> users = await _db.Users
                                            .Where(x => x.DisabledAt == null)
                                            .ToListAsync();

                _db.Dispose();

                return users;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<User> FindByIdAsync(int id)
        {
            try
            {
                User user = await _db.Users
                                     .Where(x => x.Id == id && x.DisabledAt == null)
                                     .FirstOrDefaultAsync();

                return user;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataFindByEmail,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(User user)
        {
            try
            {
                _db.Users.Add(user);
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(user.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataInsert,
                                         ex.Message,
                                         this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> ResetPasswordGenerateTokenAsync(User user)
        {
            try
            {
                string token = Guid.NewGuid().ToString("N");

                User save = await FindByIdAsync(user.Id);
                save.TokenResetPassword = token;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(token);
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataGenerateToken,
                                        ex.Message,
                                        this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataGenerateToken);
            }
        }

        public async Task<Result> ResetPasswordToAsync(User user, string newHashPassword)
        {
            try
            {
                User save = await FindByIdAsync(user.Id);
                
                if (save.TokenResetPassword == user.TokenResetPassword)
                {
                    save.TokenResetPassword = null;
                    save.HashPassword = StaticMethods.CryptPassword(newHashPassword);
                    save.LockoutEnd = 0;
                    save.UpdatedAt = DateTime.Now;
                    _db.Entry(save).State = EntityState.Modified;
                    await _db.SaveChangesAsync();
                    _db.Dispose();

                    return Result.Ok();
                } 
                else
                {
                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataTokenResetPasswordIncorrect);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataResetPassword,
                                        ex.Message,
                                        this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataResetPassword);
            }
        }

        public async Task<Result> SignInAsync(User user, string passwordDigit)
        {
            try
            {
                User save = await FindByIdAsync(user.Id);

                if (save.Username != user.Username)
                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataUserInvalid);

                if (save.LockoutEnd > 5)
                {
                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataLockoutEnded);
                }

                if (StaticMethods.VerifyPassword(passwordDigit, save.HashPassword))
                {
                    save.Status = true;
                    await _db.SaveChangesAsync();
                    _db.Dispose();

                    return Result.Ok().WithSuccess(save.Id.ToString());
                }
                else
                {
                    save.Status = false;
                    save.LockoutEnd += 1;
                    save.UpdatedAt = DateTime.Now;
                    await _db.SaveChangesAsync();
                    _db.Dispose();

                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataSignInPasswordIncorrect 
                                        + save.LockoutEnd);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataSignIn,
                                        ex.Message,
                                        this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataSignIn);
            }
        }

        public async Task<Result> UpdateAsync(int id, User user)
        {
            try
            {
                User save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesUser.ErrorInfraDataFindById);

                save.Email = user.Email;
                save.Username = user.Username;
                save.Contacts = user.Contacts;
                save.RoleId = user.RoleId;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUser.ErrorInfraDataUpdate,
                                        ex.Message,
                                        this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUser.ErrorInfraDataUpdate);
            }
        }
    }
}