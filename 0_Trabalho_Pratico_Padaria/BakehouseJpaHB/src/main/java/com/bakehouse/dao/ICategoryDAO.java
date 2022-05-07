package com.bakehouse.dao;

import com.bakehouse.domain.Category;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface ICategoryDAO {
    
    public Result Insert(Category category);
    
    public Result Update(Category category);
    
    public List<Category> FindAll();
    
    public Category FindById(int id);
    
    public List<Category> FindByDescription(String description);
    
    public Result Delete(int id);
}