package com.store.main;

import com.store.dao.CategoryDAO;
import com.store.dao.OrderDAO;
import com.store.dao.OrderItemDAO;
import com.store.dao.ProductDAO;
import com.store.domain.Category;
import com.store.domain.Order;
import com.store.domain.OrderItem;
import com.store.domain.Product;
import com.store.gui.Initial;
import com.store.services.OrderService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Novas categorias
        Category c1 = new Category(1, "Bebidas", 0.25);
        Category c2 = new Category(2, "Alimentação", 0.05);
        Category c3 = new Category(3, "Vestuários", 0.1);
        Category c4 = new Category(4, "Higiene", 0.05);
        Category c5 = new Category(5, "Eletrônicos", 0.3);
        CategoryDAO dbCat = new CategoryDAO();
        dbCat.Insert(c1);
        dbCat.Insert(c2);
        dbCat.Insert(c3);
        dbCat.Insert(c4);
        dbCat.Insert(c5);
        
        // Novos Produtos
        Product p1 = new Product("Coca cola", 50, 9.0, c1);
        Product p2 = new Product("Biscoito piraquê", 100, 4.99, c2);
        Product p3 = new Product("Camisa Polo", 40, 50.99, c3);
        Product p4 = new Product("Escova colgate", 54, 7.89, c4);
        Product p5 = new Product("PS5", 10, 7999.99, c5);
        ProductDAO dbProd = new ProductDAO();
        dbProd.Insert(p1);
        dbProd.Insert(p2);
        dbProd.Insert(p3);
        dbProd.Insert(p4);
        dbProd.Insert(p5);
        
        // Novos itens de venda
        OrderItem oi1 = new OrderItem(p1, 2, p1.getValueUnitary());
        OrderItem oi2 = new OrderItem(p1, 3, p1.getValueUnitary());
        OrderItem oi3 = new OrderItem(p5, 1, p5.getValueUnitary());
        OrderItem oi4 = new OrderItem(p2, 5, p2.getValueUnitary());
        OrderItemDAO dbOrderItem = new OrderItemDAO();
        dbOrderItem.Insert(oi1);
        dbOrderItem.Insert(oi2);
        dbOrderItem.Insert(oi3);
        dbOrderItem.Insert(oi4);
        
        // Novas vendas
        Order o1 = new Order(LocalDate.now());
        o1.addOrderItem(oi1);
        o1.addOrderItem(oi4);
        
        Order o2 = new Order(LocalDate.now());
        o2.addOrderItem(oi2);

        Order o3 = new Order(LocalDate.now());
        o3.addOrderItem(oi3);
        
        OrderDAO dbOrder = new OrderDAO();
        dbOrder.Insert(o1);
        dbOrder.Insert(o2);
        dbOrder.Insert(o3);
        
        // Fechar vendas
        OrderService.closeOrder(o1);
        OrderService.closeOrder(o2);
        OrderService.closeOrder(o3);
        
        new Initial().setVisible(true);
    }
}