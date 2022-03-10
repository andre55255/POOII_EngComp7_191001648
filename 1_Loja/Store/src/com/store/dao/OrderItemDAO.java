package com.store.dao;

import com.store.domain.OrderItem;
import java.util.List;

public class OrderItemDAO {

    public static int idOrderItem;

    public boolean Insert(OrderItem order) {
        if (Context.dbOrderItems.isEmpty()) {
            OrderItemDAO.idOrderItem = 1;
        }

        order.setId(idOrderItem);
        OrderItemDAO.idOrderItem++;

        return Context.dbOrderItems.add(order);
    }

    public boolean Update(int id, OrderItem order) {
        OrderItem save = FindById(id);
        
        if (save == null) 
            return false;
        
        save.setQuantity(order.getQuantity());
        save.setValueUnitary(order.getValueUnitary());
        save.setProduct(order.getProduct());

        return true;
    }

    public boolean Delete(int id) {
        OrderItem save = FindById(id);
        
        if (save == null)
            return false;
        
        return Context.dbOrderItems.remove(save);
    }

    public OrderItem FindById(int id) {
        OrderItem order = null;

        for (OrderItem ord : Context.dbOrderItems) {
            if (ord.getId() == id) {
                order = ord;
            }
        }

        return order;
    }

    public List<OrderItem> FindAll() {
        return Context.dbOrderItems;
    }
}
