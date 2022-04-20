using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.Product
{
    public class ProductVO
    {
        public int Id { get; set; }
        public string BarCode { get; set; }
        public string Description { get; set; }
        public double Quantity { get; set; }
        public double ValueUnitary { get; set; }
        public double MinQuantity { get; set; }
        public int UnitOfMeasurementId { get; set; }
        public int CategoryId { get; set; }

        public DateTime CreatedAt { get; set; }

        public Result Valid()
        {
            try
            {
                if (BarCode.Trim().Length > 150 || BarCode.Trim().Length <= 0)
                    return Result.Fail("Código de barras deve ter no máximo 150 caracteres");
                if (Description.Trim().Length > 250 || Description.Trim().Length <= 0)
                    return Result.Fail("Descrção deve ter no maximo 250 caracteres");
                if (Quantity < 0)
                    return Result.Fail("Quantidade deve ser maior que -1");
                if (ValueUnitary <= 0)
                    return Result.Fail("Valor unitário deve ser maior que 0");
                if (MinQuantity <= 0)
                    return Result.Fail("Quantidade mínima deve ser maior que 0");
                if (UnitOfMeasurementId <= 0)
                    return Result.Fail("Unidade de medida deve ser informada");
                if (CategoryId <= 0)
                    return Result.Fail("Categoria deve ser informada");

                return Result.Ok();
            }
            catch (Exception)
            {
                return Result.Fail("Ocorreu um erro inesperado");
            }
        }
    }
}