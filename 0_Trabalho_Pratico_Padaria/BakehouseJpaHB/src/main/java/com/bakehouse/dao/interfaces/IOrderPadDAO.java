package com.bakehouse.dao.interfaces;

import com.bakehouse.domain.OrderPad;
import com.bakehouse.helpers.Result;
import java.time.LocalDateTime;
import java.util.List;

public interface IOrderPadDAO {
    
    public Result insert(OrderPad orderPad);
    
    public Result update(OrderPad orderPad);
    
    public Result delete(int id);
    
    public OrderPad findById(int id);
    
    public List<OrderPad> findAll();
    
    public List<OrderPad> findByDate(LocalDateTime dateInitial, LocalDateTime dateFinal);
}