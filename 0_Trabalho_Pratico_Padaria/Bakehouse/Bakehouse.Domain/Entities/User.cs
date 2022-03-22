using System.Collections.Generic;

namespace Bakehouse.Domain.Entities
{
    public class User : BaseEntities
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string Username { get; set; }
        public string HashPassword { get; set; }
        public string Contacts { get; set; }
        public bool Status { get; set; }
        public int LockoutEnd { get; set; }
        public string TokenResetPassword { get; set; }

        // Props Navigation
        public Role Role { get; set; }
        public int RoleId { get; set; }
        public virtual ICollection<OrderPad> OrderPads { get; set; }
        public virtual ICollection<Movement> Movements { get; set; }
    }
}