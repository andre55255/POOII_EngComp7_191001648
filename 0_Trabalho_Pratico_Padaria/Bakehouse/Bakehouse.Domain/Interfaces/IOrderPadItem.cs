using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPadItem
    {
        public Result Insert(OrderPadItem item);
        public OrderPadItem FindById(int id);
        public IEnumerable<OrderPadItem> FindAll();
        public Result Delete(int id);
        public Result Update(int id, OrderPadItem item);
    }
}