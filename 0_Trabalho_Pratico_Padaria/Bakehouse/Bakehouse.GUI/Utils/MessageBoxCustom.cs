using System.Windows.Forms;

namespace Bakehouse.GUI.Utils
{
    public static class MessageBoxCustom
    {
        public static void Alert(string msg)
        {
            MessageBox.Show(msg, "Alerta", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }

        public static void Error(string msg)
        {
            MessageBox.Show(msg, "Erro", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        public static void Success(string msg)
        {
            MessageBox.Show(msg, "Sucesso", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
    }
}