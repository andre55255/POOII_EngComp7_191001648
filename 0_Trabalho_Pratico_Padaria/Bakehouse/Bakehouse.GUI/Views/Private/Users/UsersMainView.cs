using Bakehouse.App.BBLs;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.GUI.Utils;
using Bakehouse.Infra.Data.Repositories;
using System;
using System.Collections.Generic;
using System.Data;
using System.Threading;
using System.Windows.Forms;

namespace Bakehouse.GUI.Views.Private
{
    public partial class UsersMainView : Form
    {
        private UserBBL _userBBL;

        public UsersMainView()
        {
            _userBBL = new UserBBL();

            InitializeComponent();
            RenderTable();
        }

        public async void RenderTable()
        {
            try
            {
                dataGridUsers.Rows.Clear();
                List<UserVO> listUsers = await _userBBL.FindAllUsers();
                
                foreach (UserVO user in listUsers)
                {
                    string disabledAtStr = user.DisabledAt.HasValue ?
                                           user.DisabledAt.Value.ToString("dd/MM/yyyy HH:mm") :
                                           "Ativo";

                    dataGridUsers.Rows.Add(user.Id, user.Username, user.Email,
                                           user.Role, user.CreatedAt.ToString("dd/MM/yyyy HH:mm"), 
                                           disabledAtStr);
                }
            }
            catch (Exception)
            {
                MessageBoxCustom.Error("Ocorreu um erro ao renderizar dados na tabela");
            }
        }

        private async void btnCreateUser_Click(object sender, EventArgs e)
        {
            try
            {
                Thread thread = new Thread(OpenWindowNewUserView);
                thread.SetApartmentState(ApartmentState.STA);
                thread.Start();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Erro ao abrir janela de recuperacao de senha, geração de token",
                                                ex.Message,
                                                this.GetType().ToString());
                MessageBoxCustom.Error("Erro inesperado");
            }
        }

        private void OpenWindowNewUserView()
        {
            Application.Run(new NewUserView());
        }

        private void refreshTable_Click(object sender, EventArgs e)
        {
            RenderTable();
        }
    }
}