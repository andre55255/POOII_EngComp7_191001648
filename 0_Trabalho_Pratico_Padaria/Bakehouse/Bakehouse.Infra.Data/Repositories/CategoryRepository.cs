using Bakehouse.Domain.Entities;
using Bakehouse.Domain.Interfaces;
using Bakehouse.Helpers;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.Infra.Data.Repositories
{
    public class CategoryRepository : BaseRepository, ICategoryRepository 
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                Category save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesCategory.ErrorInfraDataFindByIdCategory);

                save.DisabledAt = DateTime.Now;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorInfraDataDeleteCategory,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorInfraDataDeleteCategory);
            }
        }

        public async Task<List<Category>> FindAllAsync()
        {
            try
            {
                List<Category> response = await _db.Categories
                                                   .Where(x => x.DisabledAt == null)
                                                   .ToListAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorInfraDataDeleteCategory,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Category> FindByIdAsync(int id)
        {
            try
            {
                Category response = await _db.Categories
                                             .Where(x => x.Id == id && x.DisabledAt == null)
                                             .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorInfraDataFindByIdCategory,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(Category category)
        {
            try
            {
                category.CreatedAt = DateTime.Now;
                category.UpdatedAt = DateTime.Now;
                category.DisabledAt = null;

                _db.Categories.Add(category);
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(category.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorInfraDataInsertCategory,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorInfraDataInsertCategory);
            }
        }

        public async Task<Result> UpdateAsync(int id, Category category)
        {
            try
            {
                Category save = await FindByIdAsync(id);
                
                save.Description = category.Description;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorInfraDataUpdateCategory,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorInfraDataUpdateCategory);
            }
        }
    }
}