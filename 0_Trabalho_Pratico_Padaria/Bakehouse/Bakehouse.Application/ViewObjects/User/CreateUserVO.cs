using FluentResults;
using System.Text;

namespace Bakehouse.App.ViewObjects.User
{
    public class CreateUserVO
    {
        public string Username { get; set; }
        public string Password { get; set; }

        public Result Valid()
        {
            StringBuilder errors = new StringBuilder();

            if (Username.Trim().Length <= 0)
                errors.Append("Username é obrigatório");
            if (Password.Trim().Length <= 0)
                errors.AppendLine("\nSenha é obrigatória");

            if (errors.Length > 0)
                return Result.Fail(errors.ToString());

            return Result.Ok();
        }
    }
}