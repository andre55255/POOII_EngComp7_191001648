using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUserRepository
    {
        public Task<Result> InsertAsync(User user);
        public Task<User> FindByIdAsync(int id);
        public Task<User> FindByUsernameAsync(string username);
        public Task<User> FindByEmailAsync(string email);
        public Task<List<User>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, User user);
        public Task<Result> SignInAsync(User user, string passwordDigit);
        public Task<Result> ResetPasswordGenerateTokenAsync(User user);
        public Task<Result> ResetPasswordToAsync(User user, string newHashPassword);

    }
}