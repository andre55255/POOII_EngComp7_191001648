package com.bakehouse.dao_interfaces;

import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.Result;
import java.util.List;

public interface IUnitOfMeasurementDAO {
    public Result insert(UnitOfMeasurement category);
    
    public Result update(UnitOfMeasurement category);
    
    public List<UnitOfMeasurement> findAll();
    
    public UnitOfMeasurement findById(int id);
    
    public List<UnitOfMeasurement> findByDescription(String description);
    
    public Result delete(int id);
}