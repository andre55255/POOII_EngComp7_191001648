package com.store.services;

import com.store.dao.OrderDAO;
import com.store.domain.Order;
import com.store.domain.OrderItem;
import java.util.List;

public class OrderService {

    public double totalValueOrders() {
        double total = 0;

        List<Order> items = new OrderDAO().FindAll();

        for (Order order : items) {
            total += getValueTotalOrder(order);
        }

        return total;
    }

    public double totalValueOrder(int idOrder) {
        double total = 0;

        Order order = new OrderDAO().FindById(idOrder);

        total += getValueTotalOrder(order);

        return total;
    }

    private double getValueTotalOrder(Order order) {
        double total = 0;

        for (OrderItem item : order.getOrderItem()) {
            total += item.getValueUnitary() * item.getQuantity();
        }

        return total;
    }
}
