using Bakehouse.App.ViewObjects.Movement;
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
    public class MovementBBL
    {
        private readonly MovementRepository _movRepo;

        public MovementBBL()
        {
            _movRepo = new MovementRepository();
        }

        public async Task<Result> Create(MovementVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Movement save = new Movement
                {
                    Description = modelVO.Description,
                    DateHour = DateTime.Now,
                    TotalValue = modelVO.TotalValue,
                    GenericTypeId = modelVO.GenericTypeId,
                    UserId = modelVO.UserId
                };

                Result result = await _movRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorBBLCreate,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorBBLCreate);
            }
        }

        public async Task<List<MovementVO>> FindAll()
        {
            try
            {
                List<Movement> saves = await _movRepo.FindAllAsync();

                List<MovementVO> returns = new List<MovementVO>();
                foreach (Movement item in saves)
                {
                    MovementVO aux = new MovementVO
                    {
                        Id = item.Id,
                        Description = item.Description,
                        DateHour = item.DateHour,
                        TotalValue = item.TotalValue,
                        GenericTypeId = item.GenericTypeId,
                        UserId = item.UserId
                    };
                    returns.Add(aux);
                }

                return returns;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<MovementVO> FindById(int id)
        {
            try
            {
                Movement save = await _movRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                MovementVO ret = new MovementVO
                {
                    Id = save.Id,
                    Description = save.Description,
                    DateHour = save.DateHour,
                    TotalValue = save.TotalValue,
                    GenericTypeId = save.GenericTypeId,
                    UserId = save.UserId
                };

                return ret;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorBBLFindById + id,
                                           ex.Message,
                                           this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> Delete(int id)
        {
            try
            {
                Result result = await _movRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorBBLDelete + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorBBLDelete + id);
            }
        }

        public async Task<Result> Update(int id, MovementVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                Movement save = new Movement
                {
                    Id = modelVO.Id,
                    Description = modelVO.Description,
                    DateHour = modelVO.DateHour,
                    TotalValue = modelVO.TotalValue,
                    GenericTypeId = modelVO.GenericTypeId,
                    UserId = modelVO.UserId
                };

                Result result = await _movRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesMovement.ErrorBBLUpdate + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesMovement.ErrorBBLUpdate + id);
            }
        }
    }
}