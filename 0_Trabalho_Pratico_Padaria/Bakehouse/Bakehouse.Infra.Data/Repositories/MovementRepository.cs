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
    public class MovementRepository : BaseRepository, IMovementRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                Movement save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesMovement.ErrorInfraDataFindByIdMovement);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorInfraDataDeleteMovement,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorInfraDataDeleteMovement);
            }
        }

        public async Task<IEnumerable<Movement>> FindAllAsync()
        {
            try
            {
                List<Movement> response = await _db.Movements
                                                   .Where(x => x.DisabledAt == null)
                                                   .ToListAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorInfraDataDeleteMovement,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Movement> FindByIdAsync(int id)
        {
            try
            {
                Movement response = await _db.Movements
                                             .Where(x => x.Id == id && x.DisabledAt == null)
                                             .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorInfraDataFindByIdMovement,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(Movement movement)
        {
            try
            {
                movement.CreatedAt = DateTime.Now;
                movement.UpdatedAt = DateTime.Now;
                movement.DisabledAt = null;

                _db.Movements.Add(movement);
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(movement.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorInfraDataInsertMovement,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorInfraDataInsertMovement);
            }
        }

        public async Task<Result> UpdateAsync(int id, Movement movement)
        {
            try
            {
                Movement save = await FindByIdAsync(id);

                save.Description = movement.Description;
                save.DateHour = movement.DateHour;
                save.TotalValue = movement.TotalValue;
                save.GenericTypeId = movement.GenericTypeId;
                save.UserId = movement.UserId;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorInfraDataUpdateMovement,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorInfraDataUpdateMovement);
            }
        }
    }
}