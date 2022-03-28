using Bakehouse.Helpers;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bakehouse.GUI.Views.Private
{
    public partial class Home : Form
    {
        private UserApplicationSingleton _user;

        public Home()
        {
            InitializeComponent();

            _user = UserApplicationSingleton.GetInstance();
            lblUsername.Text += _user.Username;
            lblRole.Text = _user.Role;
        }

        private void btnHome_MouseEnter(object sender, EventArgs e)
        {
            btnHome.BackColor = Color.DarkSlateBlue;
        }

        private void btnHome_MouseLeave(object sender, EventArgs e)
        {
            btnHome.BackColor = Color.FromArgb(((int)(((byte)(24)))), ((int)(((byte)(30)))), ((int)(((byte)(54)))));
        }

        private void btnProducts_MouseEnter(object sender, EventArgs e)
        {
            btnProducts.BackColor = Color.DarkSlateBlue;
        }

        private void btnProducts_MouseLeave(object sender, EventArgs e)
        {
            btnProducts.BackColor = Color.FromArgb(((int)(((byte)(24)))), ((int)(((byte)(30)))), ((int)(((byte)(54)))));
        }

        private void btnSells_MouseEnter(object sender, EventArgs e)
        {
            btnSells.BackColor = Color.DarkSlateBlue;
        }

        private void btnSells_MouseLeave(object sender, EventArgs e)
        {
            btnSells.BackColor = Color.FromArgb(((int)(((byte)(24)))), ((int)(((byte)(30)))), ((int)(((byte)(54)))));
        }

        private void btnWorksheet_MouseEnter(object sender, EventArgs e)
        {
            btnWorksheet.BackColor = Color.DarkSlateBlue;
        }

        private void btnWorksheet_MouseLeave(object sender, EventArgs e)
        {
            btnWorksheet.BackColor = Color.FromArgb(((int)(((byte)(24)))), ((int)(((byte)(30)))), ((int)(((byte)(54)))));
        }

        private void btnUsers_MouseEnter(object sender, EventArgs e)
        {
            btnUsers.BackColor = Color.DarkSlateBlue;
        }

        private void btnUsers_MouseLeave(object sender, EventArgs e)
        {
            btnUsers.BackColor = Color.FromArgb(((int)(((byte)(24)))), ((int)(((byte)(30)))), ((int)(((byte)(54)))));
        }

        private void btnLogout_MouseEnter(object sender, EventArgs e)
        {
            btnLogout.BackColor = Color.DarkRed;
        }

        private void btnLogout_MouseLeave(object sender, EventArgs e)
        {
            btnLogout.BackColor = Color.Firebrick;
        }
    }
}
