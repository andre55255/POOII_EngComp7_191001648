using Bakehouse.Domain.Entities;
using Bakehouse.Infra.Data.EntitiesConfiguration;
using Microsoft.EntityFrameworkCore;

namespace Bakehouse.Infra.Data.Context
{
    public class ApplicationDbContext : DbContext
    {
        public DbSet<Category> Categories { get; set; }
        public DbSet<Log> Logs { get; set; }
        public DbSet<Movement> Movements { get; set; }
        public DbSet<OrderPad> OrderPads { get; set; }
        public DbSet<OrderPadItem> OrderPadItems { get; set; }
        public DbSet<Product> Products { get; set; }
        public DbSet<Role> Roles { get; set; }
        public DbSet<UnitOfMeasurement> UnitOfMeasurements { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySQL("server=localhost;database=bakehouse_db;user=root;password=root");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.ApplyConfiguration(new CategoryConfiguration());
            modelBuilder.ApplyConfiguration(new MovementConfiguration());
            modelBuilder.ApplyConfiguration(new OrderPadConfiguration());
            modelBuilder.ApplyConfiguration(new OrderPadItemConfiguration());
            modelBuilder.ApplyConfiguration(new ProductConfiguration());
            modelBuilder.ApplyConfiguration(new RoleConfiguration());
            modelBuilder.ApplyConfiguration(new UnitOfMeasurementConfiguration());
            modelBuilder.ApplyConfiguration(new UserConfiguration());
        }
    }
}