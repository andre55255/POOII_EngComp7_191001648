using FluentResults;
using System.Text;

namespace Bakehouse.App.ViewObjects.User
{
    public class ResetPasswordUserVO
    {
        public string Username { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public string RePassword { get; set; }

        public Result Valid()
        {
            StringBuilder errors = new StringBuilder();
            if (Username == null || Username.Trim().Length <= 0)
                errors.AppendLine("Nome do usuário deve ser informado.");
            if (Email == null || Email.Trim().Length <= 0)
                errors.AppendLine("Email do usuário deve ser informado.");
            if (Password == null || Password.Trim().Length <= 0)
                errors.AppendLine("Senha deve ser informada.");
            if (RePassword == null || RePassword.Trim().Length <= 0)
                errors.AppendLine("Confirmação de senha deve ser informada.");
            if (Password != RePassword)
                errors.AppendLine("Senhas não conferem");

            if (errors.Length > 0)
                return Result.Fail(errors.ToString());

            return Result.Ok();
        }
    }
}