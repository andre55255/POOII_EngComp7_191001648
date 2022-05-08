package com.bakehouse.dao_interfaces;

import com.bakehouse.domain.OrderPad;
import com.bakehouse.domain.OrderPadItem;
import java.util.List;

public interface IOrderPadItem {
    
    public List<OrderPadItem> findByIdOrderPad(OrderPad orderPad);
}