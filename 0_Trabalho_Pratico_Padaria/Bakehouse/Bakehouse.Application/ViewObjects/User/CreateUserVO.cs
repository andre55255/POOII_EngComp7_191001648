using Bakehouse.Helpers;
using FluentResults;

namespace Bakehouse.App.ViewObjects.User
{
    public class CreateUserVO
    {
        public string Email { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string RePassword { get; set; }
        public string Contacts { get; set; }
        public int RoleId { get; set; }

        public Result Valid()
        {
            if (string.IsNullOrEmpty(Email))
                return Result.Fail("Email não informado");
            if (!StaticMethods.EmailValid(Email))
                return Result.Fail("Email inválido");
            if (string.IsNullOrEmpty(Username))
                return Result.Fail("Nome de usuário deve ser informado");
            if (string.IsNullOrEmpty(Password))
                return Result.Fail("Senha deve ser informada");
            if (string.IsNullOrEmpty(RePassword))
                return Result.Fail("Confirmação de senha deve ser informada");
            if (Password != RePassword)
                return Result.Fail("Senhas não conferem");
            if (!StaticMethods.ValidPassword(Password))
                return Result.Fail("Senha deve conter entre 7 e 10 caracteres");
            if (RoleId <= 0)
                return Result.Fail("Perfil inválido");

            return Result.Ok();
        }
    }
}