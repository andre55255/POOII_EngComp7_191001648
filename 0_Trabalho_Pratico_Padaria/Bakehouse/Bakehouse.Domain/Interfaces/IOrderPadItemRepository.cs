using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPadItemRepository
    {
        public Task<Result> InsertAsync(OrderPadItem item);
        public Task<OrderPadItem> FindByIdAsync(int id);
        public Task<List<OrderPadItem>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, OrderPadItem item);
    }
}