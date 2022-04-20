using Bakehouse.App.ViewObjects.OrderPad;
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
    public class OrderPadBBL
    {
        private readonly OrderRepository _orderRepo;

        public OrderPadBBL()
        {
            _orderRepo = new OrderRepository();
        }

        public async Task<Result> Create(OrderPadVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                OrderPad save = new OrderPad
                {
                    DateHour = modelVO.DateHour,
                    UserId = modelVO.UserId
                };

                Result result = await _orderRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorBBLCreate,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorBBLCreate);
            }
        }

        public async Task<List<OrderPadVO>> FindAll()
        {
            try
            {
                List<OrderPad> saves = await _orderRepo.FindAllAsync();

                List<OrderPadVO> returns = new List<OrderPadVO>();
                foreach (OrderPad item in saves)
                {
                    OrderPadVO aux = new OrderPadVO
                    {
                        Id = item.Id,
                        DateHour = item.DateHour,
                        UserId = item.UserId
                    };
                    returns.Add(aux);
                }

                return returns;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<OrderPadVO> FindById(int id)
        {
            try
            {
                OrderPad save = await _orderRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                OrderPadVO ret = new OrderPadVO
                {
                    Id = save.Id,
                    DateHour = save.DateHour,
                    UserId = save.UserId
                };

                return ret;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorBBLFindById + id,
                                           ex.Message,
                                           this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> Delete(int id)
        {
            try
            {
                Result result = await _orderRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorBBLDelete + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorBBLDelete + id);
            }
        }

        public async Task<Result> Update(int id, OrderPadVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                OrderPad save = new OrderPad
                {
                    Id = modelVO.Id,
                    DateHour = modelVO.DateHour,
                    UserId = modelVO.UserId
                };

                Result result = await _orderRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPad.ErrorBBLUpdate + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPad.ErrorBBLUpdate + id);
            }
        }
    }
}