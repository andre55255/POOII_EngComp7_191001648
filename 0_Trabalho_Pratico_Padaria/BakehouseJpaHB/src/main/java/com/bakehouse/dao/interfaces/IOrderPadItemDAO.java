package com.bakehouse.dao.interfaces;

import com.bakehouse.domain.OrderPad;
import com.bakehouse.domain.OrderPadItem;
import com.bakehouse.domain.Product;
import java.util.List;

public interface IOrderPadItemDAO {
    
    public List<OrderPadItem> findByIdOrderPad(OrderPad orderPad);
    
    public List<OrderPadItem> findByOrderPadItemProduct(Product prod);
}