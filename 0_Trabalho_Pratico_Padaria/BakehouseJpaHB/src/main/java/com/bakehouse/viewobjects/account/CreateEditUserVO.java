package com.bakehouse.viewobjects.account;

import com.bakehouse.domain.Role;
import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;

public class CreateEditUserVO {
    private int id;
    private String login;
    private String name;
    private String password;
    private Role role;

    public CreateEditUserVO() {
    }

    public CreateEditUserVO(int id, String login, String name, String password, Role role) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public Result valid() {
        try {
            if (id < -1 || id == 0)
                return new Result("Id inválido", false);
            if (Validations.stringIsNullOrEmpty(login))
                return new Result("Login não informado", false);
            if (id == -1 && Validations.stringIsNullOrEmpty(password))
                return new Result("Senha não informada", false);
            if (Validations.stringIsNullOrEmpty(name))
                return new Result("Nome não informado", false);
            if (role == null)
                return new Result("Perfil de usuário não informado", false);
            
            return new Result("OK", true);
        } catch (Exception ex) {
            return new Result("Ocorreu um erro inesperado", false);
        }
    }
}