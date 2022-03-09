package com.store.dao;

import com.store.domain.OrderItem;
import java.util.List;

public class OrderItemDAO {
     public static int idOrderItem;
    
    public boolean Insert(OrderItem order) {
        if (Context.dbOrderItems.isEmpty())
            OrderItemDAO.idOrderItem = 1;
        
        order.setId(idOrderItem);
        OrderItemDAO.idOrderItem++;
        
        return Context.dbOrderItems.add(order);
    }
    
    public boolean Update(OrderItem order) {
        if (!Context.dbOrderItems.contains(order))
            return false;
        
        Context.dbOrderItems.remove(order);
        Context.dbOrderItems.add(order);
        
        return true;
    }
    
    public boolean Delete(OrderItem order) {
        return Context.dbOrderItems.remove(order);
    }
    
    public OrderItem FindById(int id) {
        OrderItem order = null;
        
        for (OrderItem ord : Context.dbOrderItems) {
            if (ord.getId() == id)
                order = ord;
        }
        
        return order;
    }
    
    public List<OrderItem> FindAll() {
        return Context.dbOrderItems;
    }
}