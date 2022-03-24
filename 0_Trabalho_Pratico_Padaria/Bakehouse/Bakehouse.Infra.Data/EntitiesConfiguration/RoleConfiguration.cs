using Bakehouse.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class RoleConfiguration : IEntityTypeConfiguration<Role>
    {
        public void Configure(EntityTypeBuilder<Role> builder)
        {
            builder.Property(x => x.Description).HasMaxLength(255).IsRequired();

            // Adicionando uma role padrão
            builder.HasData(new Role
            {
                Id = 1,
                Description = "ADMIN",
                CreatedAt = DateTime.Now,
                UpdatedAt = DateTime.Now,
                DisabledAt = null
            });
        }
    }
}
