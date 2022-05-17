package com.bakehouse.services.interfaces;

import com.bakehouse.helpers.Result;
import com.bakehouse.viewobjects.product.ProductVO;

public interface IProductService {
    
    public Result insert(ProductVO prodVO);
    
    public Result update(ProductVO prodVO);
    
    public Result delete(int id);
}