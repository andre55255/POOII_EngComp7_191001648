package com.bakehouse.gui_private.users_roles;

import com.bakehouse.dao.impl.RoleDAOImpl;
import com.bakehouse.dao.interfaces.IRoleDAO;
import com.bakehouse.domain.Role;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class CreateUser extends javax.swing.JFrame {

    private List<Role> roles = new ArrayList<>();
    
    public CreateUser() {
        initComponents();
        loadRolesComboBox();
    }

    private void loadRolesComboBox() {
        try
        {
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            IRoleDAO roleDao = new RoleDAOImpl();
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    roles = roleDao.findAll();
                    for (Role role : roles)
                    {
                        jcbRolesUsers.addItem(role.getDescription());
                    }
                    loadGui.dispose();
                }
            };
            t1.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Erro ao carregar perfis").error();
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfPass = new javax.swing.JPasswordField();
        jtfPassConfirm = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jcbShowPassword = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jcbRolesUsers = new javax.swing.JComboBox<>();
        jbCreateUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar usuário");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setName("frameCreateUser"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CRIAR USUÁRIO");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 0));
        jLabel5.setText("Login");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfLogin.setBackground(new java.awt.Color(240, 240, 240));
        jtfLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfLogin.setForeground(new java.awt.Color(10, 16, 26));
        jtfLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfLogin.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jtfName.setBackground(new java.awt.Color(240, 240, 240));
        jtfName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfName.setForeground(new java.awt.Color(10, 16, 26));
        jtfName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfName.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 150, 0));
        jLabel6.setText("Nome completo");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 150, 0));
        jLabel7.setText("Senha");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfPass.setBackground(new java.awt.Color(240, 240, 240));
        jtfPass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfPass.setForeground(new java.awt.Color(10, 16, 26));
        jtfPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 221), 1, true));

        jtfPassConfirm.setBackground(new java.awt.Color(240, 240, 240));
        jtfPassConfirm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfPassConfirm.setForeground(new java.awt.Color(10, 16, 26));
        jtfPassConfirm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 221), 1, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 150, 0));
        jLabel8.setText("Confirme sua senha");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

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

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 150, 0));
        jLabel9.setText("Perfil");
        jLabel9.setAlignmentX(365.0F);
        jLabel9.setAlignmentY(23.0F);

        jcbRolesUsers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbRolesUsers.setForeground(new java.awt.Color(10, 16, 26));
        jcbRolesUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um perfil" }));
        jcbRolesUsers.setToolTipText("");
        jcbRolesUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jbCreateUser.setBackground(new java.awt.Color(36, 162, 73));
        jbCreateUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbCreateUser.setForeground(new java.awt.Color(255, 255, 255));
        jbCreateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbCreateUser.setText("Criar");
        jbCreateUser.setAlignmentX(0.5F);
        jbCreateUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbCreateUser.setBorderPainted(false);
        jbCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCreateUser.setFocusable(false);
        jbCreateUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbCreateUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbCreateUser.setName(""); // NOI18N
        jbCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfLogin)
                    .addComponent(jtfName)
                    .addComponent(jtfPass)
                    .addComponent(jtfPassConfirm)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 661, Short.MAX_VALUE))
                    .addComponent(jcbShowPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbRolesUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCreateUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbRolesUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
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
                .addComponent(jbCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jbCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateUserActionPerformed
        try {
            String login = jtfLogin.getText();
            String name = jtfName.getText();
            String pass = String.valueOf(jtfPass.getPassword());
            String passConfirm = String.valueOf(jtfPassConfirm.getPassword());
            int indexRole = jcbRolesUsers.getSelectedIndex();
            if (indexRole == 0) {
                new EmitAlert(this, "Selecione o perfil").warning();
                return;
            }
            Role role = this.roles.get(indexRole-1);
            if (!pass.equals(passConfirm)) {
                new EmitAlert(this, "Senhas não conferem").warning();
                return;
            }
            if (role == null) {
                new EmitAlert(this, "Perfil não encontrado ou não informado").warning();
                return;
            }
            CreateEditUserVO userVO = new CreateEditUserVO();
            userVO.setId(-1);
            userVO.setLogin(login);
            userVO.setName(name);
            userVO.setPassword(pass);
            userVO.setRole(role);
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Component compThis = this;
            IAccountService accService = new AccountService();
            Thread t = new Thread() {
                @Override
                public void run() {
                    Result result = accService.createUser(userVO);
                    loadGui.dispose();
                    if (result.isSuccess()) {
                        new EmitAlert(compThis, "Usuário criado com sucesso").success();
                        compThis.setVisible(false);
                    } else {
                        new EmitAlert(compThis, result.getMessage()).error();
                    }
                }
            };
            t.start();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Ocorreu um erro ao buscar perfil selecionado").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbCreateUserActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() ->
        {
            new CreateUser().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCreateUser;
    private javax.swing.JComboBox<String> jcbRolesUsers;
    private javax.swing.JCheckBox jcbShowPassword;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfName;
    private javax.swing.JPasswordField jtfPass;
    private javax.swing.JPasswordField jtfPassConfirm;
    // End of variables declaration//GEN-END:variables
}
