using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUserRepository
    {
        public Task<Result> Insert(User user);
        public Task<User> FindById(int id);
        public Task<IEnumerable<User>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, User user);
        public Task<Result> SignIn(User user);
        public Task<Result> ResetPasswordGenerateToken(User user);
        public Task<Result> ResetPasswordTo(User user, string newHashPassword);

    }
}