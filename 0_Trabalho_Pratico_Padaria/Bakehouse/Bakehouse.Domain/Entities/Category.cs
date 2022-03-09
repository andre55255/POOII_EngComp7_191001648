using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class Category : BaseEntities
    {
        public int Id { get; set; }
        public string Description { get; set; }

        public virtual ICollection<Product> Product { get; set; }
    }
}