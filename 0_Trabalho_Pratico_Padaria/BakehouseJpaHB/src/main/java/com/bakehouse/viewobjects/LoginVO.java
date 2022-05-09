package com.bakehouse.viewobjects;

import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;

public class LoginVO {
    private String login;
    private String password;

    public LoginVO() {
    }

    public LoginVO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Result valid() {
        try {
            if (Validations.stringIsNullOrEmpty(login))
                return new Result("Login não informado", false);
            if (Validations.stringIsNullOrEmpty(password))
                return new Result("Senha não informada", false);
            
            return new Result("OK", true);
        } catch (Exception ex) {
            return new Result("Ocorreu um erro inesperado", false);
        }
    }
}