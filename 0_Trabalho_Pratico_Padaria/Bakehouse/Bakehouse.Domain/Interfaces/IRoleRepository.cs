using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IRoleRepository
    {
        public Task<Result> InsertAsync(Role role);
        public Task<Role> FindByIdAsync(int id);
        public Task<IEnumerable<Role>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, Role role);
    }
}