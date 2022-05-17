package com.bakehouse.services.impl;

import com.bakehouse.dao.impl.ProductDAOImpl;
import com.bakehouse.dao.impl.UnitOfMeasurementDAOImpl;
import com.bakehouse.dao.interfaces.IProductDAO;
import com.bakehouse.dao.interfaces.IUnitOfMeasurementDAO;
import com.bakehouse.domain.Product;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.interfaces.IUnitOfMeasurementService;
import com.bakehouse.viewobjects.unit_of_measurement.UnitOfMeasurementVO;
import java.util.List;

public class UnitOfMeasurementService implements IUnitOfMeasurementService {

    private IUnitOfMeasurementDAO unitOfMeasDao;
    private IProductDAO prodDao;

    public UnitOfMeasurementService() {
        unitOfMeasDao =  new UnitOfMeasurementDAOImpl();
        prodDao = new ProductDAOImpl();
    }
    
    @Override
    public Result create(UnitOfMeasurementVO unitOfMeasVO) {
        try {
            Result valid = unitOfMeasVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            UnitOfMeasurement unitOfMeasEntity = new UnitOfMeasurement();
            unitOfMeasEntity.setId(0);
            unitOfMeasEntity.setDescription(unitOfMeasVO.getDescription());
            
            Result result = unitOfMeasDao.insert(unitOfMeasEntity);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao criar unidade de medida", false);
        }
    }

    @Override
    public Result edit(UnitOfMeasurementVO unitOfMeasVO) {
        try {
            Result valid = unitOfMeasVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            UnitOfMeasurement unitOfMeasEdit = unitOfMeasDao.findById(unitOfMeasVO.getId());
            if (unitOfMeasEdit == null)
                return new Result("Unidade de medida não encontrado para editar", false);
            
            unitOfMeasEdit.setDescription(unitOfMeasVO.getDescription());

            Result result = unitOfMeasDao.update(unitOfMeasEdit);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao editar unidade de medida", false);
        }
    }

    @Override
    public Result delete(int id) {
        try {
            if (id <= 0)
                return new Result("ID inválido", false);
            
            UnitOfMeasurement unitOfMeas = unitOfMeasDao.findById(id);
            if (unitOfMeas == null)
                return new Result("Unidade de medida não encontrada", false);
            
            List<Product> prodsToUnits = prodDao.findByUnitOfMeasurement(unitOfMeas);
            if (prodsToUnits != null && prodsToUnits.size() > 0)
                return new Result("Unidade de medida está vinculada a algum produto, não é possível deletá-la", false);
            
            Result result = prodDao.delete(id);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao deletar unidade de medida", false);
        }
    }
}