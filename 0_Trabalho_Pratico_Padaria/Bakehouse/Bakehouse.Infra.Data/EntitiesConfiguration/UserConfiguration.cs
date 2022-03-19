using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class UserConfiguration : IEntityTypeConfiguration<User>
    {
        public void Configure(EntityTypeBuilder<User> builder)
        {
            builder.Property(x => x.Username).HasMaxLength(255).IsRequired();
            builder.Property(x => x.HashPassword).HasMaxLength(255).IsRequired();
            builder.Property(x => x.Status).IsRequired();
            builder.Property(x => x.LockoutEnd).IsRequired();
            builder.Property(x => x.TokenResetPassword).HasMaxLength(500).IsRequired();
        }
    }
}
