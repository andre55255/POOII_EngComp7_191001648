﻿using Bakehouse.App.BBLs;
using Bakehouse.App.ViewObjects.User;
using Bakehouse.GUI.Utils;
using FluentResults;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
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
            UserBBL userBBL = new UserBBL();

            string username = txtUsername.Text;
            string password = txtPassword.Text;
            CreateUserVO userVO = new CreateUserVO
            {
                Username = username,
                Password = password,
            };

            Result result = await userBBL.SignInAsync(userVO);
            if (result.IsSuccess)
            {
                // Abre outra tela
                MessageBoxCustom.Success("Login efetuado com sucesso");
            }
            else
            {
                string error = result.Errors.FirstOrDefault().Message;
                MessageBoxCustom.Error(error);
            }
        }
    }
}
