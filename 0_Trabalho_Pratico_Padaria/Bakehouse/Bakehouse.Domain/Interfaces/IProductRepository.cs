using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IProductRepository
    {
        public Task<Result> Insert(Product product);
        public Task<Product> FindById(int id);
        public Task<IEnumerable<Product>> FindAll();
        public Task<Result> Delete(int id);
        public Task<Result> Update(int id, Product product);
    }
}