using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPadRepository
    {
        public Task<Result> Insert(OrderPad orderPad);
        public Task<OrderPad> FindById(int id);
        public Task<IEnumerable<OrderPad>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, OrderPad orderPad);
    }
}