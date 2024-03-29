﻿using Bakehouse.App.BBLs;
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
    public partial class ResetPasswordGenerateToken : Form
    {
        private string _usernameRes;
        private string _emailRes;

        public ResetPasswordGenerateToken()
        {
            InitializeComponent();
            _usernameRes = "";
            _emailRes = "";
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

        private void OpenWindowResetPasswordTo()
        {
            Application.Run(new ResetPasswordTo(_emailRes, _usernameRes));
        }

        private async void btnContinue_Click(object sender, EventArgs e)
        {
            try
            {
                UserBBL userBBL = new UserBBL();

                string username = txtUsername.Text;

                Result result = await userBBL.ResetPasswordGenerateToken(username);

                if (result.IsSuccess)
                {
                    _usernameRes = result.Successes.FirstOrDefault().Message.Split(",")[0];
                    _emailRes = result.Successes.FirstOrDefault().Message.Split(",")[1];

                    MessageBoxCustom.Success("Enviado email para: " + _emailRes + ", contendo o token de recuperação de senha");

                    this.Close();
                    Thread thread = new Thread(OpenWindowResetPasswordTo);
                    thread.SetApartmentState(ApartmentState.STA);
                    thread.Start();
                }
                else
                {
                    MessageBoxCustom.Error(result.Errors.FirstOrDefault().Message);
                }
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog("Ocorreu um erro ao processar tela de recuperação de senha, gerar token",
                                          ex.Message,
                                          this.GetType().ToString());
                MessageBoxCustom.Error("Erro inesperado");
            }
        }
    }
}
