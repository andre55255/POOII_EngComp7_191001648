using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.OrderItem
{
    public class OrderItemVO
    {
        public int Id { get; set; }
        public double Quantity { get; set; }
        public double ValueUnitary { get; set; }
        public int ProductId { get; set; }
        public int OrderPadId { get; set; }

        public Result Valid()
        {
            try
            {
                if (Quantity <= 0)
                    return Result.Fail("A quantidade de produtos para este item deve ser maior que 0");
                if (ValueUnitary <= 0)
                    return Result.Fail("O valor unitário de produtos para este item deve ser maior que 0");
                if (ProductId <= 0)
                    return Result.Fail("ID do produto não informado");
                if (OrderPadId <= 0)
                    return Result.Fail("ID da comanda não informado");

                return Result.Ok();
            }
            catch (Exception)
            {
                return Result.Fail("Ocorreu um erro inesperado de validação");
            }
        }
    }
}