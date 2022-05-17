package com.bakehouse.viewobjects.product;

import com.bakehouse.domain.Category;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.Result;
import com.bakehouse.helpers.Validations;

public class ProductVO {
    private int id;
    private String description;
    private String barCode;
    private double quantity;
    private double minQuantity;
    private double valueUnitary;
    private Category category;
    private UnitOfMeasurement unitOfMeasurement;

    public ProductVO() {
    }

    public ProductVO(int id, String description, String barCode, double quantity, double minQuantity, double valueUnitary, Category category, UnitOfMeasurement unitOfMeasurement) {
        this.id = id;
        this.description = description;
        this.barCode = barCode;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.valueUnitary = valueUnitary;
        this.category = category;
        this.unitOfMeasurement = unitOfMeasurement;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public double getValueUnitary() {
        return valueUnitary;
    }

    public void setValueUnitary(double valueUnitary) {
        this.valueUnitary = valueUnitary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    
    public Result valid() {
        try {
            if (id < -1 || id == 0)
                return new Result("Id inválido", false);
            if (Validations.stringIsNullOrEmpty(description) || description.length() > 30) 
                return new Result("Descrição deve ser informada e conter até 30 caracteres", false);
            if (Validations.stringIsNullOrEmpty(barCode) || barCode.length() > 15)
                return new Result("Código de barras deve ser informada e conter até 15 caracteres", false);
            if (quantity <= 0)
                return new Result("Quantidade deve ser maior que zero", false);
            if (minQuantity <= 0)
                return new Result("Quantidade mínima deve ser maior que zero", false);
            if (valueUnitary <= 0)
                return new Result("Valor unitário deve ser maior que zero", false);
            if (category == null)
                return new Result("Categoria deve ser informada", false);
            if (unitOfMeasurement == null)
                return new Result("Unidade de medida deve ser informada", false);
            
            return new Result("", true);
        } catch (Exception ex) {
            return new Result("Falha inesperada ao validar entradas", false);
        }
    }
}