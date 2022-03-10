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
    
    public boolean Update(int id, Order order) {
        Order save = FindById(id);
        
        if (save == null)
            return false;
        
        save.setDateHour(order.getDateHour());
        save.setOrderItem(order.getOrderItem());
        
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