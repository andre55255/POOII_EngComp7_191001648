using Bakehouse.Domain.Entities;
using Bakehouse.Helpers;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;

namespace Bakehouse.Infra.Data.EntitiesConfiguration
{
    public class UserConfiguration : IEntityTypeConfiguration<User>
    {
        public void Configure(EntityTypeBuilder<User> builder)
        {
            builder.Property(x => x.Username).HasMaxLength(255).IsRequired();
            builder.Property(x => x.Email).HasMaxLength(255).IsRequired();
            builder.Property(x => x.Contacts).HasMaxLength(255).IsRequired(false);
            builder.Property(x => x.HashPassword).HasMaxLength(255).IsRequired();
            builder.Property(x => x.Status).IsRequired();
            builder.Property(x => x.LockoutEnd).IsRequired();
            builder.Property(x => x.TokenResetPassword).HasMaxLength(500).IsRequired(false);

            // Adicionando um usuário padrão
            builder.HasData(new User
            {
                Id = 1,
                Email = "admin@bakehouse.com.br",
                Username = "ADMIN",
                HashPassword = StaticMethods.CryptPassword("admin123!"),
                Contacts = null,
                Status = false,
                LockoutEnd = 0,
                TokenResetPassword = null,
                RoleId = 1,
                CreatedAt = DateTime.Now,
                UpdatedAt = DateTime.Now,
                DisabledAt = null
            });
        }
    }
}
