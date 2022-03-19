using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IRole
    {
        public Result Insert(Role role);
        public Role FindById(int id);
        public IEnumerable<Role> FindAll();
        public Result Delete(int id);
        public Result Update(int id, Role role);
    }
}