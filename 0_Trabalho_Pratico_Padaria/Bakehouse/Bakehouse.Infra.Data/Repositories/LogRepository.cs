using Bakehouse.Domain.Entities;
using Bakehouse.Infra.Data.Context;
using System;
using System.Threading.Tasks;

namespace Bakehouse.Infra.Data.Repositories
{
    public static class LogRepository
    {
        public static async Task RegisterLog(string description, string exception, string place)
        {
            ApplicationDbContext db = ApplicationDbContext.GetInstance();
            try
            {
                Log log = new Log
                {
                    Description = description,
                    Exception = exception,
                    Place = place,
                    CreatedAt = DateTime.Now,
                };

                db.Logs.Add(log);
                await db.SaveChangesAsync();
            }
            catch (Exception)
            {
            }
        }
    }
}
