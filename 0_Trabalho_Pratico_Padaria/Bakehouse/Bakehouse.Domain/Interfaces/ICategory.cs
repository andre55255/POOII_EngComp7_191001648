using Bakehouse.Domain.Entities;
using FluentResults;
using System.Collections.Generic;

namespace Bakehouse.Domain.Interfaces
{
    public interface ICategory
    {
        public Result Insert(Category category);
        public Category FindById(int id);
        public IEnumerable<Category> FindAll();
        public Result Delete(int id);
        public Result Update(int id, Category category);
    }
}