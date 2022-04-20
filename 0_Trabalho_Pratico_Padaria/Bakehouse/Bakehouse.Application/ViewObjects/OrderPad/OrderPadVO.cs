using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.OrderPad
{
    public class OrderPadVO
    {
        public int Id { get; set; }
        public DateTime DateHour { get; set; }
        public int UserId { get; set; }

        public Result Valid()
        {
            try
            {
                if (UserId <= 0)
                    return Result.Fail("ID do usuário deve ser informado");

                return Result.Ok();
            }
            catch (Exception)
            {
                return Result.Fail("Ocorreu um erro inesperado na validação");
            }
        }
    }
}