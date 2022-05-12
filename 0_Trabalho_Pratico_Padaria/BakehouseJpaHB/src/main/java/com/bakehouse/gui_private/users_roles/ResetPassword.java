package com.bakehouse.gui_private.users_roles;

import com.bakehouse.domain.User;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import java.awt.Component;

public class ResetPassword extends javax.swing.JFrame {

    private User user;
    
    public ResetPassword() {
        initComponents();
    }
    
    public ResetPassword(User user) {
        initComponents();
        this.user = user;
        jlTitleUser.setText(jlTitleUser.getText()+user.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitleUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jtfPassConfirm = new javax.swing.JPasswordField();
        jcbShowPassword = new javax.swing.JCheckBox();
        jbResetPasswordUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redefinir senha");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setName("frameResetPassword"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlTitleUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlTitleUser.setForeground(new java.awt.Color(250, 150, 0));
        jlTitleUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitleUser.setText("REDEFINIR A SENHA, USUÁRIO: ");
        jlTitleUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 150, 0));
        jLabel7.setText("Nova Senha");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfPass.setBackground(new java.awt.Color(240, 240, 240));
        jtfPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfPass.setForeground(new java.awt.Color(10, 16, 26));
        jtfPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 221), 1, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 150, 0));
        jLabel8.setText("Confirme a senha");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jtfPassConfirm.setBackground(new java.awt.Color(240, 240, 240));
        jtfPassConfirm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfPassConfirm.setForeground(new java.awt.Color(10, 16, 26));
        jtfPassConfirm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 221), 1, true));

        jcbShowPassword.setBackground(new java.awt.Color(255, 255, 255));
        jcbShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbShowPassword.setForeground(new java.awt.Color(250, 150, 0));
        jcbShowPassword.setText("Mostrar senhas");
        jcbShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbShowPassword.setFocusable(false);
        jcbShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbShowPasswordActionPerformed(evt);
            }
        });

        jbResetPasswordUser.setBackground(new java.awt.Color(36, 162, 73));
        jbResetPasswordUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbResetPasswordUser.setForeground(new java.awt.Color(255, 255, 255));
        jbResetPasswordUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-lock.png"))); // NOI18N
        jbResetPasswordUser.setText("Redefinir a senha");
        jbResetPasswordUser.setAlignmentX(0.5F);
        jbResetPasswordUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbResetPasswordUser.setBorderPainted(false);
        jbResetPasswordUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbResetPasswordUser.setFocusable(false);
        jbResetPasswordUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbResetPasswordUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbResetPasswordUser.setName(""); // NOI18N
        jbResetPasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetPasswordUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addComponent(jtfPass)
                    .addComponent(jtfPassConfirm)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 663, Short.MAX_VALUE))
                    .addComponent(jcbShowPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbResetPasswordUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbShowPassword)
                .addGap(18, 18, 18)
                .addComponent(jbResetPasswordUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbShowPasswordActionPerformed
        if (jcbShowPassword.isSelected())
        {
            jtfPass.setEchoChar((char) 0);
            jtfPassConfirm.setEchoChar((char) 0);
        } else
        {
            jtfPass.setEchoChar('*');
            jtfPassConfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_jcbShowPasswordActionPerformed

    private void jbResetPasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetPasswordUserActionPerformed
        try {
            String pass = String.valueOf(jtfPass.getPassword());
            String passConfirm = String.valueOf(jtfPassConfirm.getPassword());
            if (!pass.equals(passConfirm)) {
                new EmitAlert(this, "Senhas não conferem").warning();
                return;
            }
            CreateEditUserVO userVO = new CreateEditUserVO();
            userVO.setId(user.getId());
            userVO.setLogin(user.getLogin());
            userVO.setName(user.getName());
            userVO.setPassword(pass);
            userVO.setRole(user.getRole());
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            IAccountService accService = new AccountService();
            Thread t = new Thread(){
                @Override
                public void run() {
                    Result result = accService.editUser(userVO);
                    loadGui.dispose();
                    if (!result.isSuccess()) {
                        new EmitAlert(compThis, result.getMessage()).error();
                        return;
                    }
                    new EmitAlert(compThis, "Senha redefinida com sucesso").success();
                    compThis.setVisible(false);
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbResetPasswordUserActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new ResetPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbResetPasswordUser;
    private javax.swing.JCheckBox jcbShowPassword;
    private javax.swing.JLabel jlTitleUser;
    private javax.swing.JPasswordField jtfPass;
    private javax.swing.JPasswordField jtfPassConfirm;
    // End of variables declaration//GEN-END:variables
}
