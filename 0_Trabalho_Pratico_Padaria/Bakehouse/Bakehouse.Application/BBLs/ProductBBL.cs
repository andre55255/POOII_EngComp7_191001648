using FluentResults;
using System;

namespace Bakehouse.App.BBLs
{
    public class ProductBBL
    {
        public int Id { get; set; }
        public string BarCode { get; set; }
        public string Description { get; set; }
        public double Quantity { get; set; }
        public double ValueUnitary { get; set; }
        public double MinQuantity { get; set; }
        public DateTime CreatedAt { get; set; }

        public Result Valid()
        {

        }

    }
}