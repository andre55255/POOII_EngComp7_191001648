using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class Role : BaseEntities
    {
        public int Id { get; set; }
        public string Description { get; set; }

        public virtual ICollection<User> Users { get; set; }
    }
}