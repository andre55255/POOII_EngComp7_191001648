package com.bakehouse.dao_interfaces;

import com.bakehouse.domain.Category;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface ICategoryDAO {
    
    public Result insert(Category category);
    
    public Result update(Category category);
    
    public List<Category> findAll();
    
    public Category findById(int id);
    
    public List<Category> findByDescription(String description);
    
    public Result delete(int id);
}