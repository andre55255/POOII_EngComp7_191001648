package com.bakehouse.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Comanda")
public class OrderPad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDComanda")
    private int id;
    
    @Column(name = "DataComanda", nullable = false)
    private LocalDateTime dateReference;

    @OneToMany(mappedBy = "orderPad", cascade = CascadeType.ALL)
    private List<OrderPadItem> items = new ArrayList<>();
    
    public OrderPad() {
    }

    public OrderPad(int id, LocalDateTime dateReference, List<OrderPadItem> items) {
        this.id = id;
        this.dateReference = dateReference;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateReference() {
        return dateReference;
    }

    public void setDateReference(LocalDateTime dateReference) {
        this.dateReference = dateReference;
    }

    public List<OrderPadItem> getItems() {
        return items;
    }

    public void setItems(List<OrderPadItem> items) {
        this.items = items;
    }
}