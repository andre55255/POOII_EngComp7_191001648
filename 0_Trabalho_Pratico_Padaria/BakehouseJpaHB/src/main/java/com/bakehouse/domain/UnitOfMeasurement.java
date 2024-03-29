package com.bakehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UnidadeMedida")
public class UnitOfMeasurement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUnidadeMedida")
    private int id;
    
    @Column(name = "Descricao", nullable = false, length = 20)
    private String description;
    
    @OneToMany(mappedBy = "unitOfMeasurement")
    private List<Product> products = new ArrayList<>();
    
    public UnitOfMeasurement() {
    }

    public UnitOfMeasurement(int id, String description) {
        this.id = id;
        this.description = description;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}