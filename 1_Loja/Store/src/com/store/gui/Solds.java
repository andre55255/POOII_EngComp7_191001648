package com.store.gui;

import com.store.dao.CategoryDAO;
import com.store.domain.Category;
import com.store.helpers.EmitAlert;
import com.store.services.OrderService;
import com.store.services.ProductService;
import java.text.DecimalFormat;
import java.util.List;

public class Solds extends javax.swing.JFrame {

    public Solds() {
        initComponents();
        this.loadComboBoxCategories();
        this.loadDataScreen();
    }

    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }
    
    private void loadDataScreen() {
        try {
            int productsSolds;
            double totalTaxes, totalValueSolds;
            if (jcbCategory.getSelectedIndex() == 0) {
                productsSolds = ProductService.quantityProductsSold();
                totalTaxes = ProductService.totalTaxesProductsByCategory(null, true);
                totalValueSolds = OrderService.totalValueOrders();
            } else {
                Category category = new CategoryDAO().FindAll().get(jcbCategory.getSelectedIndex()-1);
                productsSolds = ProductService.quantityProductsSoldByCategory(category);
                totalTaxes = ProductService.totalTaxesProductsByCategory(category, false);
                totalValueSolds = OrderService.totalValueOrdersByCategory(category);
            }
            
            jtfProductsSolds.setText(productsSolds + " unidades");
            jtfTotalTaxes.setText("R$ "+this.money(totalTaxes));
            jtfTotalValueNotTax.setText("R$ "+this.money(totalValueSolds));
            jtfTotalValue.setText("R$ "+this.money(totalTaxes+totalValueSolds));
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao carregar informações na tela").error();
        }
    }
    
    private void loadComboBoxCategories() {
        try {
            CategoryDAO dao = new CategoryDAO();
            List<Category> categoriesDB = dao.FindAll();
            
            jcbCategory.addItem("Todas");
            for (Category cat : categoriesDB) {
                jcbCategory.addItem(cat.getId() + "-" + cat.getDescription());
            }

            jcbCategory.setSelectedIndex(0);
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao carregar caixa de seleção").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jtfProductsSolds = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfTotalTaxes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTotalValueNotTax = new javax.swing.JTextField();
        jbNewSold = new javax.swing.JButton();
        jbListSolds = new javax.swing.JButton();
        jtfTotalValue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTROLE DE VENDAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 10, 120));
        jLabel8.setText("Selecione quais categorias devem aparecer");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jcbCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbCategory.setForeground(new java.awt.Color(36, 22, 84));
        jcbCategory.setFocusable(false);
        jcbCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoryItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 22, 84));
        jLabel2.setText("Produtos vendidos:");
        jLabel2.setAlignmentX(365.0F);
        jLabel2.setAlignmentY(23.0F);

        jtfProductsSolds.setEditable(false);
        jtfProductsSolds.setBackground(new java.awt.Color(255, 255, 255));
        jtfProductsSolds.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfProductsSolds.setForeground(new java.awt.Color(36, 22, 84));
        jtfProductsSolds.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 22, 84));
        jLabel3.setText("Total de impostos:");
        jLabel3.setAlignmentX(365.0F);
        jLabel3.setAlignmentY(23.0F);

        jtfTotalTaxes.setEditable(false);
        jtfTotalTaxes.setBackground(new java.awt.Color(255, 255, 255));
        jtfTotalTaxes.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfTotalTaxes.setForeground(new java.awt.Color(36, 22, 84));
        jtfTotalTaxes.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 22, 84));
        jLabel4.setText("Valor sem impostos:");
        jLabel4.setAlignmentX(365.0F);
        jLabel4.setAlignmentY(23.0F);

        jtfTotalValueNotTax.setEditable(false);
        jtfTotalValueNotTax.setBackground(new java.awt.Color(255, 255, 255));
        jtfTotalValueNotTax.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfTotalValueNotTax.setForeground(new java.awt.Color(36, 22, 84));
        jtfTotalValueNotTax.setBorder(null);

        jbNewSold.setBackground(new java.awt.Color(18, 10, 120));
        jbNewSold.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbNewSold.setForeground(new java.awt.Color(255, 255, 255));
        jbNewSold.setText("Nova venda");
        jbNewSold.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbNewSold.setBorderPainted(false);
        jbNewSold.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNewSold.setFocusable(false);
        jbNewSold.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbNewSold.setName(""); // NOI18N
        jbNewSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewSoldActionPerformed(evt);
            }
        });

        jbListSolds.setBackground(new java.awt.Color(18, 10, 100));
        jbListSolds.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbListSolds.setForeground(new java.awt.Color(255, 255, 255));
        jbListSolds.setText("Lista de vendas");
        jbListSolds.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbListSolds.setBorderPainted(false);
        jbListSolds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbListSolds.setFocusable(false);
        jbListSolds.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbListSolds.setName(""); // NOI18N

        jtfTotalValue.setEditable(false);
        jtfTotalValue.setBackground(new java.awt.Color(255, 255, 255));
        jtfTotalValue.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfTotalValue.setForeground(new java.awt.Color(36, 22, 84));
        jtfTotalValue.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 22, 84));
        jLabel5.setText("Valor total vendas:");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfProductsSolds))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfTotalTaxes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfTotalValueNotTax))
                    .addComponent(jcbCategory, 0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbNewSold, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbListSolds, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfTotalValue)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfProductsSolds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfTotalTaxes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfTotalValueNotTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNewSold, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbListSolds, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(207, Short.MAX_VALUE))
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

    private void jcbCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoryItemStateChanged
        this.loadDataScreen();
    }//GEN-LAST:event_jcbCategoryItemStateChanged

    private void jbNewSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNewSoldActionPerformed
        new SoldsNew().setVisible(true);
    }//GEN-LAST:event_jbNewSoldActionPerformed

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
            java.util.logging.Logger.getLogger(Solds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Solds().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbListSolds;
    private javax.swing.JButton jbNewSold;
    private javax.swing.JComboBox<String> jcbCategory;
    private javax.swing.JTextField jtfProductsSolds;
    private javax.swing.JTextField jtfTotalTaxes;
    private javax.swing.JTextField jtfTotalValue;
    private javax.swing.JTextField jtfTotalValueNotTax;
    // End of variables declaration//GEN-END:variables
}
