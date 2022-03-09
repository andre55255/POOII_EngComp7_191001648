namespace Bakehouse.Domain.Entities
{
    public class OrderPadItem : BaseEntities
    {
        public int Id { get; set; }
        public double Quantity { get; set; }
        public double ValueUnitary { get; set; }

        public Product Product { get; set; }
        public int ProductId { get; set; }
        public OrderPad OrderPad { get; set; }
        public int OrderPadId { get; set; }
    }
}