using Bakehouse.App.BBLs;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.GUI.Utils;
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

namespace Bakehouse.GUI.Views.Public
{
    public partial class ResetPasswordTo : Form
    {
        private string _username;
        private string _email;

        public ResetPasswordTo()
        {
            InitializeComponent();
            _username = "";
            _email = "";
        }

        public ResetPasswordTo(string email, string username)
        {
            InitializeComponent();

            _username = username;
            _email = email;

            txtUsername.Text = _username;
        }

        private void lblBackToLogin_MouseEnter(object sender, EventArgs e)
        {
            lblBackToLogin.ForeColor = Color.DarkRed;
        }

        private void lblBackToLogin_MouseLeave(object sender, EventArgs e)
        {
            lblBackToLogin.ForeColor = Color.RoyalBlue;
        }

        private async void lblBackToLogin_Click(object sender, EventArgs e)
        {
            try
            {
                this.Close();
                Thread thread = new Thread(OpenWindowLogin);
                thread.SetApartmentState(ApartmentState.STA);
                thread.Start();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Erro ao abrir janela de login",
                                          ex.Message,
                                          this.GetType().ToString());
                MessageBoxCustom.Error("Erro inesperado");
            }
        }

        private void OpenWindowLogin()
        {
            Application.Run(new Login());
        }

        private async void btnResetPassword_Click(object sender, EventArgs e)
        {
            try
            {
                UserBBL userBBL = new UserBBL();
                
                string token = txtToken.Text;
                string password = txtPassword.Text;
                string rePassword = txtRePassword.Text;

                ResetPasswordUserVO userVO = new ResetPasswordUserVO
                {
                    Email = _email,
                    Username = _username,
                    Token = token,
                    Password = password,
                    RePassword = rePassword
                };

                Result result = await userBBL.ResetPasswordTo(userVO);

                if (result.IsSuccess)
                {
                    MessageBoxCustom.Success("Senha redefinida com sucesso");

                    this.Close();
                    Thread t = new Thread(OpenWindowLogin);
                    t.SetApartmentState(ApartmentState.STA);
                    t.Start();
                }
                else
                {
                    MessageBoxCustom.Error(result.Errors.FirstOrDefault().Message);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Erro ao trocar senhas",
                                          ex.Message,
                                          this.GetType().ToString());
                MessageBoxCustom.Error("Erro inesperado");
            }
        }

        private void cbShowPass_CheckedChanged(object sender, EventArgs e)
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
    }
}
