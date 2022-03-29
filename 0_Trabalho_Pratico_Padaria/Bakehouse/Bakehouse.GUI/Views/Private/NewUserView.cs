using Bakehouse.App.BBLs;
using Bakehouse.App.ViewObjects.Role;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.GUI.Utils;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Bakehouse.GUI.Views.Private
{
    public partial class NewUserView : Form
    {
        private UserBBL _userBBL;
        private RoleBBL _roleBBL;

        public NewUserView()
        {
            _userBBL = new UserBBL();
            _roleBBL = new RoleBBL();

            InitializeComponent();
            LoadRolesComboBox();
        }

        private async void LoadRolesComboBox()
        {
            try
            {
                cbRole.Items.Clear();

                List<ReadRoleVO> roles = await _roleBBL.FindAllRoles();

                if (roles.Count <= 0)
                {
                    MessageBoxCustom.Error("Nenhum perfil cadastrado, contate o admnistrador do sistema");
                    return;
                }

                cbRole.Items.Add("Selecione um perfil");

                foreach (ReadRoleVO role in roles)
                {
                    cbRole.Items.Add(role.Id+"-"+role.Description);
                }
            }
            catch (Exception)
            {
                MessageBoxCustom.Error("Ocorreu um erro ao carregar perfis de usuário");
            }
        }

        private void cbShowPass_CheckedChanged(object sender, System.EventArgs e)
        {
            if (cbShowPass.Checked)
            {
                txtPassword.UseSystemPasswordChar = false;
                txtRePassword.UseSystemPasswordChar = false;
            }
            else
            {
                txtPassword.UseSystemPasswordChar = true;
                txtRePassword.UseSystemPasswordChar = true;
            }
        }

        private async void btnCreateUser_Click(object sender, EventArgs e)
        {
            try
            {
                string usernameInput = txtUsername.Text;
                string emailInput = txtEmail.Text;
                string contactsInput = txtContacts.Text;
                string passwordInput = txtPassword.Text;
                string rePasswordInput = txtRePassword.Text;

                if (cbRole.SelectedIndex <= 0)
                {
                    MessageBoxCustom.Alert("Selecione um perfil");
                    return;
                }
                int roleIdInput = int.Parse(cbRole.SelectedItem.ToString().Split("-")[0]);

                CreateUserVO userVO = new CreateUserVO
                {
                    Username = usernameInput,
                    Email = emailInput,
                    Contacts = contactsInput,
                    Password = passwordInput,
                    RePassword = rePasswordInput,
                    RoleId = roleIdInput
                };
                
                Result result = await _userBBL.CreateUser(userVO);
                if (result.IsFailed)
                {
                    MessageBoxCustom.Error(result.Errors.FirstOrDefault().Message);
                    return;
                }

                MessageBoxCustom.Success("Usuário inserido com sucesso");
                this.Close();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Erro ao criar usuário na tela NewUserView",
                                                ex.Message,
                                                this.GetType().ToString());

                MessageBoxCustom.Error("Erro inesperado ao criar usuário");
            }
        }
    }
}
