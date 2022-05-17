package com.bakehouse.viewobjects.category;

import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;

public class CategoryVO {
    private int id;
    private String description;

    public CategoryVO() {
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
            if (id < -1 || id == 0)
                return new Result("Id inválido", false);
            if (Validations.stringIsNullOrEmpty(description))
                return new Result("Descrição não informada", false);
            
            return new Result("OK", true);
        } catch (Exception ex) {
            return new Result("Ocorreu um erro inesperado", false);
        }
    }
}