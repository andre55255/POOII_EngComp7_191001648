using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.UnitOfMeasurement
{
    public class UnitOfMeasurementVO
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public DateTime CreatedAt { get; set; }

        public Result Valid()
        {
            if (Description.Trim().Length <= 0)
                return Result.Fail("Descrição da unidade de medida deve ser maior que zero");

            return Result.Ok();
        }
    }
}