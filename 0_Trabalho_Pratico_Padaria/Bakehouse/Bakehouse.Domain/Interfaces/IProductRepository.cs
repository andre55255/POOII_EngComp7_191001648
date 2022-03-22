using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface IProductRepository
    {
        public Task<Result> InsertAsync(Product product);
        public Task<Product> FindByIdAsync(int id);
        public Task<IEnumerable<Product>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, Product product);
    }
}