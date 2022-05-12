package com.bakehouse.gui_private.users_roles;

import com.bakehouse.domain.Role;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.RoleVO;
import java.awt.Component;

public class EditRole extends javax.swing.JFrame {
    
    private Role role;
    
    public EditRole() {
        initComponents();
    }
    
    public EditRole(Role role) {
        initComponents();
        
        this.role = role;
        loadInputsFromRole();
    }
    
    private void loadInputsFromRole() {
        try
        {
            jtfId.setText(role.getId() + "");
            jtfDescription.setText(role.getDescription());
        } catch (Exception ex)
        {
            new EmitAlert(this, "Ocorreu um erro ao carregar os dados do perfil").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfDescription = new javax.swing.JTextField();
        jbEditRole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Perfil");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EDITAR PERFIL");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 0));
        jLabel5.setText("Id");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfId.setEditable(false);
        jtfId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfId.setForeground(new java.awt.Color(10, 16, 26));
        jtfId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfId.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jtfId.setEnabled(false);
        jtfId.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 150, 0));
        jLabel6.setText("Descrição");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jtfDescription.setBackground(new java.awt.Color(240, 240, 240));
        jtfDescription.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDescription.setForeground(new java.awt.Color(10, 16, 26));
        jtfDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDescription.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jbEditRole.setBackground(new java.awt.Color(36, 162, 73));
        jbEditRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbEditRole.setForeground(new java.awt.Color(255, 255, 255));
        jbEditRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-edit.png"))); // NOI18N
        jbEditRole.setText("Editar");
        jbEditRole.setAlignmentX(0.5F);
        jbEditRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbEditRole.setBorderPainted(false);
        jbEditRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditRole.setFocusable(false);
        jbEditRole.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditRole.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbEditRole.setName(""); // NOI18N
        jbEditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addComponent(jtfId)
                    .addComponent(jtfDescription)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbEditRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void jbEditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditRoleActionPerformed
        try
        {
            String description = jtfDescription.getText();
            if (description.equals(role.getDescription())) {
                new EmitAlert(this, "Dados iguais").warning();
                return;
            }
            RoleVO roleVO = new RoleVO();
            roleVO.setId(role.getId());
            roleVO.setDescription(role.getDescription());
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            IAccountService accService = new AccountService();
            Thread t = new Thread(){
                @Override
                public void run() {
                    Result result = accService.editRole(roleVO);
                    loadGui.dispose();
                    if (!result.isSuccess()){
                        new EmitAlert(compThis, result.getMessage()).error();
                        return;
                    }
                    new EmitAlert(compThis, "Perfil criado com sucesso").success();
                    compThis.setVisible(false);
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbEditRoleActionPerformed
    
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
            java.util.logging.Logger.getLogger(EditRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EditRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EditRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EditRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new EditRole().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbEditRole;
    private javax.swing.JButton jbEditUser;
    private javax.swing.JButton jbEditUser1;
    private javax.swing.JTextField jtfDescription;
    private javax.swing.JTextField jtfId;
    // End of variables declaration//GEN-END:variables
}
