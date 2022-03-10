package com.store.gui;

public class Initial extends javax.swing.JFrame {

    public Initial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnCategory = new javax.swing.JButton();
        jBtnProduct = new javax.swing.JButton();
        jBtnSales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Header.setBackground(new java.awt.Color(50, 175, 180));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/logo_small_invert.jpg"))); // NOI18N

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jBtnCategory.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jBtnCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/icoCategory.png"))); // NOI18N
        jBtnCategory.setText("Categorias");
        jBtnCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 131, 189), 2, true));
        jBtnCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCategory.setDefaultCapable(false);
        jBtnCategory.setFocusPainted(false);
        jBtnCategory.setFocusable(false);
        jBtnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCategoryActionPerformed(evt);
            }
        });

        jBtnProduct.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jBtnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/icoProduct.png"))); // NOI18N
        jBtnProduct.setText("Produtos");
        jBtnProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 131, 189), 2, true));
        jBtnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnProduct.setDefaultCapable(false);
        jBtnProduct.setFocusPainted(false);
        jBtnProduct.setFocusable(false);
        jBtnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProductActionPerformed(evt);
            }
        });

        jBtnSales.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jBtnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/icoSale.png"))); // NOI18N
        jBtnSales.setText("Vendas");
        jBtnSales.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(59, 131, 189), 2, true));
        jBtnSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSales.setDefaultCapable(false);
        jBtnSales.setFocusPainted(false);
        jBtnSales.setFocusable(false);
        jBtnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jBtnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
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

    private void jBtnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCategoryActionPerformed
        new Categories().setVisible(true);
    }//GEN-LAST:event_jBtnCategoryActionPerformed

    private void jBtnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProductActionPerformed
        new Products().setVisible(true);
    }//GEN-LAST:event_jBtnProductActionPerformed

    private void jBtnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalesActionPerformed
        new Solds().setVisible(true);
    }//GEN-LAST:event_jBtnSalesActionPerformed

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
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Initial().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton jBtnCategory;
    private javax.swing.JButton jBtnProduct;
    private javax.swing.JButton jBtnSales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
