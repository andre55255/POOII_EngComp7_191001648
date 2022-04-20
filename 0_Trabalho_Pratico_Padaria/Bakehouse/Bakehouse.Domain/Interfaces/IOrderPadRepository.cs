using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPadRepository
    {
        public Task<Result> InsertAsync(OrderPad orderPad);
        public Task<OrderPad> FindByIdAsync(int id);
        public Task<List<OrderPad>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, OrderPad orderPad);
    }
}