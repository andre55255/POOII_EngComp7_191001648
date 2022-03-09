package com.store.domain;

public class Category {
    private int id;
    private String description;
    private double tax;

    public Category(String description, double tax) {
        this.description = description;
        this.tax = tax;
    }

    public Category(int id, String description, double tax) {
        this.id = id;
        this.description = description;
        this.tax = tax;
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

    public void setTax(double tax) {
        this.tax = tax;
    }
    
    public double getTax() {
        return this.tax;
    }
}