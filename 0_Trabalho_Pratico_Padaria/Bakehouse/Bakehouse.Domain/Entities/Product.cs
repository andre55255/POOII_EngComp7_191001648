using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class Product : BaseEntities
    {
        public int Id { get; set; }
        public string BarCode { get; set; }
        public string Description { get; set; }
        public int Quantity { get; set; }
        public double ValueUnitary { get; set; }
        public int MinQuantity { get; set; }

        
        public virtual UnitOfMeasurement UnitOfMeasurement { get; set; }
        public int UnitOfMeasurementId { get; set; }
        public virtual Category Category { get; set; }
        public int CategoryId { get; set; }
        public virtual ICollection<OrderPadItem> OrderPadItems { get; set; }
    }
}