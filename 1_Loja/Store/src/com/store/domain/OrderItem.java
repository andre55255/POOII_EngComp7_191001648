package com.store.domain;

public class OrderItem {
    private int id;
    private Product product;
    private int quantity;
    private double valueUnitary;
    private double tax;
    
    public OrderItem() {}
     
    public OrderItem(Product product, int quantity, double valueUnitary, double tax) {
        this.product = product;
        this.quantity = quantity;
        this.valueUnitary = valueUnitary;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValueUnitary() {
        return valueUnitary;
    }

    public void setValueUnitary(double valueUnitary) {
        this.valueUnitary = valueUnitary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}