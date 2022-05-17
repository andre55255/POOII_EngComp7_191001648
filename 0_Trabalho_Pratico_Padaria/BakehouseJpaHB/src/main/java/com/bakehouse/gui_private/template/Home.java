package com.bakehouse.gui_private.template;

import com.bakehouse.domain.User;
import com.bakehouse.gui_private.products.ProductsMain;
import com.bakehouse.gui_public.login.LoginGUI;
import com.bakehouse.gui_private.users_roles.UsersRolesMain;
import com.bakehouse.helpers.ApplicationUser;
import com.bakehouse.helpers.EmitAlert;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class Home extends javax.swing.JFrame {
    
    public Home() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void handlerPageDinamic(JPanel page) {
        page.setSize(1020, 650);
        page.setLocation(0,0);
        
        Content.removeAll();
        Content.add(page, BorderLayout.CENTER);
        Content.revalidate();
        Content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nav = new javax.swing.JPanel();
        NavHome = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NavProducts = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NavSales = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NavWorksheet = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        NavUsers = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        HeaderLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlUser = new javax.swing.JLabel();
        HeaderLogout = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame.png")).getImage());
        setName("home"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Nav.setBackground(new java.awt.Color(35, 35, 35));
        Nav.setPreferredSize(new java.awt.Dimension(250, 500));

        NavHome.setBackground(new java.awt.Color(255, 51, 0));
        NavHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NavHome.setDoubleBuffered(false);
        NavHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NavHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NavHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NavHomeMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Home");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-home.png"))); // NOI18N

        javax.swing.GroupLayout NavHomeLayout = new javax.swing.GroupLayout(NavHome);
        NavHome.setLayout(NavHomeLayout);
        NavHomeLayout.setHorizontalGroup(
            NavHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NavHomeLayout.setVerticalGroup(
            NavHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NavProducts.setBackground(new java.awt.Color(255, 51, 0));
        NavProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NavProducts.setDoubleBuffered(false);
        NavProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NavProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NavProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NavProductsMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estoque");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-hangar.png"))); // NOI18N

        javax.swing.GroupLayout NavProductsLayout = new javax.swing.GroupLayout(NavProducts);
        NavProducts.setLayout(NavProductsLayout);
        NavProductsLayout.setHorizontalGroup(
            NavProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NavProductsLayout.setVerticalGroup(
            NavProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NavSales.setBackground(new java.awt.Color(255, 51, 0));
        NavSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NavSales.setDoubleBuffered(false);
        NavSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NavSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NavSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NavSalesMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vendas");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-products.png"))); // NOI18N

        javax.swing.GroupLayout NavSalesLayout = new javax.swing.GroupLayout(NavSales);
        NavSales.setLayout(NavSalesLayout);
        NavSalesLayout.setHorizontalGroup(
            NavSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NavSalesLayout.setVerticalGroup(
            NavSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NavWorksheet.setBackground(new java.awt.Color(255, 51, 0));
        NavWorksheet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NavWorksheet.setDoubleBuffered(false);
        NavWorksheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NavWorksheetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NavWorksheetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NavWorksheetMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Relatórios");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-worksheet.png"))); // NOI18N

        javax.swing.GroupLayout NavWorksheetLayout = new javax.swing.GroupLayout(NavWorksheet);
        NavWorksheet.setLayout(NavWorksheetLayout);
        NavWorksheetLayout.setHorizontalGroup(
            NavWorksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavWorksheetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NavWorksheetLayout.setVerticalGroup(
            NavWorksheetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NavUsers.setBackground(new java.awt.Color(255, 51, 0));
        NavUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NavUsers.setDoubleBuffered(false);
        NavUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NavUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NavUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NavUsersMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Usuários");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-users.png"))); // NOI18N

        javax.swing.GroupLayout NavUsersLayout = new javax.swing.GroupLayout(NavUsers);
        NavUsers.setLayout(NavUsersLayout);
        NavUsersLayout.setHorizontalGroup(
            NavUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        NavUsersLayout.setVerticalGroup(
            NavUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout NavLayout = new javax.swing.GroupLayout(Nav);
        Nav.setLayout(NavLayout);
        NavLayout.setHorizontalGroup(
            NavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavLayout.createSequentialGroup()
                .addGroup(NavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NavLayout.createSequentialGroup()
                        .addComponent(NavHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NavLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(NavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NavProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NavSales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NavWorksheet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NavUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        NavLayout.setVerticalGroup(
            NavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(NavHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NavProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NavSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NavWorksheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NavUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        getContentPane().add(Nav, java.awt.BorderLayout.LINE_START);

        Header.setBackground(new java.awt.Color(55, 55, 55));
        Header.setPreferredSize(new java.awt.Dimension(800, 80));
        Header.setLayout(new java.awt.BorderLayout());

        HeaderLogo.setBackground(new java.awt.Color(55, 55, 55));
        HeaderLogo.setPreferredSize(new java.awt.Dimension(350, 80));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-frame-small.png"))); // NOI18N

        jlUser.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jlUser.setForeground(new java.awt.Color(255, 255, 255));
        jlUser.setText("Administrador de sistema, Fulan");

        javax.swing.GroupLayout HeaderLogoLayout = new javax.swing.GroupLayout(HeaderLogo);
        HeaderLogo.setLayout(HeaderLogoLayout);
        HeaderLogoLayout.setHorizontalGroup(
            HeaderLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLogoLayout.setVerticalGroup(
            HeaderLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Header.add(HeaderLogo, java.awt.BorderLayout.LINE_START);

        HeaderLogout.setBackground(new java.awt.Color(205, 92, 92));
        HeaderLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HeaderLogout.setPreferredSize(new java.awt.Dimension(150, 80));
        HeaderLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HeaderLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HeaderLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HeaderLogoutMouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon-logout.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setText("Sair");

        javax.swing.GroupLayout HeaderLogoutLayout = new javax.swing.GroupLayout(HeaderLogout);
        HeaderLogout.setLayout(HeaderLogoutLayout);
        HeaderLogoutLayout.setHorizontalGroup(
            HeaderLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLogoutLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );
        HeaderLogoutLayout.setVerticalGroup(
            HeaderLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Header.add(HeaderLogout, java.awt.BorderLayout.LINE_END);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(Content, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void HeaderLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderLogoutMouseEntered
        HeaderLogout.setBackground(new Color(255, 10, 10));
    }//GEN-LAST:event_HeaderLogoutMouseEntered

    private void HeaderLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderLogoutMouseExited
        HeaderLogout.setBackground(new Color(205, 92, 92));
    }//GEN-LAST:event_HeaderLogoutMouseExited

    private void HeaderLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderLogoutMouseClicked
        HeaderLogout.setBackground(new Color(248,120,120));
        
        new LoginGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HeaderLogoutMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        User userApplication = ApplicationUser.getInstance();
        if (userApplication == null) {
            new EmitAlert(this, "Faça login para utilizar o sistema").error();
            new LoginGUI().setVisible(true);
            this.dispose();
        } else {
            jlUser.setText(userApplication.getRole().getDescription() + ", " + userApplication.getName().split(" ")[0]);
        }
    }//GEN-LAST:event_formWindowActivated

    private void NavHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavHomeMouseEntered
        NavHome.setBackground(new Color(250,150,0));
    }//GEN-LAST:event_NavHomeMouseEntered

    private void NavHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavHomeMouseExited
        NavHome.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_NavHomeMouseExited

    private void NavHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavHomeMouseClicked
        NavHome.setBackground(new Color(255,102,51));
    }//GEN-LAST:event_NavHomeMouseClicked

    private void NavProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavProductsMouseClicked
        NavProducts.setBackground(new Color(255,102,51));
        handlerPageDinamic(new ProductsMain());
    }//GEN-LAST:event_NavProductsMouseClicked

    private void NavProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavProductsMouseEntered
        NavProducts.setBackground(new Color(250,150,0));
    }//GEN-LAST:event_NavProductsMouseEntered

    private void NavProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavProductsMouseExited
        NavProducts.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_NavProductsMouseExited

    private void NavSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavSalesMouseClicked
        NavSales.setBackground(new Color(255,102,51));
    }//GEN-LAST:event_NavSalesMouseClicked

    private void NavSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavSalesMouseEntered
        NavSales.setBackground(new Color(250,150,0));
    }//GEN-LAST:event_NavSalesMouseEntered

    private void NavSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavSalesMouseExited
        NavSales.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_NavSalesMouseExited

    private void NavWorksheetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavWorksheetMouseClicked
        NavWorksheet.setBackground(new Color(255,102,51));
    }//GEN-LAST:event_NavWorksheetMouseClicked

    private void NavWorksheetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavWorksheetMouseEntered
        NavWorksheet.setBackground(new Color(250,150,0));
    }//GEN-LAST:event_NavWorksheetMouseEntered

    private void NavWorksheetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavWorksheetMouseExited
        NavWorksheet.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_NavWorksheetMouseExited

    private void NavUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavUsersMouseClicked
        NavUsers.setBackground(new Color(255,102,51));
        handlerPageDinamic(new UsersRolesMain());
    }//GEN-LAST:event_NavUsersMouseClicked

    private void NavUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavUsersMouseEntered
        NavUsers.setBackground(new Color(250,150,0));
    }//GEN-LAST:event_NavUsersMouseEntered

    private void NavUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NavUsersMouseExited
        NavUsers.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_NavUsersMouseExited

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel HeaderLogo;
    private javax.swing.JPanel HeaderLogout;
    private javax.swing.JPanel Nav;
    private javax.swing.JPanel NavHome;
    private javax.swing.JPanel NavProducts;
    private javax.swing.JPanel NavSales;
    private javax.swing.JPanel NavUsers;
    private javax.swing.JPanel NavWorksheet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlUser;
    // End of variables declaration//GEN-END:variables
}
