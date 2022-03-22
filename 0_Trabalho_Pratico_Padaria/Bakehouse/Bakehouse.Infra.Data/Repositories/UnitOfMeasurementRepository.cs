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
    public class UnitOfMeasurementRepository : BaseRepository, IUnitOfMeasurementRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                UnitOfMeasurement save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataFindById);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataDelete);
            }
        }

        public async Task<IEnumerable<UnitOfMeasurement>> FindAllAsync()
        {
            try
            {
                List<UnitOfMeasurement> response = await _db.UnitOfMeasurements
                                                            .Where(x => x.DisabledAt == null)
                                                            .ToListAsync();

                _db.Dispose();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataDelete,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<UnitOfMeasurement> FindByIdAsync(int id)
        {
            try
            {
                UnitOfMeasurement response = await _db.UnitOfMeasurements
                                                      .Where(x => x.Id == id && x.DisabledAt == null)
                                                      .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataFindById,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(UnitOfMeasurement unitOfMeasurement)
        {
            try
            {
                unitOfMeasurement.CreatedAt = DateTime.Now;
                unitOfMeasurement.UpdatedAt = DateTime.Now;
                unitOfMeasurement.DisabledAt = null;

                _db.UnitOfMeasurements.Add(unitOfMeasurement);
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(unitOfMeasurement.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataInsert,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> UpdateAsync(int id, UnitOfMeasurement unitOfMeasurement)
        {
            try
            {
                UnitOfMeasurement save = await FindByIdAsync(id);

                save.Description = unitOfMeasurement.Description;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();
                _db.Dispose();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataUpdate,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorInfraDataUpdate);
            }
        }
    }
}