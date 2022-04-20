using Bakehouse.App.ViewObjects.Product;
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
    public class ProductBBL
    {
        private readonly ProductRepository _prodRepo;

        public ProductBBL()
        {
            _prodRepo = new ProductRepository();
        }

        public async Task<Result> Create(ProductVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Product save = new Product
                {
                    BarCode = modelVO.BarCode,
                    Description = modelVO.Description,
                    Quantity = modelVO.Quantity,
                    ValueUnitary = modelVO.ValueUnitary,
                    MinQuantity = modelVO.MinQuantity,
                    CategoryId = modelVO.CategoryId,
                    UnitOfMeasurementId = modelVO.UnitOfMeasurementId
                };

                Result result = await _prodRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorBBLCreate,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorBBLCreate);
            }
        }

        public async Task<List<ProductVO>> FindAll()
        {
            try
            {
                List<Product> saves = await _prodRepo.FindAllAsync();

                List<ProductVO> returns = new List<ProductVO>();
                foreach (Product item in saves)
                {
                    ProductVO aux = new ProductVO
                    {
                        Id = item.Id,
                        BarCode = item.BarCode,
                        Description = item.Description,
                        Quantity = item.Quantity,
                        ValueUnitary = item.ValueUnitary,
                        MinQuantity = item.MinQuantity,
                        UnitOfMeasurementId = item.UnitOfMeasurementId,
                        CategoryId = item.CategoryId,
                        CreatedAt = item.CreatedAt
                    };
                    returns.Add(aux);
                }

                return returns;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<ProductVO> FindById(int id)
        {
            try
            {
                Product save = await _prodRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                ProductVO ret = new ProductVO
                {
                    Id = save.Id,
                    BarCode = save.BarCode,
                    Description = save.Description,
                    Quantity = save.Quantity,
                    MinQuantity = save.MinQuantity,
                    ValueUnitary = save.ValueUnitary,
                    CategoryId = save.CategoryId,
                    UnitOfMeasurementId = save.UnitOfMeasurementId,
                    CreatedAt = save.CreatedAt
                };

                return ret;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorBBLFindById + id,
                                           ex.Message,
                                           this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> Delete(int id)
        {
            try
            {
                Result result = await _prodRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorBBLDelete + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorBBLDelete + id);
            }
        }

        public async Task<Result> Update(int id, ProductVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Product save = new Product
                {
                    Id = modelVO.Id,
                    BarCode = modelVO.BarCode,
                    Description = modelVO.Description,
                    Quantity = modelVO.Quantity,
                    ValueUnitary = modelVO.ValueUnitary,
                    MinQuantity = modelVO.MinQuantity,
                    CategoryId = modelVO.CategoryId,
                    UnitOfMeasurementId = modelVO.UnitOfMeasurementId
                };

                Result result = await _prodRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorBBLUpdate + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorBBLUpdate + id);
            }
        }
    }
}