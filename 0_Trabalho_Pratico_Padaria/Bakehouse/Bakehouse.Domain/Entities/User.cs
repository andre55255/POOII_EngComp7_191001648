using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class User : BaseEntities
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string HashPassword { get; set; }
        public bool Status { get; set; }

        public Role Role { get; set; }
        public int RoleId { get; set; }
        public virtual ICollection<OrderPad> OrderPads { get; set; }
        public virtual ICollection<Movement> Movements { get; set; }
    }
}