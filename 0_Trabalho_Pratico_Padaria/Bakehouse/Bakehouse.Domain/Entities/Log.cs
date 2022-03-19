using System;

namespace Bakehouse.Domain.Entities
{
    public class Log
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public string Exception { get; set; }
        public string Place { get; set; }
        public DateTime CreatedAt { get; set; }
    }
}