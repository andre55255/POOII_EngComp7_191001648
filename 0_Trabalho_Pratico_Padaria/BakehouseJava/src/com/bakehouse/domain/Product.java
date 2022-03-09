package com.bakehouse.domain;

public class Product {
    private int id;
    private String barCode;
    private String description;
    private int quantity;
    private double valueUnitary;
    private int minQuantity;
    
    private UnitOfMeasurement unitOfMeasurement;
    private Category category;
}