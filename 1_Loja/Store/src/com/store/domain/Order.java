package com.store.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items = new ArrayList<>();
    private LocalDate dateHour;
    private boolean status;

    public Order () {}
    
    public Order(LocalDate dateHour) {
        this.dateHour = dateHour;
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
    
    public void setOrderItem(List<OrderItem> items) {
        this.items = items;
    }
}