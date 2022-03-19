using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class OrderPadItemConfiguration : IEntityTypeConfiguration<OrderPadItem>
    {
        public void Configure(EntityTypeBuilder<OrderPadItem> builder)
        {
            builder.Property(x => x.Quantity).HasPrecision(10, 2).IsRequired();
            builder.Property(x => x.ValueUnitary).HasPrecision(10, 2).IsRequired();
        }
    }
}