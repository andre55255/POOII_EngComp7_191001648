using Bakehouse.App.ViewObjects.Role;
using Bakehouse.Domain.Entities;
using Bakehouse.Helpers;
using Bakehouse.Infra.Data.Repositories;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Bakehouse.App.BBLs
{
    public class RoleBBL
    {
        private RoleRepository _roleRepo;

        public RoleBBL()
        {
            _roleRepo = new RoleRepository();
        }

        public async Task<List<ReadRoleVO>> FindAllRoles()
        {
            try
            {
                List<Role> rolesDB = await _roleRepo.FindAllAsync();
                List<ReadRoleVO> listRoles = new List<ReadRoleVO>();

                foreach (Role role in rolesDB)
                {
                    ReadRoleVO aux = new ReadRoleVO
                    {
                        Id = role.Id,
                        Description = role.Description
                    };

                    listRoles.Add(aux);
                }

                return listRoles;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesRole.ErrorBBLFindAll,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }
    }
}