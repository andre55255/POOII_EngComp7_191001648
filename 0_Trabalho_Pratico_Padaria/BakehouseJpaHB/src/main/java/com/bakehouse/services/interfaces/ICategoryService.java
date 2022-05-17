package com.bakehouse.services.interfaces;

import com.bakehouse.helpers.Result;
import com.bakehouse.viewobjects.category.CategoryVO;

public interface ICategoryService {
    
    public Result create(CategoryVO catVO);
    
    public Result edit(CategoryVO catVO);
    
    public Result delete(int id);
}