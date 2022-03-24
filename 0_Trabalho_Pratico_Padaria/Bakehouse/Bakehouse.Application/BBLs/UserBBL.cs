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
    }
}