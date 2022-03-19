using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPadItemRepository
    {
        public Task<Result> Insert(OrderPadItem item);
        public Task<OrderPadItem> FindById(int id);
        public Task<IEnumerable<OrderPadItem>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, OrderPadItem item);
    }
}