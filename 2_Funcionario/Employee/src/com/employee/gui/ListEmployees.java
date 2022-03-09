package com.employee.gui;

import com.employee.dao.EmployeeDAO;
import com.employee.domain.*;
import com.employee.helpers.EmitAlert;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ListEmployees extends javax.swing.JFrame {

    public ListEmployees() {
        initComponents();
        this.renderTable();
    }

    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }

    private String dateFull(LocalDate date) {
        String day = date.getDayOfMonth() + "";
        String month = date.getMonthValue() + "";
        String year = date.getYear() + "";
        return day + "/" + month + "/" + year;
    }

    private void renderTable() {
        DefaultTableModel model = (DefaultTableModel) jTableEmployees.getModel();
        model.setRowCount(0);

        List<Employee> list = new EmployeeDAO().FindAll();

        for (Employee e : list) {
            if (e instanceof President) {
                model.addRow(new Object[]{
                    e.getId(),
                    e.getCpf(),
                    this.dateFull(e.getBirthDate()),
                    e.getDepartment(),
                    this.money(e.getBaseSalary()),
                    this.money(e.getBonus()),
                    "Presidente"
                });
            } else if (e instanceof Manager) {
                model.addRow(new Object[]{
                    e.getId(),
                    e.getCpf(),
                    this.dateFull(e.getBirthDate()),
                    e.getDepartment(),
                    this.money(e.getBaseSalary()),
                    this.money(e.getBonus()),
                    "Gerente"
                });
            } else {
                model.addRow(new Object[]{
                    e.getId(),
                    e.getCpf(),
                    this.dateFull(e.getBirthDate()),
                    e.getDepartment(),
                    this.money(e.getBaseSalary()),
                    this.money(e.getBonus()),
                    "Secretária"
                });
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableEmployees = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtfIdDelete = new javax.swing.JTextField();
        jbDeleteCategory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de funcionários");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/employee/assets/logo.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE FUNCIONÁRIOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableEmployees.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableEmployees.setForeground(new java.awt.Color(18, 10, 120));
        jTableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cpf", "Data de Nascimento", "Setor", "Salário Base", "Bonificação", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmployees.setGridColor(new java.awt.Color(36, 22, 84));
        jTableEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeesMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTableEmployees);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 10, 120));
        jLabel5.setText("Id");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfIdDelete.setEditable(false);
        jtfIdDelete.setBackground(new java.awt.Color(238, 238, 221));
        jtfIdDelete.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfIdDelete.setForeground(new java.awt.Color(18, 10, 120));
        jtfIdDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfIdDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfIdDelete.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jbDeleteCategory.setBackground(new java.awt.Color(255, 0, 51));
        jbDeleteCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbDeleteCategory.setForeground(new java.awt.Color(255, 255, 255));
        jbDeleteCategory.setText("Deletar categoria");
        jbDeleteCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbDeleteCategory.setBorderPainted(false);
        jbDeleteCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDeleteCategory.setEnabled(false);
        jbDeleteCategory.setFocusable(false);
        jbDeleteCategory.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbDeleteCategory.setName(""); // NOI18N
        jbDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addComponent(jtfIdDelete, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeesMouseClicked
        try {
            EmployeeDAO dao = new EmployeeDAO();

            int index = jTableEmployees.getSelectedRow();
            Employee e = dao.FindById(index + 1);

            jtfIdDelete.setText(e.getId() + "");
            jbDeleteCategory.setEnabled(true);
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jTableEmployeesMouseClicked

    private void jbDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteCategoryActionPerformed
        try {
            EmployeeDAO dao = new EmployeeDAO();
            int id = Integer.parseInt(jtfIdDelete.getText());
            dao.Delete(id);
            
            this.renderTable();
            jtfIdDelete.setText("");
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Id inválido").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbDeleteCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(ListEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListEmployees().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableEmployees;
    private javax.swing.JButton jbDeleteCategory;
    private javax.swing.JTextField jtfIdDelete;
    // End of variables declaration//GEN-END:variables
}
