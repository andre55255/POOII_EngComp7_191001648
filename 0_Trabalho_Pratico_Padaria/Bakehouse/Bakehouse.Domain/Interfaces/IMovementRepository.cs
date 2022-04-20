using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IMovementRepository
    {
        public Task<Result> InsertAsync(Movement movement);
        public Task<Movement> FindByIdAsync(int id);
        public Task<List<Movement>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, Movement movement);
    }
}