package com.bakehouse.gui_private.products;

import com.bakehouse.dao.impl.CategoryDAOImpl;
import com.bakehouse.dao.impl.ProductDAOImpl;
import com.bakehouse.dao.impl.UnitOfMeasurementDAOImpl;
import com.bakehouse.dao.interfaces.ICategoryDAO;
import com.bakehouse.dao.interfaces.IProductDAO;
import com.bakehouse.dao.interfaces.IUnitOfMeasurementDAO;
import com.bakehouse.domain.Category;
import com.bakehouse.domain.Product;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.FormatInputs;
import com.bakehouse.helpers.Validations;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ProductsMain extends javax.swing.JPanel {

    private List<Product> products = new ArrayList<>();
    private Category category;
    private UnitOfMeasurement unitOfMeasurement;

    public ProductsMain() {
        initComponents();
        loadAllProductsByDescriptionToTableFromRepository();
    }

    private void loadProductsTable(List<Product> products) {
        try
        {
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            model.setRowCount(0);
            for (Product product : products)
            {
                model.addRow(new Object[]
                {
                    product.getId(),
                    product.getDescription(),
                    product.getBarCode(),
                    product.getQuantity(),
                    product.getMinQuantity(),
                    "R$ " + FormatInputs.money(product.getValueUnitary()),
                    product.getUnitOfMeasurement().getDescription(),
                    product.getCategory().getDescription()
                });
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar usuários na tabela").error();
        }
    }

    // Methods Search
    private void loadProductsByDescriptionToTableFromRepository(String description) {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = prodDao.findByDescription(description);
                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar produtos filtrando por descrição no banco de dados").error();
        }
    }

    private void loadProductsByCategoryToTableFromRepository(Category cat) {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = prodDao.findByCategory(cat);
                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar produtos filtrados por categoria no banco de dados").error();
        }
    }

    private void loadProductsByUnitOfMeasurementToTableFromRepository(UnitOfMeasurement unitofMeas) {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = prodDao.findByUnitOfMeasurement(unitofMeas);
                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar produtos filtrados por categoria no banco de dados").error();
        }
    }

    // Methods Ordination
    private void loadAllProductsByDescriptionToTableFromRepository() {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = new ArrayList<>();
                    if (jcbxIsAsc.isSelected())
                    {
                        prodsDB = prodDao.findAll(true);
                    } else
                    {
                        prodsDB = prodDao.findAll(false);
                    }

                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os produtos no banco de dados").error();
        }
    }

    private void loadAllProductsByCategoryToTableFromRepository() {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = new ArrayList<>();
                    if (jcbxIsAsc.isSelected())
                    {
                        prodsDB = prodDao.findAllByCategory(true);
                    } else
                    {
                        prodsDB = prodDao.findAllByCategory(false);
                    }

                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os produtos ordernados por valor no banco de dados").error();
        }
    }

    private void loadAllProductsByValueToTableFromRepository() {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = new ArrayList<>();
                    if (jcbxIsAsc.isSelected())
                    {
                        prodsDB = prodDao.findAllByValueUnitary(true);
                    } else
                    {
                        prodsDB = prodDao.findAllByValueUnitary(false);
                    }

                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os produtos no banco de dados").error();
        }
    }

    private void loadAllProductsByUnitOfMeasurementToTableFromRepository() {
        try
        {
            IProductDAO prodDao = new ProductDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    products.clear();
                    List<Product> prodsDB = new ArrayList<>();
                    if (jcbxIsAsc.isSelected())
                    {
                        prodsDB = prodDao.findAllByUnitOfMeasurement(true);
                    } else
                    {
                        prodsDB = prodDao.findAllByUnitOfMeasurement(false);
                    }

                    if (prodsDB != null)
                    {
                        products.addAll(prodsDB);
                    }
                    loadProductsTable(products);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os produtos no banco de dados").error();
        }
    }
    
    private void getCategoryByDescription(String description) {
        try {
            ICategoryDAO catDao = new CategoryDAOImpl();
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    List<Category> catsSave = catDao.findByDescription(description);
                    loadGui.dispose();
                    if (catsSave != null)
                        category = catsSave.get(0);
                    if (category != null)
                        loadProductsByCategoryToTableFromRepository(category);
                    else
                        new EmitAlert(compThis, "Nenhum produto encontrada com esta categoria").error();
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao buscar categoria no banco de dados").error();
        }
    }

    private void getUnitOfMeasurementByDescription(String description) {
        try {
            IUnitOfMeasurementDAO unitsDao = new UnitOfMeasurementDAOImpl();
            Component compThis = this;
            LoadingGUI loadGui = new LoadingGUI();
            loadGui.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    List<UnitOfMeasurement> uomsSave = unitsDao.findByDescription(description);
                    loadGui.dispose();
                    if (uomsSave != null)
                        unitOfMeasurement = uomsSave.get(0);
                    if (unitOfMeasurement != null)
                        loadProductsByUnitOfMeasurementToTableFromRepository(unitOfMeasurement);
                    else
                        new EmitAlert(compThis, "Nenhum produto encontrado com esta unidade de medida").error();
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao buscar unidade de medida no banco de dados").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNav = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbProducts = new javax.swing.JButton();
        jbUnitOfMeasurement = new javax.swing.JButton();
        jbCategory = new javax.swing.JButton();
        jpContent = new javax.swing.JPanel();
        jpProducts = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbxFilterProducts = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtfSearchUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbxOrdination = new javax.swing.JComboBox<>();
        jbSearchProducts = new javax.swing.JButton();
        jbOrdinationProducts = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jbAddProduct = new javax.swing.JButton();
        jbEditProduct = new javax.swing.JButton();
        jbRemoveProduct = new javax.swing.JButton();
        jcbxIsAsc = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(1040, 622));

        jpNav.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 150, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GERÊNCIA DE PRODUTOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbProducts.setBackground(new java.awt.Color(250, 150, 0));
        jbProducts.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbProducts.setForeground(new java.awt.Color(255, 255, 255));
        jbProducts.setText("Produtos");
        jbProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbProducts.setBorderPainted(false);
        jbProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProducts.setFocusable(false);
        jbProducts.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbProducts.setName(""); // NOI18N
        jbProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductsActionPerformed(evt);
            }
        });

        jbUnitOfMeasurement.setBackground(new java.awt.Color(250, 150, 0));
        jbUnitOfMeasurement.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbUnitOfMeasurement.setForeground(new java.awt.Color(255, 255, 255));
        jbUnitOfMeasurement.setText("Unidades de Medida");
        jbUnitOfMeasurement.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbUnitOfMeasurement.setBorderPainted(false);
        jbUnitOfMeasurement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbUnitOfMeasurement.setFocusable(false);
        jbUnitOfMeasurement.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbUnitOfMeasurement.setName(""); // NOI18N
        jbUnitOfMeasurement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUnitOfMeasurementActionPerformed(evt);
            }
        });

        jbCategory.setBackground(new java.awt.Color(250, 150, 0));
        jbCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbCategory.setForeground(new java.awt.Color(255, 255, 255));
        jbCategory.setText("Categorias de produtos");
        jbCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbCategory.setBorderPainted(false);
        jbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbCategory.setFocusable(false);
        jbCategory.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbCategory.setName(""); // NOI18N
        jbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpNavLayout = new javax.swing.GroupLayout(jpNav);
        jpNav.setLayout(jpNavLayout);
        jpNavLayout.setHorizontalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpNavLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbUnitOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpNavLayout.setVerticalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbUnitOfMeasurement, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpContent.setBackground(new java.awt.Color(255, 255, 255));
        jpContent.setLayout(new java.awt.CardLayout());

        jpProducts.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GERENCIAR PRODUTOS");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 50));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Filtrar por:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jcbxFilterProducts.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxFilterProducts.setForeground(new java.awt.Color(52, 52, 52));
        jcbxFilterProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Descrição", "Categoria", "Unidade de Medida" }));
        jcbxFilterProducts.setToolTipText("");
        jcbxFilterProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 150, 50));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pesquisar:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfSearchUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtfSearchUser.setForeground(new java.awt.Color(52, 52, 52));
        jtfSearchUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 150, 50));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ordernar:  ");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jcbxOrdination.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxOrdination.setForeground(new java.awt.Color(52, 52, 52));
        jcbxOrdination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrição", "Valor", "Unidade de medida", "Categoria" }));
        jcbxOrdination.setToolTipText("");
        jcbxOrdination.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jbSearchProducts.setBackground(new java.awt.Color(250, 150, 0));
        jbSearchProducts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbSearchProducts.setForeground(new java.awt.Color(255, 255, 255));
        jbSearchProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-search.png"))); // NOI18N
        jbSearchProducts.setText("Pesquisar");
        jbSearchProducts.setAlignmentX(0.5F);
        jbSearchProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbSearchProducts.setBorderPainted(false);
        jbSearchProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearchProducts.setFocusable(false);
        jbSearchProducts.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSearchProducts.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbSearchProducts.setName(""); // NOI18N
        jbSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchProductsActionPerformed(evt);
            }
        });

        jbOrdinationProducts.setBackground(new java.awt.Color(36, 22, 84));
        jbOrdinationProducts.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbOrdinationProducts.setForeground(new java.awt.Color(255, 255, 255));
        jbOrdinationProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-ordination.png"))); // NOI18N
        jbOrdinationProducts.setText("Ordenar");
        jbOrdinationProducts.setAlignmentX(0.5F);
        jbOrdinationProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbOrdinationProducts.setBorderPainted(false);
        jbOrdinationProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbOrdinationProducts.setFocusable(false);
        jbOrdinationProducts.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbOrdinationProducts.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbOrdinationProducts.setName(""); // NOI18N
        jbOrdinationProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOrdinationProductsActionPerformed(evt);
            }
        });

        jTableProducts.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jTableProducts.setForeground(new java.awt.Color(51, 51, 51));
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Código Barras", "Quantidade", "Quantia Mínima", "Valor Unitário", "Unidade Medida", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setToolTipText("");
        jTableProducts.setGridColor(new java.awt.Color(102, 102, 102));
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        jbAddProduct.setBackground(new java.awt.Color(36, 162, 73));
        jbAddProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbAddProduct.setText("Adicionar");
        jbAddProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbAddProduct.setBorderPainted(false);
        jbAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddProduct.setFocusable(false);
        jbAddProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAddProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbAddProduct.setName(""); // NOI18N
        jbAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProductActionPerformed(evt);
            }
        });

        jbEditProduct.setBackground(new java.awt.Color(36, 22, 84));
        jbEditProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbEditProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbEditProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-edit.png"))); // NOI18N
        jbEditProduct.setText("Editar");
        jbEditProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbEditProduct.setBorderPainted(false);
        jbEditProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditProduct.setEnabled(false);
        jbEditProduct.setFocusable(false);
        jbEditProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbEditProduct.setName(""); // NOI18N
        jbEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditProductActionPerformed(evt);
            }
        });

        jbRemoveProduct.setBackground(new java.awt.Color(255, 0, 51));
        jbRemoveProduct.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbRemoveProduct.setForeground(new java.awt.Color(255, 255, 255));
        jbRemoveProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-remove.png"))); // NOI18N
        jbRemoveProduct.setText("Remover");
        jbRemoveProduct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbRemoveProduct.setBorderPainted(false);
        jbRemoveProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRemoveProduct.setEnabled(false);
        jbRemoveProduct.setFocusable(false);
        jbRemoveProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbRemoveProduct.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbRemoveProduct.setName(""); // NOI18N
        jbRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveProductActionPerformed(evt);
            }
        });

        jcbxIsAsc.setBackground(new java.awt.Color(255, 255, 255));
        jcbxIsAsc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxIsAsc.setForeground(new java.awt.Color(250, 150, 0));
        jcbxIsAsc.setText("Ascendente?");
        jcbxIsAsc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbxIsAsc.setFocusable(false);

        javax.swing.GroupLayout jpProductsLayout = new javax.swing.GroupLayout(jpProducts);
        jpProducts.setLayout(jpProductsLayout);
        jpProductsLayout.setHorizontalGroup(
            jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpProductsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxFilterProducts, 0, 635, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpProductsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxOrdination, 0, 634, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbxIsAsc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbOrdinationProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpProductsLayout.setVerticalGroup(
            jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxFilterProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxOrdination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearchProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOrdinationProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxIsAsc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRemoveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jpContent.add(jpProducts, "cardProducts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductsActionPerformed
        CardLayout c1 = (CardLayout) jpContent.getLayout();
        c1.show(jpContent, "cardProducts");
        loadAllProductsByDescriptionToTableFromRepository();
    }//GEN-LAST:event_jbProductsActionPerformed

    private void jbUnitOfMeasurementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUnitOfMeasurementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbUnitOfMeasurementActionPerformed

    private void jbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCategoryActionPerformed

    private void jbSearchProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchProductsActionPerformed
        try
        {
            category = null;
            unitOfMeasurement = null;
            int indexSelected = jcbxFilterProducts.getSelectedIndex();
            if (indexSelected == 0) {
                loadAllProductsByDescriptionToTableFromRepository();
                return;
            }
            
            String search = jtfSearchUser.getText();
            if (Validations.stringIsNullOrEmpty(search)) {
                new EmitAlert(this, "Informe um valor para buscar").warning();
                return;
            }
            
            if (indexSelected == 1) {
                loadProductsByDescriptionToTableFromRepository(search);
            } else if (indexSelected == 2) {
                getCategoryByDescription(search);
            } else if (indexSelected == 3) {
                getUnitOfMeasurementByDescription(search);
            } else {
                new EmitAlert(this, "Opção selecionada inválida").error();
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Erro ao filtrar usuários").error();
        }
    }//GEN-LAST:event_jbSearchProductsActionPerformed

    private void jbOrdinationProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOrdinationProductsActionPerformed
        try {
            int indexSelected = jcbxOrdination.getSelectedIndex();
            if (indexSelected == 0) {
                loadAllProductsByDescriptionToTableFromRepository();
            } else if (indexSelected == 1) {
                loadAllProductsByValueToTableFromRepository();
            } else if (indexSelected == 2) {
                loadAllProductsByUnitOfMeasurementToTableFromRepository();
            } else if (indexSelected == 3) {
                loadAllProductsByCategoryToTableFromRepository();
            } else {
                new EmitAlert(this, "Opção selecionada inválida").error();
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Falha inesperada ao carregar tabela ordenada").error();
        }
    }//GEN-LAST:event_jbOrdinationProductsActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked

    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jbAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProductActionPerformed
        try
        {
            new ProductCreate().setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de criação de perfil").error();
        }
    }//GEN-LAST:event_jbAddProductActionPerformed

    private void jbEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditProductActionPerformed
        try
        {

        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de edição de usuário").error();
        }
    }//GEN-LAST:event_jbEditProductActionPerformed

    private void jbRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveProductActionPerformed
        try
        {

        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar alerta confirmação de exclusão").error();
        }
    }//GEN-LAST:event_jbRemoveProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbAddProduct;
    private javax.swing.JButton jbCategory;
    private javax.swing.JButton jbEditProduct;
    private javax.swing.JButton jbOrdinationProducts;
    private javax.swing.JButton jbProducts;
    private javax.swing.JButton jbRemoveProduct;
    private javax.swing.JButton jbSearchProducts;
    private javax.swing.JButton jbUnitOfMeasurement;
    private javax.swing.JComboBox<String> jcbxFilterProducts;
    private javax.swing.JCheckBox jcbxIsAsc;
    private javax.swing.JComboBox<String> jcbxOrdination;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpNav;
    private javax.swing.JPanel jpProducts;
    private javax.swing.JTextField jtfSearchUser;
    // End of variables declaration//GEN-END:variables
}
