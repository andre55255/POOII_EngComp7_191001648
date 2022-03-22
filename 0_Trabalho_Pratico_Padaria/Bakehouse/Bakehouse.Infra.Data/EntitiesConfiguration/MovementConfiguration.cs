using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class MovementConfiguration : IEntityTypeConfiguration<Movement>
    {
        public void Configure(EntityTypeBuilder<Movement> builder)
        {
            builder.Property(x => x.Description).HasMaxLength(255).IsRequired();
            builder.Property(x => x.DateHour).IsRequired();
            builder.Property(x => x.TotalValue).HasPrecision(10, 2).IsRequired();
            builder.Property(x => x.GenericTypeId).IsRequired();
        }
    }
}