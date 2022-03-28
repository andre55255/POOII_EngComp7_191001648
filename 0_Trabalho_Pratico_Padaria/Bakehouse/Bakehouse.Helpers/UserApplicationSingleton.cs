namespace Bakehouse.Helpers
{
    public class UserApplicationSingleton
    {
        private static UserApplicationSingleton _user;

        public int Id { get; set; }
        public string Email { get; set; }
        public string Username { get; set; }
        public string Contacts { get; set; }
        public string Role { get; set; }

        private UserApplicationSingleton() { }

        public static UserApplicationSingleton GetInstance(int id, string email, string username,
                                                           string contact, string role)
        {
            if (_user == null)
            {
                _user = new UserApplicationSingleton
                {
                    Id = id,
                    Email = email,
                    Username = username,
                    Contacts = contact,
                    Role = role
                };
            }

            return _user;
        }

        public static UserApplicationSingleton GetInstance()
        {
            return _user;
        }
    }
}
