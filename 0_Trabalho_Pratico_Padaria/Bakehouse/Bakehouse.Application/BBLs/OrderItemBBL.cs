using Bakehouse.App.ViewObjects.OrderItem;
using Bakehouse.App.ViewObjects.OrderPadItem;
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
    public class OrderPadItemBBL
    {
        private readonly OrderItemRepository _orderPadRepo;
        private readonly OrderRepository _orderRepo;
        private readonly ProductBBL _prodBBL;

        public OrderPadItemBBL()
        {
            _orderPadRepo = new OrderItemRepository();
            _orderRepo = new OrderRepository();
            _prodBBL = new ProductBBL();
        }

        public async Task<Result> Create(OrderItemVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                ProductVO prod = await _prodBBL.FindById(modelVO.ProductId);
                Result validProduct = await IsValidProductStore(prod, modelVO.Quantity);

                if (validProduct.IsFailed)
                    return Result.Fail(validProduct.Errors.FirstOrDefault().Message);

                OrderPad orderPad = await _orderRepo.FindByIdAsync(modelVO.OrderPadId);
                if (orderPad == null)
                    return Result.Fail("Comanda não existe no banco de dados");

                OrderPadItem save = new OrderPadItem
                {
                    Quantity = modelVO.Quantity,
                    ValueUnitary = modelVO.ValueUnitary,
                    ProductId = modelVO.ProductId,
                    OrderPadId = modelVO.OrderPadId
                };

                Result result = await _orderPadRepo.InsertAsync(save);

                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorBBLCreate,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorBBLCreate);
            }
        }

        private async Task<Result> IsValidProductStore(ProductVO prod, double quantityOrderPad)
        {
            try
            {
                if (prod == null)
                    return Result.Fail("Produto não existe no banco de dados");
                if (prod.Quantity < quantityOrderPad)
                    return Result.Fail("Quantidade de produtos no estoque menor que quantidade do item de pedido");

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Falha ao validar produto no item de pedido",
                                            ex.Message,
                                            this.GetType().ToString());

                return Result.Fail("Falha ao validar produto no item de pedido");
            }
        }

        public async Task<List<OrderItemVO>> FindAll()
        {
            try
            {
                List<OrderPadItem> saves = await _orderPadRepo.FindAllAsync();

                List<OrderItemVO> returns = new List<OrderItemVO>();
                foreach (OrderPadItem item in saves)
                {
                    OrderItemVO aux = new OrderItemVO
                    {
                        Id = item.Id,
                        Quantity = item.Quantity,
                        ValueUnitary = item.ValueUnitary,
                        ProductId = item.ProductId,
                        OrderPadId = item.OrderPadId
                    };
                    returns.Add(aux);
                }

                return returns;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        public async Task<OrderItemVO> FindById(int id)
        {
            try
            {
                OrderPadItem save = await _orderPadRepo.FindByIdAsync(id);
                if (save == null)
                    return null;

                OrderItemVO ret = new OrderItemVO
                {
                    Id = save.Id,
                    Quantity = save.Quantity,
                    ValueUnitary = save.ValueUnitary,
                    ProductId = save.ProductId,
                    OrderPadId = save.OrderPadId
                };

                return ret;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorBBLFindById + id,
                                           ex.Message,
                                           this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> Delete(int id)
        {
            try
            {
                Result result = await _orderPadRepo.DeleteAsync(id);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorBBLDelete + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorBBLDelete + id);
            }
        }

        public async Task<Result> Update(int id, OrderItemVO modelVO)
        {
            try
            {
                Result isValid = modelVO.Valid();
                if (isValid.IsFailed)
                    return Result.Fail(isValid.Errors.FirstOrDefault().Message);

                ProductVO prod = await _prodBBL.FindById(modelVO.ProductId);
                Result validProduct = await IsValidProductStore(prod, modelVO.Quantity);

                if (validProduct.IsFailed)
                    return Result.Fail(validProduct.Errors.FirstOrDefault().Message);

                OrderPad orderPad = await _orderRepo.FindByIdAsync(modelVO.OrderPadId);
                if (orderPad == null)
                    return Result.Fail("Comanda não existe no banco de dados");

                OrderPadItem save = new OrderPadItem
                {
                    Id = modelVO.Id,
                    Quantity = modelVO.Quantity,
                    ValueUnitary = modelVO.ValueUnitary,
                    ProductId = modelVO.ProductId,
                    OrderPadId = modelVO.OrderPadId
                };

                Result result = await _orderPadRepo.UpdateAsync(id, save);
                if (result.IsFailed)
                    return Result.Fail(result.Errors.FirstOrDefault().Message);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesOrderPadItem.ErrorBBLUpdate + id,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesOrderPadItem.ErrorBBLUpdate + id);
            }
        }
    }
}