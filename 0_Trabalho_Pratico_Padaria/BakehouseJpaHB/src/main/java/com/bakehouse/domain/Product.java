package com.bakehouse.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Produtos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduto")
    private int id;
    
    @Column(name = "Descricao")
    private String description;
    
    @Column(name = "CodigoDeBarras")
    private String barCode;
    
    @Column(name = "Quantidade")
    private double quantity;
    
    @Column(name = "QuantidadeMinima")
    private double minQuantity;
    
    @Column(name = "ValorUnitario")
    private double valueUnitary;

    @ManyToOne
    private UnitOfMeasurement unitOfMeasurement;
    
    @Column(name = "IDUnidadeMedida")
    private int idUnitOfMeasurement;
    
    @ManyToOne
    private Category category;
    
    @Column(name = "IDCategoria")
    private int idCategory;

    public Product() {
    }

    public Product(int id, String description, String barCode, double quantity, double minQuantity, double valueUnitary, int idUnitOfMeasurement, int idCategory) {
        this.id = id;
        this.description = description;
        this.barCode = barCode;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.valueUnitary = valueUnitary;
        this.idUnitOfMeasurement = idUnitOfMeasurement;
        this.idCategory = idCategory;
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

    public int getIdUnitOfMeasurement() {
        return idUnitOfMeasurement;
    }

    public void setIdUnitOfMeasurement(int idUnitOfMeasurement) {
        this.idUnitOfMeasurement = idUnitOfMeasurement;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}