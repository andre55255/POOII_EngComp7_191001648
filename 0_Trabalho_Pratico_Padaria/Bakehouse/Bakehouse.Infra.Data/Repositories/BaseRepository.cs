using Bakehouse.Infra.Data.Context;

namespace Bakehouse.Infra.Data.Repositories
{
    public abstract class BaseRepository
    {
        protected ApplicationDbContext _db;

        public BaseRepository()
        {
            _db = new ApplicationDbContext();
        }
    }
}