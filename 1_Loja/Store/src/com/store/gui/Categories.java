package com.store.gui;

import com.store.dao.CategoryDAO;
import com.store.domain.Category;
import com.store.helpers.EmitAlert;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Categories extends javax.swing.JFrame {

    public Categories() {
        initComponents();
        this.renderTable();
    }

    private void renderTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableCategories.getModel();
            model.setRowCount(0);

            List<Category> categories = new CategoryDAO().FindAll();

            for (Category c : categories) {
                model.addRow(new Object[]{
                    c.getId(),
                    c.getDescription(),
                    formatPercents(c.getTax())
                });
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao renderizar a tabela").error();
            System.out.println(ex.getMessage());
        }

    }

    private String formatPercents(double num) {
        double aux = num * 100;
        return aux + " %";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDscCategoryNew = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        jTableCategories = new javax.swing.JTable();
        jbNewCategory = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfCategorySaveId = new javax.swing.JTextField();
        jbDeleteCategory = new javax.swing.JButton();
        jbUpdateCategory = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfCategorySaveDescriiption = new javax.swing.JTextField();
        jtfTaxNew = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfCategorySaveTax = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categorias");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CATEGORIAS DE PRODUTO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 10, 120));
        jLabel5.setText("Descrição");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfDscCategoryNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfDscCategoryNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDscCategoryNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfDscCategoryNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDscCategoryNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDscCategoryNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableCategories.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableCategories.setForeground(new java.awt.Color(18, 10, 120));
        jTableCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Imposto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCategories.setGridColor(new java.awt.Color(36, 22, 84));
        jTableCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriesMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTableCategories);

        jbNewCategory.setBackground(new java.awt.Color(18, 10, 120));
        jbNewCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbNewCategory.setForeground(new java.awt.Color(255, 255, 255));
        jbNewCategory.setText("Nova categoria");
        jbNewCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbNewCategory.setBorderPainted(false);
        jbNewCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNewCategory.setFocusable(false);
        jbNewCategory.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbNewCategory.setName(""); // NOI18N
        jbNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewCategoryActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 10, 120));
        jLabel8.setText("Id Categoria Cadastrada");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jtfCategorySaveId.setEditable(false);
        jtfCategorySaveId.setBackground(new java.awt.Color(255, 255, 255));
        jtfCategorySaveId.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfCategorySaveId.setForeground(new java.awt.Color(18, 10, 120));
        jtfCategorySaveId.setBorder(null);

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

        jbUpdateCategory.setBackground(new java.awt.Color(255, 153, 51));
        jbUpdateCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbUpdateCategory.setForeground(new java.awt.Color(255, 255, 255));
        jbUpdateCategory.setText("Atualizar categoria");
        jbUpdateCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbUpdateCategory.setBorderPainted(false);
        jbUpdateCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbUpdateCategory.setEnabled(false);
        jbUpdateCategory.setFocusable(false);
        jbUpdateCategory.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbUpdateCategory.setName(""); // NOI18N
        jbUpdateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateCategoryActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 10, 120));
        jLabel9.setText("Descrição Categoria Cadastrada");
        jLabel9.setAlignmentX(365.0F);
        jLabel9.setAlignmentY(23.0F);

        jtfCategorySaveDescriiption.setEditable(false);
        jtfCategorySaveDescriiption.setBackground(new java.awt.Color(255, 255, 255));
        jtfCategorySaveDescriiption.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfCategorySaveDescriiption.setForeground(new java.awt.Color(18, 10, 120));
        jtfCategorySaveDescriiption.setBorder(null);

        jtfTaxNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfTaxNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfTaxNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfTaxNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfTaxNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfTaxNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 10, 120));
        jLabel6.setText("Imposto (Informar percentual em decimal. Ex: 0.5)");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 10, 120));
        jLabel10.setText("Imposto Categoria Cadastrada");
        jLabel10.setAlignmentX(365.0F);
        jLabel10.setAlignmentY(23.0F);

        jtfCategorySaveTax.setEditable(false);
        jtfCategorySaveTax.setBackground(new java.awt.Color(255, 255, 255));
        jtfCategorySaveTax.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfCategorySaveTax.setForeground(new java.awt.Color(18, 10, 120));
        jtfCategorySaveTax.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDscCategoryNew)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfCategorySaveId)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbNewCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfCategorySaveDescriiption)
                    .addComponent(jtfTaxNew)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfCategorySaveTax)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDscCategoryNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTaxNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCategorySaveId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCategorySaveDescriiption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCategorySaveTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewCategoryActionPerformed
        try {
            String description = jtfDscCategoryNew.getText();
            double tax = Double.parseDouble(jtfTaxNew.getText());

            if (description.trim().length() == 0) {
                new EmitAlert(this, "Descrição deve ser informada corretamente").warning();
                return;
            }

            Category category = new Category(description, tax);
            CategoryDAO db = new CategoryDAO();
            boolean result = db.Insert(category);

            if (result) {
                new EmitAlert(this, "Categoria cadastrada com sucesso").success();
                this.renderTable();

                jtfDscCategoryNew.setText("");
                jtfTaxNew.setText("");

                return;
            }

            new EmitAlert(this, "Falha ao cadastrar categoria no banco").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Imposto deve ser informado corretamente").warning();
        } catch (Exception ex) {
            new EmitAlert(this, "Erro inesperado").error();
        }
    }//GEN-LAST:event_jbNewCategoryActionPerformed

    private void jTableCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriesMouseClicked
        try {
            CategoryDAO db = new CategoryDAO();

            int indexSelected = jTableCategories.getSelectedRow();
            Category category = db.FindAll().get(indexSelected);

            jtfCategorySaveId.setText(category.getId() + "");
            jtfCategorySaveTax.setText(category.getTax() + "");
            jtfCategorySaveDescriiption.setText(category.getDescription());

            jbUpdateCategory.setEnabled(true);
            jbDeleteCategory.setEnabled(true);
            jtfCategorySaveTax.setEditable(true);
            jtfCategorySaveDescriiption.setEditable(true);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar categoria");
        }

    }//GEN-LAST:event_jTableCategoriesMouseClicked

    private void jbUpdateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateCategoryActionPerformed
        try {
            CategoryDAO db = new CategoryDAO();

            String description = jtfCategorySaveDescriiption.getText();
            double tax = Double.parseDouble(jtfCategorySaveTax.getText());
            int id = Integer.parseInt(jtfCategorySaveId.getText());

            Category category = new Category(id, description, tax);

            boolean result = db.Update(id, category);

            if (result) {
                new EmitAlert(this, "Categoria atualizada com sucesso").success();
                this.renderTable();

                jtfCategorySaveDescriiption.setText("");
                jtfCategorySaveTax.setText("");
                jtfCategorySaveId.setText("");

                return;
            }

            new EmitAlert(this, "Falha ao atualizar categoria no banco").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Imposto deve ser informado corretamente").warning();
        } catch (Exception ex) {
            new EmitAlert(this, "Erro inesperado").error();
        }
    }//GEN-LAST:event_jbUpdateCategoryActionPerformed

    private void jbDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteCategoryActionPerformed
        try {
            int id = Integer.parseInt(jtfCategorySaveId.getText());

            boolean result = new CategoryDAO().Delete(id);

            if (result) {
                new EmitAlert(this, "Categoria deletada com sucesso").success();
                this.renderTable();

                return;
            }

            new EmitAlert(this, "Falha ao atualizar categoria no banco").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Id inválido").error();
        } catch (IllegalAccessException ex) {
            new EmitAlert(this, ex.getMessage()).error();
        } catch (Exception ex) {
            new EmitAlert(this, "Erro inesperado").error();
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
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Categories().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableCategories;
    private javax.swing.JButton jbDeleteCategory;
    private javax.swing.JButton jbNewCategory;
    private javax.swing.JButton jbUpdateCategory;
    private javax.swing.JTextField jtfCategorySaveDescriiption;
    private javax.swing.JTextField jtfCategorySaveId;
    private javax.swing.JTextField jtfCategorySaveTax;
    private javax.swing.JTextField jtfDscCategoryNew;
    private javax.swing.JTextField jtfTaxNew;
    // End of variables declaration//GEN-END:variables
}
