using Bakehouse.Domain.Entities;
using Bakehouse.Domain.Interfaces;
using Bakehouse.Helpers;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Bakehouse.Infra.Data.Repositories
{
    public class RoleRepository : BaseRepository, IRoleRepository
    {
        public async Task<Result> DeleteAsync(int id)
        {
            try
            {
                Role save = await FindByIdAsync(id);
                if (save == null)
                    return Result.Fail(ConstantsMessagesRole.ErrorInfraDataFindById);

                save.DisabledAt = null;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorInfraDataDelete,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesRole.ErrorInfraDataDelete);
            }
        }

        public async Task<List<Role>> FindAllAsync()
        {
            try
            {
                List<Role> response = await _db.Roles
                                               .Where(x => x.DisabledAt == null)
                                               .ToListAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorInfraDataDelete,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Role> FindByIdAsync(int id)
        {
            try
            {
                Role response = await _db.Roles
                                         .Where(x => x.Id == id && x.DisabledAt == null)
                                         .FirstOrDefaultAsync();

                return response;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorInfraDataFindById,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return null;
            }
        }

        public async Task<Result> InsertAsync(Role role)
        {
            try
            {
                role.CreatedAt = DateTime.Now;
                role.UpdatedAt = DateTime.Now;
                role.DisabledAt = null;

                _db.Roles.Add(role);
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(role.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorInfraDataInsert,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesRole.ErrorInfraDataInsert);
            }
        }

        public async Task<Result> UpdateAsync(int id, Role role)
        {
            try
            {
                Role save = await FindByIdAsync(id);

                save.Description = role.Description;
                save.UpdatedAt = DateTime.Now;

                _db.Entry(save).State = EntityState.Modified;
                await _db.SaveChangesAsync();

                return Result.Ok().WithSuccess(save.Id.ToString());
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorInfraDataUpdate,
                                                  ex.Message,
                                                  this.GetType().ToString());

                return Result.Fail(ConstantsMessagesRole.ErrorInfraDataUpdate);
            }
        }
    }
}