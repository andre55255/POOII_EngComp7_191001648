package com.bakehouse.gui_private.products;

import com.bakehouse.dao.impl.CategoryDAOImpl;
import com.bakehouse.dao.impl.UnitOfMeasurementDAOImpl;
import com.bakehouse.dao.interfaces.ICategoryDAO;
import com.bakehouse.dao.interfaces.IUnitOfMeasurementDAO;
import com.bakehouse.domain.Category;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.impl.ProductService;
import com.bakehouse.services.interfaces.IProductService;
import com.bakehouse.viewobjects.product.ProductVO;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class ProductCreate extends javax.swing.JFrame {

    private List<Category> categories = new ArrayList<>();
    private List<UnitOfMeasurement> unitsOfMeasurement = new ArrayList<>();

    public ProductCreate() {
        initComponents();
        loadComboBoxesCategoryUnitOfMeasurement();
    }

    private void loadComboBoxesCategoryUnitOfMeasurement() {
        try
        {
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            ICategoryDAO catDao = new CategoryDAOImpl();
            IUnitOfMeasurementDAO unitsDao = new UnitOfMeasurementDAOImpl();
            Thread t = new Thread() {
                @Override
                public void run() {
                    List<Category> catsAux = catDao.findAll();
                    List<UnitOfMeasurement> unitAux = unitsDao.findAll();
                    loadGui.dispose();
                    if (catsAux == null || unitAux == null
                            || catsAux.size() <= 0 || unitAux.size() <= 0)
                    {
                        new EmitAlert(compThis, "Ocorreu um problema ao buscar categorias e unidades de medida no banco").error();
                        compThis.setVisible(false);
                        return;
                    }
                    categories.clear();
                    unitsOfMeasurement.clear();
                    categories.addAll(catsAux);
                    unitsOfMeasurement.addAll(unitAux);
                    for (Category cat : categories)
                    {
                        jcbxCategory.addItem(cat.getDescription());
                    }
                    for (UnitOfMeasurement unit : unitsOfMeasurement)
                    {
                        jcbxUnitOfMeasurement.addItem(unit.getDescription());
                    }
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Erro ao carregar lista de categoria e uniades de medida").error();
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfBarCode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfMinQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jcbxCategory = new javax.swing.JComboBox<>();
        jcbxUnitOfMeasurement = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jbCreateProduct = new javax.swing.JButton();
        jtfValueUnitary = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar produto");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CRIAR PRODUTO");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 0));
        jLabel5.setText("Descrição");
        jLabel5.setAlignmentX(365.0F);
        jLabel5.setAlignmentY(23.0F);

        jtfDescription.setBackground(new java.awt.Color(240, 240, 240));
        jtfDescription.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfDescription.setForeground(new java.awt.Color(10, 16, 26));
        jtfDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfDescription.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 150, 0));
        jLabel6.setText("Código de Barras");
        jLabel6.setAlignmentX(365.0F);
        jLabel6.setAlignmentY(23.0F);

        jtfBarCode.setBackground(new java.awt.Color(240, 240, 240));
        jtfBarCode.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfBarCode.setForeground(new java.awt.Color(10, 16, 26));
        jtfBarCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfBarCode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfBarCode.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 150, 0));
        jLabel7.setText("Quantidade em estoque");
        jLabel7.setAlignmentX(365.0F);
        jLabel7.setAlignmentY(23.0F);

        jtfQuantity.setBackground(new java.awt.Color(240, 240, 240));
        jtfQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfQuantity.setForeground(new java.awt.Color(10, 16, 26));
        jtfQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfQuantity.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 150, 0));
        jLabel8.setText("Quantidade mínima permitida");
        jLabel8.setAlignmentX(365.0F);
        jLabel8.setAlignmentY(23.0F);

        jtfMinQuantity.setBackground(new java.awt.Color(240, 240, 240));
        jtfMinQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfMinQuantity.setForeground(new java.awt.Color(10, 16, 26));
        jtfMinQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfMinQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfMinQuantity.setMargin(new java.awt.Insets(25, 10, 25, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 150, 0));
        jLabel9.setText("Valor unitário R$");
        jLabel9.setAlignmentX(365.0F);
        jLabel9.setAlignmentY(23.0F);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 150, 0));
        jLabel10.setText("Categoria");
        jLabel10.setAlignmentX(365.0F);
        jLabel10.setAlignmentY(23.0F);

        jcbxCategory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxCategory.setForeground(new java.awt.Color(10, 16, 26));
        jcbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma categoria" }));
        jcbxCategory.setToolTipText("");
        jcbxCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jcbxUnitOfMeasurement.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxUnitOfMeasurement.setForeground(new java.awt.Color(10, 16, 26));
        jcbxUnitOfMeasurement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma unidade de medida" }));
        jcbxUnitOfMeasurement.setToolTipText("");
        jcbxUnitOfMeasurement.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 150, 0));
        jLabel11.setText("Unidade de Medida");
        jLabel11.setAlignmentX(365.0F);
        jLabel11.setAlignmentY(23.0F);

        jbCreateProduct.setBackground(new java.awt.Color(36, 162, 73));
        jbCreateProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbCreateProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbCreateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbCreateProduct.setText("Criar");
        jbCreateProduct.setAlignmentX(0.5F);
        jbCreateProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbCreateProduct.setBorderPainted(false);
        jbCreateProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCreateProduct.setFocusable(false);
        jbCreateProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbCreateProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbCreateProduct.setName(""); // NOI18N
        jbCreateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCreateProductActionPerformed(evt);
            }
        });

        jtfValueUnitary.setBackground(new java.awt.Color(240, 240, 240));
        jtfValueUnitary.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfValueUnitary.setForeground(new java.awt.Color(10, 16, 26));
        jtfValueUnitary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 238, 221)));
        jtfValueUnitary.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtfValueUnitary.setMargin(new java.awt.Insets(25, 10, 25, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbCreateProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbxCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDescription, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBarCode, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfMinQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jtfValueUnitary)))
                    .addComponent(jcbxUnitOfMeasurement, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMinQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValueUnitary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbxUnitOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbCreateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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

    private void jbCreateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCreateProductActionPerformed
        try
        {
            String description = jtfDescription.getText();
            String barCode = jtfBarCode.getText();
            double quantity = Double.parseDouble(jtfQuantity.getText());
            double minQuantity = Double.parseDouble(jtfMinQuantity.getText());
            double valueUnitary = Double.parseDouble(jtfValueUnitary.getText());
            int indexSelectedCategory = jcbxCategory.getSelectedIndex();
            if (indexSelectedCategory == 0)
            {
                new EmitAlert(this, "Selecione uma categoria").error();
                return;
            }
            Category category = this.categories.get(indexSelectedCategory - 1);
            int indexSelectedUnit = jcbxUnitOfMeasurement.getSelectedIndex();
            if (indexSelectedUnit == 0) {
                new EmitAlert(this, "Selecione uma unidade de medida").error();
                return;
            }
            UnitOfMeasurement unitOfMeasurement = this.unitsOfMeasurement.get(indexSelectedUnit - 1);
            ProductVO prodVO = new ProductVO();
            prodVO.setId(-1);
            prodVO.setDescription(description);
            prodVO.setBarCode(barCode);
            prodVO.setQuantity(quantity);
            prodVO.setMinQuantity(minQuantity);
            prodVO.setValueUnitary(valueUnitary);
            prodVO.setCategory(category);
            prodVO.setUnitOfMeasurement(unitOfMeasurement);
            IProductService prodService = new ProductService();
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Thread t = new Thread(){
                @Override
                public void run() {
                    Result result = prodService.insert(prodVO);
                    loadGui.dispose();
                    if (!result.isSuccess()) {
                        new EmitAlert(compThis, result.getMessage()).error();
                    } else {
                        new EmitAlert(compThis, "Produto criado com sucesso").success();
                        compThis.setVisible(false);
                    }
                }
            };
            t.start();
        } catch (NumberFormatException ex)
        {
            new EmitAlert(this, "Informe apenas valores numéricos nos campos de quantidade, quantidade mínima e valor unitário").error();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Ocorreu um erro inesperado").error();
        }
    }//GEN-LAST:event_jbCreateProductActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ProductCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ProductCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ProductCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ProductCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new ProductCreate().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCreateProduct;
    private javax.swing.JButton jbCreateUser;
    private javax.swing.JComboBox<String> jcbxCategory;
    private javax.swing.JComboBox<String> jcbxUnitOfMeasurement;
    private javax.swing.JTextField jtfBarCode;
    private javax.swing.JTextField jtfDescription;
    private javax.swing.JTextField jtfMinQuantity;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfValueUnitary;
    // End of variables declaration//GEN-END:variables
}
