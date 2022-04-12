using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUnitOfMeasurementRepository
    {
        public Task<Result> InsertAsync(UnitOfMeasurement unitOfMeasurement);
        public Task<UnitOfMeasurement> FindByIdAsync(int id);
        public Task<List<UnitOfMeasurement>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, UnitOfMeasurement unitOfMeasurement);
    }
}