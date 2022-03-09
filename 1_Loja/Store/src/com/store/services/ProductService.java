package com.store.services;

import com.store.dao.OrderItemDAO;
import com.store.domain.Category;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import java.util.List;

public class ProductService {
    private final double DOLLAR_QUOTE = 5.13;
    
    public double calculateTax(Product product) {
        return product.getValueUnitary() * product.getCategory().getTax();
    }

    public int quantityProductsSoldByCategory(Category category) {
        int total = 0;

        List<OrderItem> items = new OrderItemDAO().FindAll();

        for (OrderItem item : items) {
            if (item.getProduct().getCategory().equals(category)) {
                total += item.getQuantity();
            }
        }

        return total;
    }

    public int quantityProductsSold() {
        int total = 0;

        List<OrderItem> items = new OrderItemDAO().FindAll();

        for (OrderItem item : items) {
            total += item.getQuantity();
        }

        return total;
    }

    public double valueProductInDollar(Product product) {
        return product.getValueUnitary() * DOLLAR_QUOTE;
    }
}