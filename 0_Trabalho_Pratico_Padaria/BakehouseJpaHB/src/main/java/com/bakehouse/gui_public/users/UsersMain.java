package com.bakehouse.gui_public.users;

import com.bakehouse.dao.impl.UserDAOImpl;
import com.bakehouse.dao.interfaces.IUserDAO;
import com.bakehouse.domain.User;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Validations;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsersMain extends javax.swing.JPanel {

    public UsersMain() {
        initComponents();
        loadAllUsersToTableFromRepository();
    }
    
    private void loadUsersByNameToTableFromRepository(String name) {
        try {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            
            Thread t = new Thread(){
                @Override
                public void run() {
                    List<User> users = userDao.findByName(name);
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao buscar usuários por perfil no banco de dados").error();
        }
    }
    
    private void loadUsersByRoleToTableFromRepository(String role) {
        try {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            
            Thread t = new Thread(){
                @Override
                public void run() {
                    List<User> users = userDao.findByRole(role);
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao buscar usuários por perfil no banco de dados").error();
        }
    }
    
    private void loadAllUsersToTableFromRepository() {
        try {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            
            Thread t = new Thread(){
                @Override
                public void run() {
                    List<User> users = userDao.findAll();
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao buscar todos os usuários no banco de dados").error();
        }
    }
    
    private void loadUsersTable(List<User> users) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableUsers.getModel();
            model.setRowCount(0);
            for (User user : users) {
                model.addRow(new Object[] {
                    user.getId(),
                    user.getLogin(),
                    user.getName(),
                    user.getRole().getDescription()
                });
            } 
        } catch (Exception ex) {
            new EmitAlert(this, "Falha ao carregar usuários na tabela").error();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNav = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbUsers = new javax.swing.JButton();
        jbRoles = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jpContent = new javax.swing.JPanel();
        jpUsers = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jtfSearchUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbFilterUsers = new javax.swing.JComboBox<>();
        jbSearchUsers = new javax.swing.JButton();
        jbAddUser = new javax.swing.JButton();
        jbEditUser = new javax.swing.JButton();
        jbRemoveUser = new javax.swing.JButton();
        jbResetPassword = new javax.swing.JButton();

        jpNav.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 150, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GERENCIA DE USUÁRIOS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbUsers.setBackground(new java.awt.Color(250, 150, 0));
        jbUsers.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbUsers.setForeground(new java.awt.Color(255, 255, 255));
        jbUsers.setText("Usuários");
        jbUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbUsers.setBorderPainted(false);
        jbUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbUsers.setFocusable(false);
        jbUsers.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbUsers.setName(""); // NOI18N
        jbUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsersActionPerformed(evt);
            }
        });

        jbRoles.setBackground(new java.awt.Color(250, 150, 0));
        jbRoles.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbRoles.setForeground(new java.awt.Color(255, 255, 255));
        jbRoles.setText("Perfil");
        jbRoles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbRoles.setBorderPainted(false);
        jbRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRoles.setFocusable(false);
        jbRoles.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbRoles.setName(""); // NOI18N
        jbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jpContent.setBackground(new java.awt.Color(255, 255, 255));
        jpContent.setLayout(new java.awt.CardLayout());

        jpUsers.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 150, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GERENCIAR USUÁRIOS");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableUsers.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jTableUsers.setForeground(new java.awt.Color(51, 51, 51));
        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Login", "Nome", "Perfil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsers.setToolTipText("");
        jTableUsers.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(jTableUsers);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 150, 50));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pesquisar:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfSearchUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtfSearchUser.setForeground(new java.awt.Color(52, 52, 52));
        jtfSearchUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 150, 50));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Filtrar por:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jcbFilterUsers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbFilterUsers.setForeground(new java.awt.Color(52, 52, 52));
        jcbFilterUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Perfil", "Nome" }));
        jcbFilterUsers.setToolTipText("");
        jcbFilterUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jbSearchUsers.setBackground(new java.awt.Color(250, 150, 0));
        jbSearchUsers.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbSearchUsers.setForeground(new java.awt.Color(255, 255, 255));
        jbSearchUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-search.png"))); // NOI18N
        jbSearchUsers.setText("Pesquisar");
        jbSearchUsers.setAlignmentX(0.5F);
        jbSearchUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbSearchUsers.setBorderPainted(false);
        jbSearchUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearchUsers.setFocusable(false);
        jbSearchUsers.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSearchUsers.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbSearchUsers.setName(""); // NOI18N
        jbSearchUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchUsersActionPerformed(evt);
            }
        });

        jbAddUser.setBackground(new java.awt.Color(36, 162, 73));
        jbAddUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbAddUser.setForeground(new java.awt.Color(255, 255, 255));
        jbAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbAddUser.setText("Adicionar");
        jbAddUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbAddUser.setBorderPainted(false);
        jbAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddUser.setFocusable(false);
        jbAddUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAddUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbAddUser.setName(""); // NOI18N
        jbAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddUserActionPerformed(evt);
            }
        });

        jbEditUser.setBackground(new java.awt.Color(36, 22, 84));
        jbEditUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbEditUser.setForeground(new java.awt.Color(255, 255, 255));
        jbEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-edit.png"))); // NOI18N
        jbEditUser.setText("Editar");
        jbEditUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbEditUser.setBorderPainted(false);
        jbEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditUser.setFocusable(false);
        jbEditUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbEditUser.setName(""); // NOI18N
        jbEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditUserActionPerformed(evt);
            }
        });

        jbRemoveUser.setBackground(new java.awt.Color(255, 0, 51));
        jbRemoveUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbRemoveUser.setForeground(new java.awt.Color(255, 255, 255));
        jbRemoveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-remove.png"))); // NOI18N
        jbRemoveUser.setText("Remover");
        jbRemoveUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbRemoveUser.setBorderPainted(false);
        jbRemoveUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRemoveUser.setFocusable(false);
        jbRemoveUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbRemoveUser.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbRemoveUser.setName(""); // NOI18N
        jbRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveUserActionPerformed(evt);
            }
        });

        jbResetPassword.setBackground(new java.awt.Color(0, 102, 0));
        jbResetPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbResetPassword.setForeground(new java.awt.Color(255, 255, 255));
        jbResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-lock.png"))); // NOI18N
        jbResetPassword.setText("Redefinir Senha");
        jbResetPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbResetPassword.setBorderPainted(false);
        jbResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbResetPassword.setFocusable(false);
        jbResetPassword.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbResetPassword.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbResetPassword.setName(""); // NOI18N
        jbResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpUsersLayout = new javax.swing.GroupLayout(jpUsers);
        jpUsers.setLayout(jpUsersLayout);
        jpUsersLayout.setHorizontalGroup(
            jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsersLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFilterUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsersLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbSearchUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpUsersLayout.createSequentialGroup()
                        .addComponent(jbResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(jbAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpUsersLayout.setVerticalGroup(
            jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFilterUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jpContent.add(jpUsers, "cardUser");

        javax.swing.GroupLayout jpNavLayout = new javax.swing.GroupLayout(jpNav);
        jpNav.setLayout(jpNavLayout);
        jpNavLayout.setHorizontalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(jbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpNavLayout.setVerticalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsersActionPerformed
        CardLayout c1 = (CardLayout) jpContent.getLayout();
        c1.show(jpContent, "cardUser");
    }//GEN-LAST:event_jbUsersActionPerformed

    private void jbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRolesActionPerformed

    private void jbSearchUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchUsersActionPerformed
        try {
            int indexSelected = jcbFilterUsers.getSelectedIndex();
            if (indexSelected == 0) {
                loadAllUsersToTableFromRepository();
                return;
            } 
            String search = jtfSearchUser.getText();
            if (Validations.stringIsNullOrEmpty(search)) {
                new EmitAlert(this, "Informe o valor para filtrar").warning();
                return;
            }
            if (indexSelected < 0) {
                new EmitAlert(this, "Selecione o modo de filtragem").warning();
                return;
            }
            if (indexSelected == 1) {
                loadUsersByRoleToTableFromRepository(search);
            } else if (indexSelected == 2) {
                loadUsersByNameToTableFromRepository(search);
            } else {
                new EmitAlert(this, "Ocorreu um erro inesperado").error();
            }
        } catch (Exception ex) {
            new EmitAlert(this, "Erro ao filtrar usuários").error();
        }
    }//GEN-LAST:event_jbSearchUsersActionPerformed

    private void jbAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAddUserActionPerformed

    private void jbEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditUserActionPerformed

    private void jbRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRemoveUserActionPerformed

    private void jbResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbResetPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JButton jbAddUser;
    private javax.swing.JButton jbEditUser;
    private javax.swing.JButton jbRemoveUser;
    private javax.swing.JButton jbResetPassword;
    private javax.swing.JButton jbRoles;
    private javax.swing.JButton jbSearchUsers;
    private javax.swing.JButton jbUsers;
    private javax.swing.JComboBox<String> jcbFilterUsers;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpNav;
    private javax.swing.JPanel jpUsers;
    private javax.swing.JTextField jtfSearchUser;
    // End of variables declaration//GEN-END:variables
}
