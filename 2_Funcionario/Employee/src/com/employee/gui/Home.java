package com.employee.gui;

import com.employee.dao.EmployeeDAO;
import com.employee.domain.Manager;
import com.employee.domain.President;
import com.employee.domain.Secretary;
import com.employee.helpers.DateFormat;
import com.employee.helpers.EmitAlert;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTypeEmp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNameNew = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfBirthDate = new javax.swing.JFormattedTextField();
        jtfDepartmentNew = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfBaseSalaryNew = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbNew = new javax.swing.JButton();
        jbListAll = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfCpfNew = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jrPresident = new javax.swing.JRadioButton();
        jrManager = new javax.swing.JRadioButton();
        jrSecretary = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empresa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/employee/assets/logo.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE FUNCIONÁRIOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfNameNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfNameNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfNameNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfNameNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfNameNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfNameNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 10, 120));
        jLabel6.setText("Nome");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 10, 120));
        jLabel7.setText("Data de nascimento");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfBirthDate.setBackground(new java.awt.Color(238, 238, 221));
        jtfBirthDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 221), 1, true));
        jtfBirthDate.setForeground(new java.awt.Color(36, 22, 84));
        try {
            jtfBirthDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfBirthDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jtfDepartmentNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfDepartmentNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDepartmentNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfDepartmentNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDepartmentNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDepartmentNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 10, 120));
        jLabel8.setText("Setor");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jtfBaseSalaryNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfBaseSalaryNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfBaseSalaryNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfBaseSalaryNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfBaseSalaryNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfBaseSalaryNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 10, 120));
        jLabel9.setText("Salário base");
        jLabel9.setAlignmentX(365.0F);
        jLabel9.setAlignmentY(23.0F);

        jbNew.setBackground(new java.awt.Color(18, 10, 120));
        jbNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbNew.setForeground(new java.awt.Color(255, 255, 255));
        jbNew.setText("Novo");
        jbNew.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbNew.setBorderPainted(false);
        jbNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNew.setFocusable(false);
        jbNew.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbNew.setName(""); // NOI18N
        jbNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewActionPerformed(evt);
            }
        });

        jbListAll.setBackground(new java.awt.Color(255, 153, 51));
        jbListAll.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbListAll.setForeground(new java.awt.Color(255, 255, 255));
        jbListAll.setText("Listar");
        jbListAll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbListAll.setBorderPainted(false);
        jbListAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbListAll.setFocusable(false);
        jbListAll.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbListAll.setName(""); // NOI18N
        jbListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListAllActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 10, 120));
        jLabel10.setText("Cpf");
        jLabel10.setAlignmentX(365.0F);
        jLabel10.setAlignmentY(23.0F);

        jtfCpfNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfCpfNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfCpfNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfCpfNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfCpfNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfCpfNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(36, 22, 84));
        jLabel27.setText("Tipo de funcionário");

        jrPresident.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTypeEmp.add(jrPresident);
        jrPresident.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jrPresident.setForeground(new java.awt.Color(36, 22, 84));
        jrPresident.setSelected(true);
        jrPresident.setText("Presidente");
        jrPresident.setFocusable(false);
        jrPresident.setName("typeClient"); // NOI18N

        jrManager.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTypeEmp.add(jrManager);
        jrManager.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jrManager.setForeground(new java.awt.Color(36, 22, 84));
        jrManager.setText("Gerente");
        jrManager.setFocusable(false);
        jrManager.setName("typeClient"); // NOI18N

        jrSecretary.setBackground(new java.awt.Color(255, 255, 255));
        btnGroupTypeEmp.add(jrSecretary);
        jrSecretary.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jrSecretary.setForeground(new java.awt.Color(36, 22, 84));
        jrSecretary.setText("Secretária");
        jrSecretary.setFocusable(false);
        jrSecretary.setName("typeClient"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbListAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jtfNameNew)
                    .addComponent(jtfBirthDate)
                    .addComponent(jtfDepartmentNew)
                    .addComponent(jtfBaseSalaryNew)
                    .addComponent(jtfCpfNew)
                    .addComponent(jbNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jrPresident)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrManager)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrSecretary)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCpfNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNameNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDepartmentNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBaseSalaryNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jrPresident)
                    .addComponent(jrManager)
                    .addComponent(jrSecretary))
                .addGap(18, 18, 18)
                .addComponent(jbNew, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbListAll, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearInputs() {
        jtfCpfNew.setText("");
        jtfNameNew.setText("");
        jtfDepartmentNew.setText("");
        jtfBaseSalaryNew.setText("");
    }
    
    private void jbNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewActionPerformed
        try {
            String cpf = jtfCpfNew.getText();
            String name = jtfNameNew.getText();
            String[] birthDateStr = jtfBirthDate.getText().split("/");
            String department = jtfDepartmentNew.getText();
            double baseSalary = Double.parseDouble(jtfBaseSalaryNew.getText());
            
            EmployeeDAO dao = new EmployeeDAO();
            if (jrPresident.isSelected()) {
                President p = new President(cpf, name, new DateFormat(birthDateStr).getLocalDate(), department, baseSalary);
                dao.Insert(p);
                
                new EmitAlert(this, "Funcionário presidente inserido com sucesso").success();
                clearInputs();
                return;
            } else if (jrManager.isSelected()) {
                Manager m = new Manager(cpf, name, new DateFormat(birthDateStr).getLocalDate(), department, baseSalary);
                dao.Insert(m);
                
                new EmitAlert(this, "Funcionário gerente inserido com sucesso").success();
                clearInputs();
                return;
            } else if (jrSecretary.isSelected()) {
                Secretary s = new Secretary(cpf, name, new DateFormat(birthDateStr).getLocalDate(), department, baseSalary);
                dao.Insert(s);
                
                new EmitAlert(this, "Funcionária secretária inserido com sucesso").success();
                clearInputs();
                return;
            }
            
            new EmitAlert(this, "Selecione o tipo de funcionário para inserir").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Salário deve ser informado apenas números,com decimais separados por ponto").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbNewActionPerformed

    private void jbListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListAllActionPerformed
        new ListEmployees().setVisible(true);
    }//GEN-LAST:event_jbListAllActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupTypeEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbListAll;
    private javax.swing.JButton jbNew;
    private javax.swing.JRadioButton jrManager;
    private javax.swing.JRadioButton jrPresident;
    private javax.swing.JRadioButton jrSecretary;
    private javax.swing.JTextField jtfBaseSalaryNew;
    private javax.swing.JFormattedTextField jtfBirthDate;
    private javax.swing.JTextField jtfCpfNew;
    private javax.swing.JTextField jtfDepartmentNew;
    private javax.swing.JTextField jtfNameNew;
    // End of variables declaration//GEN-END:variables
}
