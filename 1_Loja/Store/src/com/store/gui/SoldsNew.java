package com.store.gui;

import com.store.dao.OrderDAO;
import com.store.dao.OrderItemDAO;
import com.store.dao.ProductDAO;
import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import com.store.helpers.EmitAlert;
import com.store.services.OrderService;
import com.store.services.ProductService;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SoldsNew extends javax.swing.JFrame {

    private Order order;
    
    public SoldsNew() {
        initComponents();
        this.renderTable();
        order = new Order(LocalDate.now());
    }
    
    public SoldsNew(Order order) {
        initComponents();
        this.renderTable();
        this.order = order;
        this.updateInputsOrder();
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
    
    private boolean validProductAvailableQuantity() {
        try {
            boolean res = true;
            
            for (OrderItem item : this.order.getOrderItem()) {
                if (item.getQuantity() > item.getProduct().getQuantity()) {
                    res = false;
                }
            }
                
            return res;
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao validar produtos em estoque").error();
            return false;
        }
    }
   
    private double getValueTotalOrder() {
        try {
            double total = 0.0;
            
            for (OrderItem item : this.order.getOrderItem()) {
                total += item.getQuantity() * item.getValueUnitary();
            }
            
            return total;
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao calcular valor total de pedido").error();
            return 0.0;
        }
    }
    
    private void updateInputsOrder() {
        try {
            jtfQuantityItems.setText(this.order.getOrderItem().size() + " itens");
            jtfValueItems.setText(this.money(getValueTotalOrder()));
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao atualizar informações de pedido").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jbtnAddOrderItem = new javax.swing.JButton();
        jbtnGetOrderItem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtfQuantityItems = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfValueItems = new javax.swing.JTextField();
        jbtnConfirmBuy = new javax.swing.JButton();
        jbtnClearOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova venda");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/store/assets/favicon.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 10, 120));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOVA VENDA - SELECIONE UM PRODUTO E ADICIONE NO CARRINHO");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
        jScrollPane.setViewportView(jTableProducts);

        jbtnAddOrderItem.setBackground(new java.awt.Color(36, 22, 84));
        jbtnAddOrderItem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbtnAddOrderItem.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAddOrderItem.setText("Adicionar no carrinho");
        jbtnAddOrderItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbtnAddOrderItem.setBorderPainted(false);
        jbtnAddOrderItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAddOrderItem.setFocusable(false);
        jbtnAddOrderItem.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbtnAddOrderItem.setName(""); // NOI18N
        jbtnAddOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddOrderItemActionPerformed(evt);
            }
        });

        jbtnGetOrderItem.setBackground(new java.awt.Color(255, 0, 51));
        jbtnGetOrderItem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbtnGetOrderItem.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGetOrderItem.setText("Ver itens do carrinho");
        jbtnGetOrderItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbtnGetOrderItem.setBorderPainted(false);
        jbtnGetOrderItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGetOrderItem.setFocusable(false);
        jbtnGetOrderItem.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbtnGetOrderItem.setName(""); // NOI18N
        jbtnGetOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGetOrderItemActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 22, 84));
        jLabel7.setText("Quantidade de itens no carrinho");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfQuantityItems.setEditable(false);
        jtfQuantityItems.setBackground(new java.awt.Color(255, 255, 255));
        jtfQuantityItems.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfQuantityItems.setForeground(new java.awt.Color(36, 22, 84));
        jtfQuantityItems.setText("0");
        jtfQuantityItems.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(36, 22, 84));
        jLabel8.setText("Valor total de itens no carrinho");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jtfValueItems.setEditable(false);
        jtfValueItems.setBackground(new java.awt.Color(255, 255, 255));
        jtfValueItems.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jtfValueItems.setForeground(new java.awt.Color(36, 22, 84));
        jtfValueItems.setText("R$ 0,00");
        jtfValueItems.setBorder(null);

        jbtnConfirmBuy.setBackground(new java.awt.Color(36, 22, 84));
        jbtnConfirmBuy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbtnConfirmBuy.setForeground(new java.awt.Color(255, 255, 255));
        jbtnConfirmBuy.setText("Confirmar compra");
        jbtnConfirmBuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbtnConfirmBuy.setBorderPainted(false);
        jbtnConfirmBuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnConfirmBuy.setFocusable(false);
        jbtnConfirmBuy.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbtnConfirmBuy.setName(""); // NOI18N
        jbtnConfirmBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmBuyActionPerformed(evt);
            }
        });

        jbtnClearOrder.setBackground(new java.awt.Color(255, 0, 51));
        jbtnClearOrder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbtnClearOrder.setForeground(new java.awt.Color(255, 255, 255));
        jbtnClearOrder.setText("Limpar carrinho");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfQuantityItems)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfValueItems)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnGetOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnAddOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnConfirmBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAddOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGetOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfQuantityItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValueItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnConfirmBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnClearOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void jbtnAddOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddOrderItemActionPerformed
        try {
            ProductDAO dbProd = new ProductDAO();
            Product product = dbProd.FindAll().get(jTableProducts.getSelectedRow());
            
            boolean isExistsItemList = false;
            OrderItemDAO dbOrderItem = new OrderItemDAO();
                    
            for (OrderItem oi : this.order.getOrderItem()) {
                if (oi.getProduct() == product) {
                    oi.setQuantity(oi.getQuantity()+1);
                    updateInputsOrder();
                    
                    isExistsItemList = true;
                    return;
                }
            }
            
            if (!isExistsItemList) {
                OrderItem item = new OrderItem(product, 1, product.getValueUnitary(), product.getCategory().getTax());
                this.order.addOrderItem(item);
                updateInputsOrder();
                dbOrderItem.Insert(item);
                return;
            }
            
            new EmitAlert(this, "Falha ao adicionar item ao pedido").error();
        } catch (Exception ex) {
            new EmitAlert(this, "Erro ao adicionar item ao pedido").error();
        }
    }//GEN-LAST:event_jbtnAddOrderItemActionPerformed

    private void jbtnGetOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGetOrderItemActionPerformed
        new SoldsOrderItems(this.order).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnGetOrderItemActionPerformed

    private void jbtnClearOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearOrderActionPerformed
        try {
            OrderItemDAO dao = new OrderItemDAO();
            
            for (OrderItem item : this.order.getOrderItem()) {
                dao.Delete(item.getId());
            }
            
            this.order.getOrderItem().clear();
            this.updateInputsOrder();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao limpar pedido").error();
        }
    }//GEN-LAST:event_jbtnClearOrderActionPerformed

    private void jbtnConfirmBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmBuyActionPerformed
        try {
            if (this.order.getOrderItem().isEmpty()) {
                new EmitAlert(this, "Nenhum item adicionado a este pedido, verifique").warning();
                return;
            }
            
            if (!this.validProductAvailableQuantity()) {
                new EmitAlert(this, "Quantidade de item superior ao estoque, verifique qual e tente novamente").error();
                return;
            }
            
            OrderDAO dbOrder = new OrderDAO();
            
            dbOrder.Insert(this.order);
            OrderService.closeOrder(this.order);
            
            this.order = new Order();
            this.updateInputsOrder();
            this.renderTable();
            
            new EmitAlert(this, "Movimentação efetuada com sucesso").success();
        } catch (Exception ex) {
            new EmitAlert(this, "Ocorreu um erro ao confirmar venda").error();
        }
    }//GEN-LAST:event_jbtnConfirmBuyActionPerformed

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
            java.util.logging.Logger.getLogger(SoldsNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoldsNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoldsNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoldsNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SoldsNew().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbtnAddOrderItem;
    private javax.swing.JButton jbtnClearOrder;
    private javax.swing.JButton jbtnConfirmBuy;
    private javax.swing.JButton jbtnGetOrderItem;
    private javax.swing.JTextField jtfQuantityItems;
    private javax.swing.JTextField jtfValueItems;
    // End of variables declaration//GEN-END:variables
}
