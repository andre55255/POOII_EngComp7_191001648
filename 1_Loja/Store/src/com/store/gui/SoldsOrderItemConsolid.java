package com.store.gui;

import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.helpers.EmitAlert;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class SoldsOrderItemConsolid extends javax.swing.JFrame {

    private Order order;

    public SoldsOrderItemConsolid() {
        initComponents();
    }

    public SoldsOrderItemConsolid(Order order) {
        initComponents();
        this.order = order;
        this.renderTable();
        jlTitle.setText(jlTitle.getText()+this.order.getId());
    }

    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }
    
    private void renderTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableOrders.getModel();
            model.setRowCount(0);
            
            for (OrderItem item : this.order.getOrderItem()) {
                double tax = (item.getValueUnitary()*item.getTax()) * item.getQuantity();
                
                model.addRow(new Object[]{
                    item.getId(),
                    item.getProduct().getDescription(),
                    item.getQuantity(),
                    "R$ "+this.money(item.getValueUnitary()),
                    "R$ "+this.money(item.getValueUnitary()*item.getQuantity()),
                    "R$ "+this.money(tax)
                });
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao renderizar a tabela de itens de pedido").error();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableOrders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens de venda consolidada");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(18, 10, 120));
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("ITENS DA VENDA #ID: ");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableOrders.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableOrders.setForeground(new java.awt.Color(18, 10, 120));
        jTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Quantidade", "Valor unitário", "Valor total", "Imposto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableOrders.setGridColor(new java.awt.Color(36, 22, 84));
        jScrollPane.setViewportView(jTableOrders);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(SoldsOrderItemConsolid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItemConsolid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItemConsolid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoldsOrderItemConsolid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SoldsOrderItemConsolid().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableOrders;
    private javax.swing.JLabel jlTitle;
    // End of variables declaration//GEN-END:variables
}
