using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IUnitOfMeasurement
    {
        public Result Insert(UnitOfMeasurement unitOfMeasurement);
        public UnitOfMeasurement FindById(int id);
        public IEnumerable<UnitOfMeasurement> FindAll();
        public Result Delete(int id);
        public Result Update(int id, UnitOfMeasurement unitOfMeasurement);
    }
}