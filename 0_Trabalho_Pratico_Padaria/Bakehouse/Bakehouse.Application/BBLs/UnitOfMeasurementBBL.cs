using Bakehouse.App.ViewObjects.UnitOfMeasurement;
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
    public class UnitOfMeasurementBBL
    {
        private readonly UnitOfMeasurementRepository _uomRepo;

        public UnitOfMeasurementBBL()
        {
            _uomRepo = new UnitOfMeasurementRepository();
        }

        public async Task<Result> Create(UnitOfMeasurementVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                UnitOfMeasurement save = new UnitOfMeasurement
                {
                    Description = modelVO.Description
                };

                Result result = await _uomRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorBBLCreate,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorBBLCreate);
            }
        }

        public async Task<List<UnitOfMeasurementVO>> FindAll()
        {
            try
            {
                List<UnitOfMeasurement> saves = await _uomRepo.FindAllAsync();

                List<UnitOfMeasurementVO> catReturns = new List<UnitOfMeasurementVO>();
                foreach (UnitOfMeasurement item in saves)
                {
                    UnitOfMeasurementVO aux = new UnitOfMeasurementVO
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
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<UnitOfMeasurementVO> FindById(int id)
        {
            try
            {
                UnitOfMeasurement save = await _uomRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                UnitOfMeasurementVO catVO = new UnitOfMeasurementVO
                {
                    Id = save.Id,
                    Description = save.Description,
                    CreatedAt = save.CreatedAt
                };

                return catVO;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorBBLFindById + id,
                                           ex.Message,
                                           this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> Delete(int id)
        {
            try
            {
                Result result = await _uomRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorBBLDelete + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorBBLDelete + id);
            }
        }

        public async Task<Result> Update(int id, UnitOfMeasurementVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                UnitOfMeasurement save = new UnitOfMeasurement
                {
                    Id = modelVO.Id,
                    Description = modelVO.Description
                };

                Result result = await _uomRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesUnitOfMeasurement.ErrorBBLUpdate + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesUnitOfMeasurement.ErrorBBLUpdate + id);
            }
        }
    }
}