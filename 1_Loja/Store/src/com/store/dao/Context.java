package com.store.dao;

import com.store.domain.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Context {
    public static List<Product> dbProducts = new ArrayList<>();
    public static List<Category> dbCategories = new ArrayList<>();
    public static List<Order> dbOrders = new ArrayList<>();
    public static List<OrderItem> dbOrderItems = new ArrayList<>();
}