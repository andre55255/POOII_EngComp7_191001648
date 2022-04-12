using Bakehouse.App.ViewObjects.Category;
using Bakehouse.Domain.Entities;
using Bakehouse.Helpers;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.App.BBLs
{
    public class CategoryBBL
    {
        private readonly CategoryRepository _categoryRepo;

        public CategoryBBL()
        {
            _categoryRepo = new CategoryRepository();
        }

        public async Task<Result> CreateCategory(CategoryVO catVO)
        {
            try
            {
                Result isValid = catVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Category save = new Category
                {
                    Description = catVO.Description
                };

                Result result = await _categoryRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorBBLCreateCategory,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorBBLCreateCategory);
            }
        }
    
        public async Task<List<CategoryVO>> FindAllCategory()
        {
            try
            {
                List<Category> saves = await _categoryRepo.FindAllAsync();

                List<CategoryVO> catReturns = new List<CategoryVO>();
                foreach (Category item in saves)
                {
                    CategoryVO aux = new CategoryVO
                    {
                        Id = item.Id,
                        Description = item.Description,
                        CreatedAt = item.CreatedAt
                    };
                    catReturns.Add(aux);
                }

                return catReturns;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorBBLFindAllCategory,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }
   
        public async Task<CategoryVO> FindByIdCategory(int id)
        {
            try
            {
                Category save = await _categoryRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                CategoryVO catVO = new CategoryVO
                {
                    Id = save.Id,
                    Description = save.Description,
                    CreatedAt = save.CreatedAt
                };

                return catVO;
            }
            catch (Exception ex)
            {
               await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorBBLFindByIdCategory + id,
                                          ex.Message,
                                          this.GetType().ToString());
 
                return null;
            }
        }
    
        public async Task<Result> DeleteCategory(int id)
        {
            try
            {
                Result result = await _categoryRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorBBLDeleteCategory + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorBBLDeleteCategory + id);
            }
        }
    
        public async Task<Result> UpdateCategory(int id, CategoryVO catVO)
        {
            try
            {
                Result isValid = catVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Category save = new Category
                {
                    Id = catVO.Id,
                    Description = catVO.Description
                };

                Result result = await _categoryRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesCategory.ErrorBBLUpdateCategory + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesCategory.ErrorBBLUpdateCategory + id);
            }
        }
    }
}