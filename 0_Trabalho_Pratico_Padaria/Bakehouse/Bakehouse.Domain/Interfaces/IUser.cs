using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUser
    {
        public Result Insert(User user);
        public User FindById(int id);
        public IEnumerable<User> FindAll();
        public Result Delete(int id);
        public Result Update(int id, User user);
        public Result SignIn(User user);
        public Result ResetPasswordGenerateToken(User user);
        public Result ResetPasswordTo(User user, string newHashPassword);

    }
}