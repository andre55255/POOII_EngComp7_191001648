using System.Security.Cryptography;
using System.Text;

namespace Bakehouse.Helpers
{
    public static class StaticMethods
    {
        public static string CryptPassword(string password)
        {
            byte[] encodedValue = Encoding.UTF8.GetBytes(password);
            byte[] encryptedPassword = SHA256.Create()
                                             .ComputeHash(encodedValue);

            StringBuilder sb = new StringBuilder();
            foreach (byte caracter in encryptedPassword)
            {
                sb.Append(caracter.ToString("X2"));
            }

            return sb.ToString();
        }

        public static bool VerifyPassword(string passwordDigit, string passwordSave)
        {
            byte[] encodedPassDigit = Encoding.UTF8.GetBytes(passwordDigit);
            byte[] encryptedPassword = SHA256.Create()
                                          .ComputeHash(encodedPassDigit);

            StringBuilder sb = new StringBuilder();
            foreach (byte caractere in encryptedPassword)
            {
                sb.Append(caractere.ToString("X2"));
            }

            return sb.ToString() == passwordSave;
        }
    }
}
