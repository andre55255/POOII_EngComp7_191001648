using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.Domain.Interfaces
{
    public interface ICategoryRepository
    {
        public Task<Result> InsertAsync(Category category);
        public Task<Category> FindByIdAsync(int id);
        public Task<IEnumerable<Category>> FindAllAsync();
        public Task<Result> DeleteAsync(int id);
        public Task<Result> UpdateAsync(int id, Category category);
    }
}