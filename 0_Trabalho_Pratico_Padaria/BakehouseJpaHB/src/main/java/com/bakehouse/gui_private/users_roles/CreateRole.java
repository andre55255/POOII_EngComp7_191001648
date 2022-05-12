package com.bakehouse.gui_private.users_roles;

import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import com.bakehouse.viewobjects.account.RoleVO;
import java.awt.Component;

public class CreateRole extends javax.swing.JFrame {

    public CreateRole() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDescription = new javax.swing.JTextField();
        jbCreateRole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Perfil");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CRIAR PERFIL");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 0));
        jLabel5.setText("Descrição");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfDescription.setBackground(new java.awt.Color(240, 240, 240));
        jtfDescription.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDescription.setForeground(new java.awt.Color(10, 16, 26));
        jtfDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDescription.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jbCreateRole.setBackground(new java.awt.Color(36, 162, 73));
        jbCreateRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbCreateRole.setForeground(new java.awt.Color(255, 255, 255));
        jbCreateRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbCreateRole.setText("Criar");
        jbCreateRole.setAlignmentX(0.5F);
        jbCreateRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbCreateRole.setBorderPainted(false);
        jbCreateRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCreateRole.setFocusable(false);
        jbCreateRole.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbCreateRole.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbCreateRole.setName(""); // NOI18N
        jbCreateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                    .addComponent(jtfDescription)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 631, Short.MAX_VALUE))
                    .addComponent(jbCreateRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jtfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCreateRole, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void jbCreateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateRoleActionPerformed
        try
        {
            String description = jtfDescription.getText();
            RoleVO roleVO = new RoleVO();
            roleVO.setId(-1);
            roleVO.setDescription(description);
            Component compThis = this;
            IAccountService accService = new AccountService();
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Thread t = new Thread(){
                @Override
                public void run() {
                    Result resultInsert = accService.createRole(roleVO);
                    loadGui.dispose();
                    if (!resultInsert.isSuccess()) {
                        new EmitAlert(compThis, resultInsert.getMessage()).error();
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
    }//GEN-LAST:event_jbCreateRoleActionPerformed

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
            java.util.logging.Logger.getLogger(CreateRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CreateRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CreateRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CreateRole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() ->
        {
            new CreateRole().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCreateRole;
    private javax.swing.JTextField jtfDescription;
    // End of variables declaration//GEN-END:variables
}
