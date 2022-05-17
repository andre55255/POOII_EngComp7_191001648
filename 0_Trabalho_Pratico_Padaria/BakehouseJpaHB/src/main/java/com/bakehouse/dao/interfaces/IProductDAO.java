package com.bakehouse.dao.interfaces;

import com.bakehouse.domain.Category;
import com.bakehouse.domain.Product;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface IProductDAO {
    
    public Result insert(Product product);
    
    public Result update(Product product);
    
    public List<Product> findAll(boolean ascendent);
    
    public Product findById(int id);
    
    public List<Product> findByDescription(String description);
    
    public List<Product> findByCategory(Category category);
    
    public List<Product> findByUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement);
    
    public Result delete(int id);
    
    public List<Product> findAllByValueUnitary(boolean ascendent);
    
    public List<Product> findAllByCategory(boolean ascendent);
    
    public List<Product> findAllByUnitOfMeasurement(boolean ascendent);
}