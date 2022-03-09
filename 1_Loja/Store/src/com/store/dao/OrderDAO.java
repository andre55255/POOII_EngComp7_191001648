package com.store.dao;

import com.store.domain.Order;
import java.util.List;

public class OrderDAO {
    public static int idOrder;
    
    public boolean Insert(Order order) {
        if (Context.dbOrders.isEmpty())
            OrderDAO.idOrder = 1;
        
        order.setId(idOrder);
        OrderDAO.idOrder++;
        
        return Context.dbOrders.add(order);
    }
    
    public boolean Update(Order order) {
        if (!Context.dbOrders.contains(order))
            return false;
        
        Context.dbOrders.remove(order);
        Context.dbOrders.add(order);
        
        return true;
    }
    
    public boolean Delete(Order order) {
        return Context.dbOrders.remove(order);
    }
    
    public Order FindById(int id) {
        Order order = null;
        
        for (Order ord : Context.dbOrders) {
            if (ord.getId() == id)
                order = ord;
        }
        
        return order;
    }
    
    public List<Order> FindAll() {
        return Context.dbOrders;
    }
}