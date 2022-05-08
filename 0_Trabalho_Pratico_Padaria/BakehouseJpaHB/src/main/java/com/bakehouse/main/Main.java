package com.bakehouse.main;

import com.bakehouse.dao_interfaces.IProductDAO;
import com.bakehouse.dao_impl.ProductImpl;
import com.bakehouse.domain.Product;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IProductDAO pDao = new ProductImpl();
        List<Product> list = pDao.findAll();
        
        System.out.println("");
    }
}