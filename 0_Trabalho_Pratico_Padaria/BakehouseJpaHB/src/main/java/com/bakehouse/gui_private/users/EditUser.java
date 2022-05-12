package com.bakehouse.gui_private.users;

import com.bakehouse.dao.impl.RoleDAOImpl;
import com.bakehouse.dao.interfaces.IRoleDAO;
import com.bakehouse.domain.Role;
import com.bakehouse.domain.User;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.CreateEditUserVO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class EditUser extends javax.swing.JFrame {

    private List<Role> roles = new ArrayList<>();
    private User user;

    public EditUser() {
        initComponents();
    }
    
    public EditUser(User user) {
        initComponents();

        this.user = user;
        loadRolesComboBox();
        loadInfoUser();
    }

    private void loadInfoUser() {
        try
        {
            jtfId.setText(user.getId() + "");
            jtfLogin.setText(user.getLogin());
            jtfName.setText(user.getName());
            
            int indexRoleCbx = -1;
            for (Role role : this.roles) {
                indexRoleCbx++;
                if (role.getId() == user.getRole().getId()) {
                    break;
                }
            }
            jcbRolesUsers.setSelectedIndex(indexRoleCbx+1);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar informações de usuário selecionado").error();
            this.dispose();
        }
    }

    private void loadRolesComboBox() {
        try
        {
            IRoleDAO roleDao = new RoleDAOImpl();
            this.roles = roleDao.findAll();
            for (Role role : roles)
            {
                jcbRolesUsers.addItem(role.getDescription());
            }
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
        jtfId = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbRolesUsers = new javax.swing.JComboBox<>();
        jbEditUser = new javax.swing.JButton();
        jtfLogin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar usuário");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setName("frameCreateUser"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EDITAR USUÁRIO");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 0));
        jLabel5.setText("Id");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfId.setEditable(false);
        jtfId.setBackground(new java.awt.Color(240, 240, 240));
        jtfId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfId.setForeground(new java.awt.Color(10, 16, 26));
        jtfId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfId.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtfId.setEnabled(false);
        jtfId.setMargin(new java.awt.Insets(25, 10, 25, 10));

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

        jbEditUser.setBackground(new java.awt.Color(36, 162, 73));
        jbEditUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbEditUser.setForeground(new java.awt.Color(255, 255, 255));
        jbEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-edit.png"))); // NOI18N
        jbEditUser.setText("Editar");
        jbEditUser.setAlignmentX(0.5F);
        jbEditUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbEditUser.setBorderPainted(false);
        jbEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditUser.setFocusable(false);
        jbEditUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbEditUser.setName(""); // NOI18N
        jbEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditUserActionPerformed(evt);
            }
        });

        jtfLogin.setBackground(new java.awt.Color(240, 240, 240));
        jtfLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfLogin.setForeground(new java.awt.Color(10, 16, 26));
        jtfLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfLogin.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 150, 0));
        jLabel10.setText("Login");
        jLabel10.setAlignmentX(365.0F);
        jLabel10.setAlignmentY(23.0F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfId)
                    .addComponent(jtfName)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 683, Short.MAX_VALUE))
                    .addComponent(jcbRolesUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEditUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfLogin))
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
                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
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
                .addGap(18, 18, 18)
                .addComponent(jbEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditUserActionPerformed
        try
        {
            int id = Integer.parseInt(jtfId.getText());
            String login = jtfLogin.getText();
            String name = jtfName.getText();
            int indexRole = jcbRolesUsers.getSelectedIndex();
            if (indexRole == 0)
            {
                new EmitAlert(this, "Selecione o perfil").warning();
                return;
            }
            Role role = this.roles.get(indexRole - 1);
            if (role == null)
            {
                new EmitAlert(this, "Perfil não encontrado ou não informado").warning();
                return;
            }
            CreateEditUserVO userVO = new CreateEditUserVO();
            userVO.setId(id);
            userVO.setLogin(login);
            userVO.setName(name);
            userVO.setRole(role);
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Component compThis = this;
            IAccountService accService = new AccountService();
            Thread t = new Thread() {
                @Override
                public void run() {
                    Result result = accService.editUser(userVO);
                    loadGui.dispose();
                    if (result.isSuccess())
                    {
                        new EmitAlert(compThis, "Usuário editado com sucesso").success();
                        compThis.setVisible(false);
                    } else
                    {
                        new EmitAlert(compThis, result.getMessage()).error();
                    }
                }
            };
            t.start();
        } catch (NumberFormatException ex)
        {
            new EmitAlert(this, "Ocorreu um erro ao buscar perfil selecionado").error();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbEditUserActionPerformed

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
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                new EditUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbEditUser;
    private javax.swing.JComboBox<String> jcbRolesUsers;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}
