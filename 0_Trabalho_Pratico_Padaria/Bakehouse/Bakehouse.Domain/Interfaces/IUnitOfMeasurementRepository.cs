using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUnitOfMeasurementRepository
    {
        public Task<Result> Insert(UnitOfMeasurement unitOfMeasurement);
        public Task<UnitOfMeasurement> FindById(int id);
        public Task<IEnumerable<UnitOfMeasurement>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, UnitOfMeasurement unitOfMeasurement);
    }
}