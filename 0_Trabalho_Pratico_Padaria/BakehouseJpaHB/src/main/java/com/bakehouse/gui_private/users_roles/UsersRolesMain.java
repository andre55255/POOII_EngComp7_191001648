package com.bakehouse.gui_private.users_roles;

import com.bakehouse.dao.impl.RoleDAOImpl;
import com.bakehouse.dao.impl.UserDAOImpl;
import com.bakehouse.dao.interfaces.IRoleDAO;
import com.bakehouse.dao.interfaces.IUserDAO;
import com.bakehouse.domain.Role;
import com.bakehouse.domain.User;
import com.bakehouse.gui_public.utils.LoadingGUI;
import com.bakehouse.helpers.ApplicationUser;
import com.bakehouse.helpers.EmitAlert;
import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;
import com.bakehouse.services.impl.AccountService;
import com.bakehouse.services.interfaces.IAccountService;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsersRolesMain extends javax.swing.JPanel {

    private List<User> users = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public UsersRolesMain() {
        initComponents();
        loadAllUsersToTableFromRepository();
    }

    private void loadUsersByNameToTableFromRepository(String name) {
        try
        {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);

            Thread t = new Thread() {
                @Override
                public void run() {
                    users.clear();
                    List<User> usersDB = userDao.findByName(name);
                    if (usersDB != null)
                    {
                        users.addAll(usersDB);
                    }
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar usuários por perfil no banco de dados").error();
        }
    }

    private void loadUsersByRoleToTableFromRepository(String role) {
        try
        {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);

            Thread t = new Thread() {
                @Override
                public void run() {
                    users.clear();
                    List<User> usersDB = userDao.findByRole(role);
                    if (usersDB != null)
                    {
                        users.addAll(usersDB);
                    }
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar usuários por perfil no banco de dados").error();
        }
    }

    private void loadAllUsersToTableFromRepository() {
        try
        {
            IUserDAO userDao = new UserDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);

            Thread t = new Thread() {
                @Override
                public void run() {
                    users.clear();
                    List<User> usersDB = userDao.findAll();
                    if (usersDB != null)
                    {
                        users.addAll(usersDB);
                    }
                    loadUsersTable(users);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os usuários no banco de dados").error();
        }
    }

    private void loadUsersTable(List<User> users) {
        try
        {
            DefaultTableModel model = (DefaultTableModel) jTableUsers.getModel();
            model.setRowCount(0);
            for (User user : users)
            {
                model.addRow(new Object[]
                {
                    user.getId(),
                    user.getLogin(),
                    user.getName(),
                    user.getRole().getDescription()
                });
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar usuários na tabela").error();
        }
    }

    private void loadRoleByDescriptionToTableFromRepository(String description) {
        try
        {
            IRoleDAO roleDao = new RoleDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    roles.clear();
                    List<Role> rolesDB = roleDao.findByDescription(description);
                    if (rolesDB != null)
                    {
                        roles.addAll(rolesDB);
                    }
                    loadRolesTable(roles);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar usuários por perfil no banco de dados").error();
        }
    }

    private void loadAllRolesToTableFromRepository() {
        try
        {
            IRoleDAO roleDao = new RoleDAOImpl();
            final LoadingGUI loadingGUI = new LoadingGUI();
            loadingGUI.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    roles.clear();
                    List<Role> rolesDB = roleDao.findAll();
                    if (rolesDB != null)
                    {
                        roles.addAll(rolesDB);
                    }
                    loadRolesTable(roles);
                    loadingGUI.dispose();
                }
            };
            t.start();
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao buscar todos os usuários no banco de dados").error();
        }
    }

    private void loadRolesTable(List<Role> roles) {
        try
        {
            DefaultTableModel model = (DefaultTableModel) jTableRole.getModel();
            model.setRowCount(0);
            for (Role role : roles)
            {
                model.addRow(new Object[]
                {
                    role.getId(),
                    role.getDescription()
                });
            }
        } catch (Exception ex)
        {
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
        jpRole = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRole = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jtfSearchRole = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jcbxRoleFilter = new javax.swing.JComboBox<>();
        jbSearchRoles = new javax.swing.JButton();
        jbAddRole = new javax.swing.JButton();
        jbEditRole = new javax.swing.JButton();
        jbRemoveRole = new javax.swing.JButton();

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
        jTableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsersMouseClicked(evt);
            }
        });
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
        jbEditUser.setEnabled(false);
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
        jbRemoveUser.setEnabled(false);
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
        jbResetPassword.setEnabled(false);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jpContent.add(jpUsers, "cardUser");

        jpRole.setBackground(new java.awt.Color(255, 255, 255));
        jpRole.setName(""); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 150, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GERENCIAR PERFIS");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableRole.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jTableRole.setForeground(new java.awt.Color(51, 51, 51));
        jTableRole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRole.setToolTipText("");
        jTableRole.setGridColor(new java.awt.Color(102, 102, 102));
        jTableRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRoleMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableRole);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(250, 150, 50));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Pesquisar:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfSearchRole.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jtfSearchRole.setForeground(new java.awt.Color(52, 52, 52));
        jtfSearchRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(250, 150, 50));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Filtrar por:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jcbxRoleFilter.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jcbxRoleFilter.setForeground(new java.awt.Color(52, 52, 52));
        jcbxRoleFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Descrição" }));
        jcbxRoleFilter.setToolTipText("");
        jcbxRoleFilter.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(250, 150, 0), 2, true));

        jbSearchRoles.setBackground(new java.awt.Color(250, 150, 0));
        jbSearchRoles.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbSearchRoles.setForeground(new java.awt.Color(255, 255, 255));
        jbSearchRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-search.png"))); // NOI18N
        jbSearchRoles.setText("Pesquisar");
        jbSearchRoles.setAlignmentX(0.5F);
        jbSearchRoles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbSearchRoles.setBorderPainted(false);
        jbSearchRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearchRoles.setFocusable(false);
        jbSearchRoles.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSearchRoles.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbSearchRoles.setName(""); // NOI18N
        jbSearchRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchRolesActionPerformed(evt);
            }
        });

        jbAddRole.setBackground(new java.awt.Color(36, 162, 73));
        jbAddRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbAddRole.setForeground(new java.awt.Color(255, 255, 255));
        jbAddRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-add.png"))); // NOI18N
        jbAddRole.setText("Adicionar");
        jbAddRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbAddRole.setBorderPainted(false);
        jbAddRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAddRole.setFocusable(false);
        jbAddRole.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAddRole.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbAddRole.setName(""); // NOI18N
        jbAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddRoleActionPerformed(evt);
            }
        });

        jbEditRole.setBackground(new java.awt.Color(36, 22, 84));
        jbEditRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbEditRole.setForeground(new java.awt.Color(255, 255, 255));
        jbEditRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-edit.png"))); // NOI18N
        jbEditRole.setText("Editar");
        jbEditRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbEditRole.setBorderPainted(false);
        jbEditRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditRole.setEnabled(false);
        jbEditRole.setFocusable(false);
        jbEditRole.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditRole.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbEditRole.setName(""); // NOI18N
        jbEditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditRoleActionPerformed(evt);
            }
        });

        jbRemoveRole.setBackground(new java.awt.Color(255, 0, 51));
        jbRemoveRole.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jbRemoveRole.setForeground(new java.awt.Color(255, 255, 255));
        jbRemoveRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ico-remove.png"))); // NOI18N
        jbRemoveRole.setText("Remover");
        jbRemoveRole.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jbRemoveRole.setBorderPainted(false);
        jbRemoveRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRemoveRole.setEnabled(false);
        jbRemoveRole.setFocusable(false);
        jbRemoveRole.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbRemoveRole.setMargin(new java.awt.Insets(8, 20, 8, 20));
        jbRemoveRole.setName(""); // NOI18N
        jbRemoveRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoveRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRoleLayout = new javax.swing.GroupLayout(jpRole);
        jpRole.setLayout(jpRoleLayout);
        jpRoleLayout.setHorizontalGroup(
            jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRoleLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxRoleFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRoleLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSearchRole, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbSearchRoles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpRoleLayout.createSequentialGroup()
                        .addGap(0, 436, Short.MAX_VALUE)
                        .addComponent(jbAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemoveRole, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpRoleLayout.setVerticalGroup(
            jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSearchRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxRoleFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearchRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRemoveRole, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jpContent.add(jpRole, "cardRole");

        javax.swing.GroupLayout jpNavLayout = new javax.swing.GroupLayout(jpNav);
        jpNav.setLayout(jpNavLayout);
        jpNavLayout.setHorizontalGroup(
            jpNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        loadAllUsersToTableFromRepository();
    }//GEN-LAST:event_jbUsersActionPerformed

    private void jbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRolesActionPerformed
        CardLayout c = (CardLayout) jpContent.getLayout();
        c.show(jpContent, "cardRole");
        loadAllRolesToTableFromRepository();
    }//GEN-LAST:event_jbRolesActionPerformed

    private void jbSearchUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchUsersActionPerformed
        try
        {
            int indexSelected = jcbFilterUsers.getSelectedIndex();
            if (indexSelected == 0)
            {
                loadAllUsersToTableFromRepository();
                return;
            }
            String search = jtfSearchUser.getText();
            if (Validations.stringIsNullOrEmpty(search))
            {
                new EmitAlert(this, "Informe o valor para filtrar").warning();
                return;
            }
            if (indexSelected < 0)
            {
                new EmitAlert(this, "Selecione o modo de filtragem").warning();
                return;
            }
            if (indexSelected == 1)
            {
                loadUsersByRoleToTableFromRepository(search);
            } else if (indexSelected == 2)
            {
                loadUsersByNameToTableFromRepository(search);
            } else
            {
                new EmitAlert(this, "Ocorreu um erro inesperado").error();
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Erro ao filtrar usuários").error();
        }
    }//GEN-LAST:event_jbSearchUsersActionPerformed

    private void jbAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddUserActionPerformed
        try
        {
            new CreateUser().setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de criação de usuário").error();
        }
    }//GEN-LAST:event_jbAddUserActionPerformed

    private void jbEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditUserActionPerformed
        try
        {
            int indexSelectedTable = jTableUsers.getSelectedRow();
            if (indexSelectedTable < 0)
            {
                new EmitAlert(this, "Selecione um usuário na tabela que deseja editar").warning();
                return;
            }
            User user = this.users.get(indexSelectedTable);
            if (user == null)
            {
                new EmitAlert(this, "Ocorreu um problema ao buscar usuário para edição").warning();
                return;
            }
            new EditUser(user).setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de edição de usuário").error();
        }
    }//GEN-LAST:event_jbEditUserActionPerformed

    private void jbRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveUserActionPerformed
        try
        {
            int indexSelectedTable = jTableUsers.getSelectedRow();
            if (indexSelectedTable < 0)
            {
                new EmitAlert(this, "Selecione um usuário na tabela que deseja excluir").warning();
                return;
            }
            User user = this.users.get(indexSelectedTable);
            if (user == null)
            {
                new EmitAlert(this, "Ocorreu um problema ao buscar usuário para deleção").warning();
                return;
            }
            User userCurrent = ApplicationUser.getInstance();
            if (userCurrent.getId() == user.getId())
            {
                new EmitAlert(this, "Não é possível excluir seu próprio usuário enquanto estiver logado").warning();
                return;
            }
            int isConfirm = new EmitAlert(this, "Deseja mesmo excluir o usuário: "
                    + user.getName() + ", id: "
                    + user.getId())
                    .confirm();

            if (isConfirm == 0)
            {
                Component compThis = this;
                LoadingGUI loadGui = new LoadingGUI();
                loadGui.setVisible(true);
                IAccountService accService = new AccountService();
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        Result result = accService.deleteUser(user.getId());
                        loadGui.dispose();
                        if (!result.isSuccess())
                        {
                            new EmitAlert(compThis, result.getMessage()).error();
                            return;
                        }
                        new EmitAlert(compThis, "Usuário deletado com sucesso").success();
                        loadAllUsersToTableFromRepository();
                    }
                };
                t.start();
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar alerta confirmação de exclusão").error();
        }
    }//GEN-LAST:event_jbRemoveUserActionPerformed

    private void jbResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResetPasswordActionPerformed
        try
        {
            int indexSelectedTable = jTableUsers.getSelectedRow();
            if (indexSelectedTable < 0)
            {
                new EmitAlert(this, "Selecione um usuário na tabela que deseja redefinir a senha").warning();
                return;
            }
            User user = this.users.get(indexSelectedTable);
            if (user == null)
            {
                new EmitAlert(this, "Ocorreu um problema ao buscar usuário").warning();
                return;
            }
            new ResetPassword(user).setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar a tela de redefinição de senha").error();
        }
    }//GEN-LAST:event_jbResetPasswordActionPerformed

    private void jTableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersMouseClicked
        jbEditUser.setEnabled(true);
        jbRemoveUser.setEnabled(true);
        jbResetPassword.setEnabled(true);
    }//GEN-LAST:event_jTableUsersMouseClicked

    private void jbRemoveRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoveRoleActionPerformed
        try
        {
            int indexSelectedTable = jTableRole.getSelectedRow();
            if (indexSelectedTable < 0)
            {
                new EmitAlert(this, "Selecione um perfil na tabela que deseja excluir").warning();
                return;
            }
            Role role = this.roles.get(indexSelectedTable);
            if (role == null)
            {
                new EmitAlert(this, "Ocorreu um problema ao buscar perfil para deleção").warning();
                return;
            }
            int isConfirm = new EmitAlert(this, "Deseja mesmo excluir o perfil: "
                    + role.getDescription()+ ", id: "
                    + role.getId())
                    .confirm();

            if (isConfirm == 0)
            {
                Component compThis = this;
                LoadingGUI loadGui = new LoadingGUI();
                loadGui.setVisible(true);
                IAccountService accService = new AccountService();
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        Result result = accService.deleteRole(role.getId());
                        loadGui.dispose();
                        if (!result.isSuccess())
                        {
                            new EmitAlert(compThis, result.getMessage()).error();
                            return;
                        }
                        new EmitAlert(compThis, "Perfil deletado com sucesso").success();
                        loadAllRolesToTableFromRepository();
                    }
                };
                t.start();
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar alerta confirmação de exclusão").error();
        }
    }//GEN-LAST:event_jbRemoveRoleActionPerformed

    private void jbEditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditRoleActionPerformed
        try
        {
            int indexSelectedTable = jTableRole.getSelectedRow();
            if (indexSelectedTable < 0)
            {
                new EmitAlert(this, "Selecione um pefil na tabela que deseja editar").warning();
                return;
            }
            Role role = this.roles.get(indexSelectedTable);
            if (role == null)
            {
                new EmitAlert(this, "Ocorreu um problema ao buscar perfil para edição").warning();
                return;
            }
            new EditRole(role).setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de edição de usuário").error();
        }
    }//GEN-LAST:event_jbEditRoleActionPerformed

    private void jbAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddRoleActionPerformed
        try
        {
            new CreateRole().setVisible(true);
        } catch (Exception ex)
        {
            new EmitAlert(this, "Falha ao carregar tela de criação de perfil").error();
        }
    }//GEN-LAST:event_jbAddRoleActionPerformed

    private void jbSearchRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchRolesActionPerformed
        try
        {
            int indexSelected = jcbxRoleFilter.getSelectedIndex();
            if (indexSelected == 0)
            {
                loadAllRolesToTableFromRepository();
                return;
            }
            String search = jtfSearchRole.getText();
            if (Validations.stringIsNullOrEmpty(search))
            {
                new EmitAlert(this, "Informe o valor para filtrar").warning();
                return;
            }
            if (indexSelected < 0)
            {
                new EmitAlert(this, "Selecione o modo de filtragem").warning();
                return;
            }
            if (indexSelected == 1)
            {
                loadRoleByDescriptionToTableFromRepository(search);
            } else
            {
                new EmitAlert(this, "Ocorreu um erro inesperado").error();
            }
        } catch (Exception ex)
        {
            new EmitAlert(this, "Erro ao filtrar usuários").error();
        }
    }//GEN-LAST:event_jbSearchRolesActionPerformed

    private void jTableRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRoleMouseClicked
        jbEditRole.setEnabled(true);
        jbRemoveRole.setEnabled(true);
    }//GEN-LAST:event_jTableRoleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableRole;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JButton jbAddRole;
    private javax.swing.JButton jbAddUser;
    private javax.swing.JButton jbEditRole;
    private javax.swing.JButton jbEditUser;
    private javax.swing.JButton jbRemoveRole;
    private javax.swing.JButton jbRemoveUser;
    private javax.swing.JButton jbResetPassword;
    private javax.swing.JButton jbRoles;
    private javax.swing.JButton jbSearchRoles;
    private javax.swing.JButton jbSearchUsers;
    private javax.swing.JButton jbUsers;
    private javax.swing.JComboBox<String> jcbFilterUsers;
    private javax.swing.JComboBox<String> jcbxRoleFilter;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpNav;
    private javax.swing.JPanel jpRole;
    private javax.swing.JPanel jpUsers;
    private javax.swing.JTextField jtfSearchRole;
    private javax.swing.JTextField jtfSearchUser;
    // End of variables declaration//GEN-END:variables
}
