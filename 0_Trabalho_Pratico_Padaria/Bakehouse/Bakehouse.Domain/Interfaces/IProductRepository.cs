using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface IProductRepository
    {
        public Result Insert(Product product);
        public Product FindById(int id);
        public IEnumerable<Product> FindAll();
        public Result Delete(int id);
        public Result Update(int id, Product product);
    }
}