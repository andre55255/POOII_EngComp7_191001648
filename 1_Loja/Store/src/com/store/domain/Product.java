package com.store.domain;

public class Product {
    private int id;
    private String description;
    private double quantity;
    private double valueUnitary;
    private Category category;
    
    public Product() {
    }

    public Product(String description, double quantity, double valueUnitary, Category category) {
        this.description = description;
        this.quantity = quantity;
        this.valueUnitary = valueUnitary;
        this.category = category;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
}