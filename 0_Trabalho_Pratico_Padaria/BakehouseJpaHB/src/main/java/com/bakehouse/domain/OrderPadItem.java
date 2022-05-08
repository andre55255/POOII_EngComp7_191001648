package com.bakehouse.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Item_Comanda")
public class OrderPadItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDItemComanda")
    private int id;
    
    @Column(name = "Quantidade", precision = 2, scale = 10, nullable = false)
    private double quantity;
    
    @Column(name = "ValorUnitario", precision = 2, scale = 10, nullable = false)
    private double valueUnitary;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDComanda", nullable = false)
    private OrderPad orderPad;
    
    @ManyToOne
    @JoinColumn(name = "IDProduto", nullable = false)
    private Product product;

    public OrderPadItem() {
    }

    public OrderPadItem(int id, double quantity, double valueUnitary, OrderPad orderPad, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.valueUnitary = valueUnitary;
        this.orderPad = orderPad;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getValueUnitary() {
        return valueUnitary;
    }

    public void setValueUnitary(double valueUnitary) {
        this.valueUnitary = valueUnitary;
    }

    public OrderPad getOrderPad() {
        return orderPad;
    }

    public void setOrderPad(OrderPad orderPad) {
        this.orderPad = orderPad;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}