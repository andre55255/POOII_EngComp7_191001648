package com.store.gui;

import com.store.dao.OrderDAO;
import com.store.domain.Order;
import com.store.helpers.EmitAlert;
import com.store.services.OrderService;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SoldsListAll extends javax.swing.JFrame {

    public SoldsListAll() {
        initComponents();
        this.renderTable();
    }

    private String money(double money) {
        DecimalFormat df = new DecimalFormat("###,###.00");
        return df.format(money);
    }

    private void renderTable() {
        try {
            OrderDAO dbOrder = new OrderDAO();
            List<Order> orders = dbOrder.FindAll();

            DefaultTableModel model = (DefaultTableModel) jTableOrders.getModel();
            model.setRowCount(0);

            for (Order item : orders) {
                model.addRow(new Object[]{
                    item.getId(),
                    item.getDateHour().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    item.getOrderItem().size(),
                    "R$ " + this.money(OrderService.totalValueOrder(item.getId())),
                    "R$ " + this.money(OrderService.getValueTaxOrderById(item.getId())),
                    item.isStatus() ? "Fechada" : "Aberta"
                });
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao renderizar a tabela de vendas").error();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableOrders = new javax.swing.JTable();
        jbDetailsOrderItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de vendas");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA DE VENDAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jTableOrders.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jTableOrders.setForeground(new java.awt.Color(18, 10, 120));
        jTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data da venda", "Quantidade Produtos", "Valor Total Bruto", "Valor Total Impostos", "Status da venda"
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
        jTableOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrdersMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTableOrders);

        jbDetailsOrderItem.setBackground(new java.awt.Color(18, 10, 120));
        jbDetailsOrderItem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbDetailsOrderItem.setForeground(new java.awt.Color(255, 255, 255));
        jbDetailsOrderItem.setText("Itens da venda");
        jbDetailsOrderItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbDetailsOrderItem.setBorderPainted(false);
        jbDetailsOrderItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDetailsOrderItem.setEnabled(false);
        jbDetailsOrderItem.setFocusable(false);
        jbDetailsOrderItem.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbDetailsOrderItem.setName(""); // NOI18N
        jbDetailsOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetailsOrderItemActionPerformed(evt);
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
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbDetailsOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDetailsOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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

    private void jbDetailsOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetailsOrderItemActionPerformed
        try {
            int indexSelected = jTableOrders.getSelectedRow();
            Order order = new OrderDAO().FindAll().get(indexSelected);

            new SoldsOrderItemConsolid(order).setVisible(true);
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao exibir tela de detalhes de itens de pedido").error();
        }
    }//GEN-LAST:event_jbDetailsOrderItemActionPerformed

    private void jTableOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdersMouseClicked
        jbDetailsOrderItem.setEnabled(true);
    }//GEN-LAST:event_jTableOrdersMouseClicked

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
            java.util.logging.Logger.getLogger(SoldsListAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoldsListAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoldsListAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoldsListAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SoldsListAll().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableOrders;
    private javax.swing.JButton jbDetailsOrderItem;
    // End of variables declaration//GEN-END:variables
}
