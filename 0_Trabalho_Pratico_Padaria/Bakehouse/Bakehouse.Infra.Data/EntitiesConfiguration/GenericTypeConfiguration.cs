using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class GenericTypeConfiguration : IEntityTypeConfiguration<GenericType>
    {
        public void Configure(EntityTypeBuilder<GenericType> builder)
        {
            builder.Property(x => x.Description).HasMaxLength(255).IsRequired(false);
            builder.Property(x => x.Token).HasMaxLength(255).IsRequired();
            builder.Property(x => x.Value).IsRequired(false);
        }
    }
}