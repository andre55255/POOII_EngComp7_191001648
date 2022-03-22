using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class GenericType
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public string Token { get; set; }
        public double? Value { get; set; }

        public virtual IEnumerable<Movement> Movements { get; set; }
    }
}