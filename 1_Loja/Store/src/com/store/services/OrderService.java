package com.store.services;

import com.store.dao.OrderDAO;
import com.store.dao.OrderItemDAO;
import com.store.dao.ProductDAO;
import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import java.util.List;

public abstract class OrderService {

    public static double totalValueOrders() {
        double total = 0;

        List<Order> items = new OrderDAO().FindAll();

        for (Order order : items) {
            total += getValueTotalOrder(order, null);
        }

        return total;
    }

    public static double totalValueOrdersByCategory(Category category) {
        double total = 0;

        List<Order> orders = new OrderDAO().FindAll();

        for (Order order : orders) {
            for (OrderItem item : order.getOrderItem()) {
                if (item.getProduct().getCategory() == category) {
                    total += getValueTotalOrder(order, category);
                    break;
                }
            }
        }

        return total;
    }

    public static double totalValueOrder(int idOrder) {
        double total = 0;

        Order order = new OrderDAO().FindById(idOrder);

        total += getValueTotalOrder(order, null);

        return total;
    }

    public static boolean closeOrder(Order order) {
        OrderDAO dbOrder = new OrderDAO();
        Order save = dbOrder.FindById(order.getId());
        
        if (save == null)
            return false;
        
        for (OrderItem item : save.getOrderItem()) {
            ProductDAO dbProd = new ProductDAO();
            
            Product p = dbProd.FindById(item.getProduct().getId());
            p.setQuantity(p.getQuantity() - item.getQuantity());
        }
        
        save.setStatus(true);
        return dbOrder.Update(order.getId(), save);
    }
    
    private static double getValueTotalOrder(Order order, Category category) {
        double total = 0;

        if (category == null) {
            for (OrderItem item : order.getOrderItem()) {
                total += (item.getValueUnitary() * item.getQuantity());
            }
        } else {
            for (OrderItem item : order.getOrderItem()) {
                if (item.getProduct().getCategory() == category) {
                    total += (item.getValueUnitary() * item.getQuantity());
                }
            }
        }

        return total;
    }
}
