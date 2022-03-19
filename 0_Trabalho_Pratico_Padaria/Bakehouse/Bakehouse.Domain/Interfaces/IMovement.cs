using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IMovement
    {
        public Result Insert(Movement movement);
        public Movement FindById(int id);
        public IEnumerable<Movement> FindAll();
        public Result Delete(int id);
        public Result Update(int id, Movement movement);
    }
}