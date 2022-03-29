using Bakehouse.App.BBLs;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.GUI.Utils;
using Bakehouse.GUI.Views.Private;
using Bakehouse.GUI.Views.Public;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bakehouse.GUI
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void cbShowPass_CheckedChanged(object sender, EventArgs e)
        {
            if (cbShowPass.Checked)
                txtPassword.UseSystemPasswordChar = false;
            else
                txtPassword.UseSystemPasswordChar = true;
        }

        private void lblResetPassword_MouseEnter(object sender, EventArgs e)
        {
            lblResetPassword.ForeColor = Color.DarkRed;
        }

        private void lblResetPassword_MouseLeave(object sender, EventArgs e)
        {
            lblResetPassword.ForeColor = Color.RoyalBlue;
        }

        private async void btnSignIn_Click(object sender, EventArgs e)
        {
            try
            {
                UserBBL userBBL = new UserBBL();

                string username = txtUsername.Text;
                string password = txtPassword.Text;
                SignInUserVO userVO = new SignInUserVO
                {
                    Username = username,
                    Password = password,
                };

                Result result = await userBBL.SignInAsync(userVO);
                if (result.IsSuccess)
                {
                    MessageBoxCustom.Success("Login efetuado com sucesso");

                    this.Close();
                    Thread thread = new Thread(OpenWindowHome);
                    thread.SetApartmentState(ApartmentState.STA);
                    thread.Start();
                }
                else
                {
                    string error = result.Errors.FirstOrDefault().Message;
                    MessageBoxCustom.Error(error);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Erro inesperado na tela de login, username: " + txtUsername.Text,
                                          ex.Message,
                                          this.GetType().ToString());
                MessageBoxCustom.Error("Erro inesperado");
            }
        }

        private async void lblResetPassword_Click(object sender, EventArgs e)
        {
            try
            {
                this.Close();
                Thread thread = new Thread(OpenWindowResetPasswordGenerateToken);
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

        private void OpenWindowResetPasswordGenerateToken()
        {
            Application.Run(new ResetPasswordGenerateToken());
        }

        private void OpenWindowHome()
        {
            Application.Run(new Template());
        }
    }
}
