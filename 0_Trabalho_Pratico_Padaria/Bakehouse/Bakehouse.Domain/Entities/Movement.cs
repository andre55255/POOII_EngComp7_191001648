using System;

namespace Bakehouse.Domain.Entities
{
    public class Movement : BaseEntities
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public DateTime DateHour { get; set; }
        public double TotalValue { get; set; }
        public string Type { get; set; }

        public User User { get; set; }
        public int UserId { get; set; }
    }
}