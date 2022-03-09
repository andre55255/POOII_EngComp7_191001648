package com.store.dao;

import com.store.domain.Product;
import java.util.List;

public class ProductDAO {
    public static int idProduct;
    
    public boolean Insert(Product product) {
        if (Context.dbProducts.isEmpty())
            ProductDAO.idProduct = 1;
        
        product.setId(idProduct);
        ProductDAO.idProduct++;
        
        return Context.dbProducts.add(product);
    }
    
    public boolean Update(int id, Product product) {
        Product save = FindById(id);
        
        if (save == null)
            return false;
        
        save.setDescription(product.getDescription());
        save.setQuantity(product.getQuantity());
        save.setValueUnitary(product.getValueUnitary());
        save.setCategory(product.getCategory());
        
        return true;
    }
    
    public boolean Delete(int id) {
        Product prodSave = FindById(id);
        
        if (prodSave == null)
            return false;
        
        return Context.dbProducts.remove(prodSave);
    }
    
    public Product FindById(int id) {
        Product product = null;
        
        for (Product prod : Context.dbProducts) {
            if (prod.getId() == id)
                product = prod;
        }
        
        return product;
    }
    
    public List<Product> FindAll() {
        return Context.dbProducts;
    }
}