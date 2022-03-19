using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IOrderPad
    {
        public Result Insert(OrderPad orderPad);
        public OrderPad FindById(int id);
        public IEnumerable<OrderPad> FindAll();
        public Result Delete(int id);
        public Result Update(int id, OrderPad orderPad);
    }
}