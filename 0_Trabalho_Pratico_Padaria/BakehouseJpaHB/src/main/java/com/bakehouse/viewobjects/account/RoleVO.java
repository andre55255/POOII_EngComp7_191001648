package com.bakehouse.viewobjects.account;

import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;

public class RoleVO {
    private int id;
    private String description;

    public RoleVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Result valid() {
        try {
            if (Validations.stringIsNullOrEmpty(description))
                return new Result("Descrição não informada", false);
            if (id < -1 || id == 0)
                return new Result("ID inválido", false);

            return new Result("", true);
        } catch (Exception ex) {
            return new Result("Erro inesperado de validação", false);
        }
    }
}