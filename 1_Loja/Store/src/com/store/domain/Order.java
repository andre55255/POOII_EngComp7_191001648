package com.store.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private final List<OrderItem> items = new ArrayList<>();
    private LocalDate dateHour;

    public Order () {}
    
    public Order(int id, LocalDate dateHour) {
        this.id = id;
        this.dateHour = dateHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDate dateHour) {
        this.dateHour = dateHour;
    }
    
    public void addOrderItem(OrderItem oi) {
        this.items.add(oi);
    }
    
    public void removeOrderItem(OrderItem oi) {
        this.items.remove(oi);
    }
    
    public List<OrderItem> getOrderItem() {
        return this.items;
    }
}