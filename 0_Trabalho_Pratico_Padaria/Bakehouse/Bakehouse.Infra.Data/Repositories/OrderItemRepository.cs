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
    public class OrderItemRepository : BaseRepository, IOrderPadItemRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                OrderPadItem save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesOrderPadItem.ErrorInfraDataFindById);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorInfraDataDelete);
            }
        }

        public async Task<List<OrderPadItem>> FindAllAsync()
        {
            try
            {
                List<OrderPadItem> response = await _db.OrderPadItems
                                                       .Where(x => x.DisabledAt == null)
                                                       .ToListAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorInfraDataDelete,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<OrderPadItem> FindByIdAsync(int id)
        {
            try
            {
                OrderPadItem response = await _db.OrderPadItems
                                                 .Where(x => x.Id == id && x.DisabledAt == null)
                                                 .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorInfraDataFindById,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(OrderPadItem orderPadItem)
        {
            try
            {
                orderPadItem.CreatedAt = DateTime.Now;
                orderPadItem.UpdatedAt = DateTime.Now;
                orderPadItem.DisabledAt = null;

                _db.OrderPadItems.Add(orderPadItem);
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(orderPadItem.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorInfraDataInsert,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> UpdateAsync(int id, OrderPadItem orderPadItem)
        {
            try
            {
                OrderPadItem save = await FindByIdAsync(id);

                save.Quantity = orderPadItem.Quantity;
                save.ValueUnitary = orderPadItem.ValueUnitary;
                save.ProductId = orderPadItem.ProductId;
                save.OrderPadId = orderPadItem.OrderPadId;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorInfraDataUpdate,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorInfraDataUpdate);
            }
        }
    }
}