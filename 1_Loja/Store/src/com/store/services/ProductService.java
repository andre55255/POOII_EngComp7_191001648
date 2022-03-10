package com.store.services;

import com.store.dao.OrderItemDAO;
import com.store.domain.Category;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import java.util.List;

public abstract class ProductService {

    public static double calculateTax(Product product) {
        return product.getValueUnitary() * product.getCategory().getTax();
    }

    public static double totalTaxesProductsByCategory(Category category, boolean all) {
        double total = 0;

        List<OrderItem> items = new OrderItemDAO().FindAll();

        if (all) {
            for (OrderItem item : items) {
                total += calculateTax(item.getProduct()) * item.getQuantity();
            }
        } else {
            for (OrderItem item : items) {
                if (item.getProduct().getCategory() == category) {
                    total += calculateTax(item.getProduct()) * item.getQuantity();
                }
            }
        }

        return total;
    }

    public static int quantityProductsSoldByCategory(Category category) {
        int total = 0;

        List<OrderItem> items = new OrderItemDAO().FindAll();

        for (OrderItem item : items) {
            if (item.getProduct().getCategory().equals(category)) {
                total += item.getQuantity();
            }
        }

        return total;
    }

    public static int quantityProductsSold() {
        int total = 0;

        List<OrderItem> items = new OrderItemDAO().FindAll();

        for (OrderItem item : items) {
            total += item.getQuantity();
        }

        return total;
    }

    public static double valueProductInDollar(Product product) {
        return product.getValueUnitary() / 5.02;
    }
}
