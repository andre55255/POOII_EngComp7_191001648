using System;
using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class OrderPad : BaseEntities
    {
        public int Id { get; set; }
        public DateTime DateHour { get; set; }

        public User User { get; set; }
        public int UserId { get; set; }
        public virtual ICollection<OrderPadItem> OrderPadItems { get; set; }
    }
}