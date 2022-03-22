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
    public class ProductRepository : BaseRepository, IProductRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                Product save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesProduct.ErrorInfraDataFindById);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorInfraDataDelete);
            }
        }

        public async Task<IEnumerable<Product>> FindAllAsync()
        {
            try
            {
                List<Product> response = await _db.Products
                                                  .Where(x => x.DisabledAt == null)
                                                  .ToListAsync();

                _db.Dispose();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorInfraDataDelete,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Product> FindByIdAsync(int id)
        {
            try
            {
                Product response = await _db.Products
                                            .Where(x => x.Id == id && x.DisabledAt == null)
                                            .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorInfraDataFindById,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(Product product)
        {
            try
            {
                product.CreatedAt = DateTime.Now;
                product.UpdatedAt = DateTime.Now;
                product.DisabledAt = null;

                _db.Products.Add(product);
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(product.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorInfraDataInsert,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> UpdateAsync(int id, Product product)
        {
            try
            {
                Product save = await FindByIdAsync(id);

                save.BarCode = product.BarCode;
                save.Description = product.Description;
                save.Quantity = product.Quantity;
                save.ValueUnitary = product.ValueUnitary;
                save.MinQuantity = product.MinQuantity;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesProduct.ErrorInfraDataUpdate,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesProduct.ErrorInfraDataUpdate);
            }
        }
    }
}