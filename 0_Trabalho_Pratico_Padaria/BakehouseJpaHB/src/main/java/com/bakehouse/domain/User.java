package com.bakehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Usuario")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUsuario")
    private int id;
    
    @Column(name = "Login", length = 50, nullable = false, unique = true)
    private String login;
    
    @Column(name = "Nome", length = 60, nullable = false)
    private String name;
    
    @Column(name = "Senha", length = 15, nullable = false)
    private String password;
    
    @Column(name = "Status", length = 20, nullable = false)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "IDPerfil", nullable = false)
    private Role role;
    
    @OneToMany(mappedBy = "user")
    private List<Movement> movements = new ArrayList<>();

    public User() {
    }
    
    public User(int id, String login, String name, String password, String status, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
}