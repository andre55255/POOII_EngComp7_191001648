package com.bakehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Produtos")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduto")
    private int id;
    
    @Column(name = "Descricao", length = 30, nullable = false)
    private String description;
    
    @Column(name = "CodigoDeBarras", length = 15, nullable = false)
    private String barCode;
    
    @Column(name = "Quantidade", precision = 2, scale = 10, nullable = false)
    private double quantity;
    
    @Column(name = "QuantidadeMinima", precision = 2, scale = 10, nullable = false)
    private double minQuantity;
    
    @Column(name = "ValorUnitario", precision = 2, scale = 10, nullable = false)
    private double valueUnitary;

    @ManyToOne
    @JoinColumn(name = "IDUnidadeMedida", nullable = false)
    private UnitOfMeasurement unitOfMeasurement;
    
    @ManyToOne
    @JoinColumn(name = "IDCategoria", nullable = false)
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<OrderPadItem> items = new ArrayList<>();
    
    public Product() {
    }

    public Product(int id, String description, String barCode, double quantity, double minQuantity, double valueUnitary, List<OrderPadItem> items) {
        this.id = id;
        this.description = description;
        this.barCode = barCode;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.valueUnitary = valueUnitary;
        this.items = items;
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

    public List<OrderPadItem> getItems() {
        return items;
    }

    public void setItems(List<OrderPadItem> items) {
        this.items = items;
    }
}