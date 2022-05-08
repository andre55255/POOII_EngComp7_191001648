package com.bakehouse.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Movimento")
public class Movement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMovimento")
    private int id;
    
    @Column(name = "Descricao", length = 20, nullable = false)
    private String description;
    
    @Column(name = "Tipo", length = 20, nullable = false)
    private String type;
    
    @Column(name = "DataMovimento", nullable = false)
    private LocalDateTime dateReference;
    
    @Column(name = "Valor", precision = 2, scale = 10, nullable = false)
    private double totalValue;
    
    @ManyToOne
    @JoinColumn(name = "IDUsuario", nullable = false)
    private User user;

    public Movement() {
    }

    public Movement(int id, String description, String type, LocalDateTime dateReference, double totalValue, User user) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.dateReference = dateReference;
        this.totalValue = totalValue;
        this.user = user;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateReference() {
        return dateReference;
    }

    public void setDateReference(LocalDateTime dateReference) {
        this.dateReference = dateReference;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}