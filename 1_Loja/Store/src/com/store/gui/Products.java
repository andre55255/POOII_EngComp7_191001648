package com.store.gui;

import com.store.dao.CategoryDAO;
import com.store.dao.ProductDAO;
import com.store.domain.Category;
import com.store.domain.Product;
import com.store.helpers.EmitAlert;
import com.store.services.ProductService;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Products extends javax.swing.JFrame {

    public Products() {
        initComponents();
        this.loadComboBoxCategories();
        this.renderTable();
    }

    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }

    private void renderTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            model.setRowCount(0);

            List<Product> products = new ProductDAO().FindAll();

            for (Product p : products) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getDescription(),
                    p.getCategory().getDescription(),
                    p.getQuantity(),
                    "R$ " + this.money(p.getValueUnitary()),
                    "$ " + this.money(ProductService.valueProductInDollar(p))
                });
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao carregar tabela de produtos").error();
        }
    }

    private void loadComboBoxCategories() {
        try {
            CategoryDAO dao = new CategoryDAO();
            List<Category> categoriesDB = dao.FindAll();
            jcbCategoryProdNew.addItem("Selecione uma categoria");

            for (Category cat : categoriesDB) {
                jcbCategoryProdNew.addItem(cat.getId() + "-" + cat.getDescription());
            }

            jcbCategoryProdNew.setSelectedIndex(0);
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao carregar categorias").error();
        }
    }

    private void clearInputs() {
        jtfDscProdNew.setText("");
        jtfProductSaveId.setText("");
        jtfQuantityProdNew.setText("");
        jtfValueUnitaryProdNew.setText("");
        jcbCategoryProdNew.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDscProdNew = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfQuantityProdNew = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfValueUnitaryProdNew = new javax.swing.JTextField();
        jbNewProduct = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jbUpdateProduct = new javax.swing.JButton();
        jbDeleteProduct = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcbCategoryProdNew = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jtfProductSaveId = new javax.swing.JTextField();
        jbClearInputs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTROLE DE PRODUTOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 10, 120));
        jLabel5.setText("Descrição");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfDscProdNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfDscProdNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDscProdNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfDscProdNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDscProdNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDscProdNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 10, 120));
        jLabel6.setText("Quantidade");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jtfQuantityProdNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfQuantityProdNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfQuantityProdNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfQuantityProdNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfQuantityProdNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfQuantityProdNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 10, 120));
        jLabel7.setText("Valor unitário");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfValueUnitaryProdNew.setBackground(new java.awt.Color(238, 238, 221));
        jtfValueUnitaryProdNew.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfValueUnitaryProdNew.setForeground(new java.awt.Color(18, 10, 120));
        jtfValueUnitaryProdNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfValueUnitaryProdNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfValueUnitaryProdNew.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jbNewProduct.setBackground(new java.awt.Color(18, 10, 120));
        jbNewProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbNewProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbNewProduct.setText("Novo produto");
        jbNewProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbNewProduct.setBorderPainted(false);
        jbNewProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNewProduct.setFocusable(false);
        jbNewProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbNewProduct.setName(""); // NOI18N
        jbNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewProductActionPerformed(evt);
            }
        });

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableProducts.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableProducts.setForeground(new java.awt.Color(18, 10, 120));
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Categoria", "Quantidade", "Valor unitário (R$)", "Valor unitário ($)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setGridColor(new java.awt.Color(36, 22, 84));
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTableProducts);

        jbUpdateProduct.setBackground(new java.awt.Color(255, 153, 51));
        jbUpdateProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbUpdateProduct.setText("Atualizar produto");
        jbUpdateProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbUpdateProduct.setBorderPainted(false);
        jbUpdateProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbUpdateProduct.setEnabled(false);
        jbUpdateProduct.setFocusable(false);
        jbUpdateProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbUpdateProduct.setName(""); // NOI18N
        jbUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateProductActionPerformed(evt);
            }
        });

        jbDeleteProduct.setBackground(new java.awt.Color(255, 0, 51));
        jbDeleteProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbDeleteProduct.setText("Deletar produto");
        jbDeleteProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbDeleteProduct.setBorderPainted(false);
        jbDeleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDeleteProduct.setEnabled(false);
        jbDeleteProduct.setFocusable(false);
        jbDeleteProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbDeleteProduct.setName(""); // NOI18N
        jbDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteProductActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 10, 120));
        jLabel8.setText("Categoria");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jcbCategoryProdNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbCategoryProdNew.setForeground(new java.awt.Color(36, 22, 84));
        jcbCategoryProdNew.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 10, 120));
        jLabel9.setText("Id do produto");
        jLabel9.setAlignmentX(365.0F);
        jLabel9.setAlignmentY(23.0F);

        jtfProductSaveId.setEditable(false);
        jtfProductSaveId.setBackground(new java.awt.Color(255, 255, 255));
        jtfProductSaveId.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfProductSaveId.setForeground(new java.awt.Color(18, 10, 120));
        jtfProductSaveId.setBorder(null);

        jbClearInputs.setBackground(new java.awt.Color(0, 153, 255));
        jbClearInputs.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbClearInputs.setForeground(new java.awt.Color(255, 255, 255));
        jbClearInputs.setText("Limpar entradas para novo cadastro");
        jbClearInputs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbClearInputs.setBorderPainted(false);
        jbClearInputs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbClearInputs.setFocusable(false);
        jbClearInputs.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbClearInputs.setName(""); // NOI18N
        jbClearInputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearInputsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDscProdNew)
                    .addComponent(jtfQuantityProdNew)
                    .addComponent(jtfValueUnitaryProdNew)
                    .addComponent(jScrollPane)
                    .addComponent(jcbCategoryProdNew, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfProductSaveId)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbClearInputs, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 687, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDscProdNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfQuantityProdNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValueUnitaryProdNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCategoryProdNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbClearInputs, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfProductSaveId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jbNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewProductActionPerformed
        try {
            String description = jtfDscProdNew.getText();
            double quantity = Double.parseDouble(jtfQuantityProdNew.getText());
            double valueUnitary = Double.parseDouble(jtfValueUnitaryProdNew.getText());

            CategoryDAO daoCat = new CategoryDAO();
            Category category = daoCat.FindAll().get(jcbCategoryProdNew.getSelectedIndex() - 1);

            ProductDAO dao = new ProductDAO();
            Product p = new Product(description, quantity, valueUnitary, category);
            boolean result = dao.Insert(p);
            if (result) {
                new EmitAlert(this, "Produto inserido com sucesso").success();
                this.clearInputs();
                this.renderTable();
                return;
            } else {
                new EmitAlert(this, "Falha ao inserir produto").error();
            }

            new EmitAlert(this, "Ocorreu um erro ao inserir o produto").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Quantidade e valor unitário devem ser informados apenas números").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbNewProductActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        try {
            int indexSelected = jTableProducts.getSelectedRow();

            ProductDAO dao = new ProductDAO();
            Product p = dao.FindAll().get(indexSelected);

            jtfProductSaveId.setText(p.getId() + "");

            jtfDscProdNew.setText(p.getDescription());
            jtfQuantityProdNew.setText(p.getQuantity() + "");
            jtfValueUnitaryProdNew.setText(p.getValueUnitary() + "");

            CategoryDAO dbCat = new CategoryDAO();
            jcbCategoryProdNew.setSelectedIndex(dbCat.FindAll().indexOf(p.getCategory()) + 1);

            jbUpdateProduct.setEnabled(true);
            jbDeleteProduct.setEnabled(true);
            jbNewProduct.setEnabled(false);
        } catch (Exception ex) {
            System.out.println("Erro ao clicar na tela: " + ex.getMessage());
        }
    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jbClearInputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearInputsActionPerformed
        this.clearInputs();
        jbNewProduct.setEnabled(true);
        jbDeleteProduct.setEnabled(false);
        jbUpdateProduct.setEnabled(false);
    }//GEN-LAST:event_jbClearInputsActionPerformed

    private void jbUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateProductActionPerformed
        try {
            int id = Integer.parseInt(jtfProductSaveId.getText());
            String description = jtfDscProdNew.getText();
            double quantity = Double.parseDouble(jtfQuantityProdNew.getText());
            double valueUnitary = Double.parseDouble(jtfValueUnitaryProdNew.getText());

            CategoryDAO daoCat = new CategoryDAO();
            Category category = daoCat.FindAll().get(jcbCategoryProdNew.getSelectedIndex());

            ProductDAO dao = new ProductDAO();
            Product p = new Product(description, quantity, valueUnitary, category);
            boolean result = dao.Update(id, p);

            if (result) {
                new EmitAlert(this, "Produto atualizado com sucesso").success();

                this.renderTable();
                this.clearInputs();

                jbUpdateProduct.setEnabled(false);
                jbDeleteProduct.setEnabled(false);

                return;
            }

            new EmitAlert(this, "Erro ao atualizar produto").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Quantidade e valor unitário devem ser informados apenas números ou id do produto não encontrado").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Erro inesperado").error();
        }
    }//GEN-LAST:event_jbUpdateProductActionPerformed

    private void jbDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteProductActionPerformed
        try {
            int id = Integer.parseInt(jtfProductSaveId.getText());

            ProductDAO dao = new ProductDAO();
            boolean result = dao.Delete(id);

            if (result) {
                new EmitAlert(this, "Produto deletado com sucesso").success();
                this.renderTable();
                this.clearInputs();
                return;
            }

            new EmitAlert(this, "Falha ao deletar o produto").error();
        } catch (NumberFormatException ex) {
            new EmitAlert(this, "Id não encontrado").error();
        } catch (IllegalAccessException ex) {
            new EmitAlert(this, ex.getMessage()).error();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbDeleteProductActionPerformed

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
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Products().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbClearInputs;
    private javax.swing.JButton jbDeleteProduct;
    private javax.swing.JButton jbNewProduct;
    private javax.swing.JButton jbUpdateProduct;
    private javax.swing.JComboBox<String> jcbCategoryProdNew;
    private javax.swing.JTextField jtfDscProdNew;
    private javax.swing.JTextField jtfProductSaveId;
    private javax.swing.JTextField jtfQuantityProdNew;
    private javax.swing.JTextField jtfValueUnitaryProdNew;
    // End of variables declaration//GEN-END:variables

}
