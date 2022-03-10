package com.store.gui;

import com.store.dao.OrderItemDAO;
import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import com.store.helpers.EmitAlert;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class SoldsOrderItems extends javax.swing.JFrame {

    private Order order;
    
    public SoldsOrderItems() {
        initComponents();
    }
    
    public SoldsOrderItems(Order order) {
        initComponents();
        this.order = order;
        this.renderTable();
    }
    
    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }

    private void renderTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableOrderItems.getModel();
            model.setRowCount(0);
            
            for (OrderItem item : this.order.getOrderItem()) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getProduct().getDescription(),
                    this.money(item.getValueUnitary()),
                    item.getQuantity(),
                    this.money(item.getValueUnitary() * item.getQuantity())
                });
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao carregar dados na tabela").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableOrderItems = new javax.swing.JTable();
        jbtnClearOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens de pedido");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ITENS DE PEDIDO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableOrderItems.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableOrderItems.setForeground(new java.awt.Color(18, 10, 120));
        jTableOrderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Valor Unitário", "Quantidade", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrderItems.setGridColor(new java.awt.Color(36, 22, 84));
        jScrollPane.setViewportView(jTableOrderItems);

        jbtnClearOrder.setBackground(new java.awt.Color(255, 0, 51));
        jbtnClearOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbtnClearOrder.setForeground(new java.awt.Color(255, 255, 255));
        jbtnClearOrder.setText("Retirar item do pedido");
        jbtnClearOrder.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbtnClearOrder.setBorderPainted(false);
        jbtnClearOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnClearOrder.setFocusable(false);
        jbtnClearOrder.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbtnClearOrder.setName(""); // NOI18N
        jbtnClearOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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

    private void jbtnClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearOrderActionPerformed
        try {
            OrderItem item = this.order.getOrderItem().get(jTableOrderItems.getSelectedRow());
            int quantity = item.getQuantity();
            if (quantity == 1) {
                this.order.getOrderItem().remove(jTableOrderItems.getSelectedRow());
                
                OrderItemDAO dao = new OrderItemDAO();
                dao.Delete(item.getId());
            }
            
            item.setQuantity(item.getQuantity() - 1);
            this.renderTable();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao retirar item de pedido").error();
        }
    }//GEN-LAST:event_jbtnClearOrderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new SoldsNew(this.order).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(SoldsOrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SoldsOrderItems().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableOrderItems;
    private javax.swing.JButton jbtnClearOrder;
    // End of variables declaration//GEN-END:variables
}
