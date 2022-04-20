using FluentResults;
using System;

namespace Bakehouse.App.ViewObjects.Movement
{
    public class MovementVO
    {
        public int Id { get; set; }
        public string Description { get; set; }
        public DateTime DateHour { get; set; }
        public double TotalValue { get; set; }
        public int GenericTypeId { get; set; }
        public int UserId { get; set; }

        public Result Valid()
        {
            try
            {
                if (Description.Trim().Length > 255 || Description.Trim().Length <= 0)
                    return Result.Fail("Descrição da movimentação deve ter no máximo 255 caracteres");
                if (TotalValue <= 0)
                    return Result.Fail("O valor da movimentação deve ser maior que 0");
                if (GenericTypeId <= 0)
                    return Result.Fail("Tipo de movimentação deve ser informado");
                if (UserId <= 0)
                    return Result.Fail("ID do usuário que fez o movimento deve ser informado");

                return Result.Ok();
            }
            catch (Exception)
            {
                return Result.Fail("Ocorreu um erro inesperado na validação");
            }
        }
    }
}