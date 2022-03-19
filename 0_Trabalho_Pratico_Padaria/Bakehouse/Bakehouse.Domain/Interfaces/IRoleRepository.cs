using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IRoleRepository
    {
        public Task<Result> Insert(Role role);
        public Task<Role> FindById(int id);
        public Task<IEnumerable<Role>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, Role role);
    }
}