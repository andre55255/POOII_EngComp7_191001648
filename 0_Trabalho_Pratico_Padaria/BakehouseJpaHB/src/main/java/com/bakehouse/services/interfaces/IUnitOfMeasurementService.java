package com.bakehouse.services.interfaces;

import com.bakehouse.helpers.Result;
import com.bakehouse.viewobjects.unit_of_measurement.UnitOfMeasurementVO;

public interface IUnitOfMeasurementService {
    
    public Result create(UnitOfMeasurementVO unitOfMeasVO);
    
    public Result edit(UnitOfMeasurementVO unitOfMeasVO);
    
    public Result delete(int id);
}