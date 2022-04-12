using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.Category
{
    public class CategoryVO
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public DateTime CreatedAt { get; set; }

        public Result Valid()
        {
            if (Description.Trim().Length <= 0)
                return Result.Fail("Descrição da categoria deve ser maior que zero");

            return Result.Ok();
        }
    }
}