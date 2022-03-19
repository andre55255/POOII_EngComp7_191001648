using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class LogConfiguration : IEntityTypeConfiguration<Log>
    {
        public void Configure(EntityTypeBuilder<Log> builder)
        {
            builder.Property(x => x.Description).HasMaxLength(1024).IsRequired();
            builder.Property(x => x.Exception).HasMaxLength(1024).IsRequired();
            builder.Property(x => x.Place).HasMaxLength(1024).IsRequired();
            builder.Property(x => x.CreatedAt).IsRequired();
        }
    }
}