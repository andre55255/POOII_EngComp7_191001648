using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IMovementRepository
    {
        public Task<Result> Insert(Movement movement);
        public Task<Movement> FindById(int id);
        public Task<IEnumerable<Movement>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, Movement movement);
    }
}