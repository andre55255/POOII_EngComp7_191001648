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
    public class OrderRepository : BaseRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                OrderPad save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesOrderPad.ErrorInfraDataFindById);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorInfraDataDelete);
            }
        }

        public async Task<IEnumerable<OrderPad>> FindAllAsync()
        {
            try
            {
                List<OrderPad> response = await _db.OrderPads
                                                   .Where(x => x.DisabledAt == null)
                                                   .ToListAsync();

                _db.Dispose();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorInfraDataDelete,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<OrderPad> FindByIdAsync(int id)
        {
            try
            {
                OrderPad response = await _db.OrderPads
                                             .Where(x => x.Id == id && x.DisabledAt == null)
                                             .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorInfraDataFindById,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(OrderPad orderPad)
        {
            try
            {
                orderPad.CreatedAt = DateTime.Now;
                orderPad.UpdatedAt = DateTime.Now;
                orderPad.DisabledAt = null;

                _db.OrderPads.Add(orderPad);
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(orderPad.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorInfraDataInsert,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> UpdateAsync(int id, OrderPad orderPad)
        {
            try
            {
                OrderPad save = await FindByIdAsync(id);

                save.DateHour = orderPad.DateHour;
                save.UserId = orderPad.UserId;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorInfraDataUpdate,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorInfraDataUpdate);
            }
        }
    }
}