using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class OrderPadConfiguration : IEntityTypeConfiguration<OrderPad>
    {
        public void Configure(EntityTypeBuilder<OrderPad> builder)
        {
            builder.Property(x => x.DateHour).IsRequired();
        }
    }
}