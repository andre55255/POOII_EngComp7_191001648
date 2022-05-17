package com.bakehouse.services.impl;

import com.bakehouse.dao.impl.OrderPadItemDAOImpl;
import com.bakehouse.dao.impl.ProductDAOImpl;
import com.bakehouse.dao.interfaces.IOrderPadItemDAO;
import com.bakehouse.dao.interfaces.IProductDAO;
import com.bakehouse.domain.OrderPadItem;
import com.bakehouse.domain.Product;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.interfaces.IProductService;
import com.bakehouse.viewobjects.product.ProductVO;
import java.util.List;

public class ProductService implements IProductService {

    private IProductDAO prodDao;
    private IOrderPadItemDAO orderItemDao;

    public ProductService() {
        prodDao = new ProductDAOImpl();
        orderItemDao = new OrderPadItemDAOImpl();
    }
    
    @Override
    public Result insert(ProductVO prodVO) {
        try {
            Result valid = prodVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            Product prodEntity = new Product();
            prodEntity.setId(0);
            prodEntity.setDescription(prodVO.getDescription());
            prodEntity.setBarCode(prodVO.getBarCode());
            prodEntity.setQuantity(prodVO.getQuantity());
            prodEntity.setMinQuantity(prodVO.getMinQuantity());
            prodEntity.setValueUnitary(prodVO.getValueUnitary());
            prodEntity.setCategory(prodVO.getCategory());
            prodEntity.setUnitOfMeasurement(prodVO.getUnitOfMeasurement());
            
            Result result = prodDao.insert(prodEntity);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao criar produto", false);
        }
    }

    @Override
    public Result update(ProductVO prodVO) {
        try {
            Result valid = prodVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            Product prodEntity = prodDao.findById(prodVO.getId());
            if (prodEntity == null)
                return new Result("Produto não encontrado para editar", false);
            
            prodEntity.setDescription(prodVO.getDescription());
            prodEntity.setBarCode(prodVO.getBarCode());
            prodEntity.setQuantity(prodVO.getQuantity());
            prodEntity.setMinQuantity(prodVO.getMinQuantity());
            prodEntity.setValueUnitary(prodVO.getValueUnitary());
            prodEntity.setCategory(prodVO.getCategory());
            prodEntity.setUnitOfMeasurement(prodVO.getUnitOfMeasurement());
            
            Result result = prodDao.update(prodEntity);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesprada ao editar produto", false);
        }
    }

    @Override
    public Result delete(int id) {
        try {
            if (id <= 0)
                return new Result("ID inválido", false);
            
            Product prodSave = prodDao.findById(id);
            if (prodSave == null)
                return new Result("Produto não encontrado para deleção", false);
            
            List<OrderPadItem> opi = orderItemDao.findByOrderPadItemProduct(prodSave);
            if (opi != null || opi.size() > 0)
                return new Result("Produto está vinculado a venda, não é possível excluir", false);
            
            Result result = prodDao.delete(id);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao deletar produto", false);
        }
    }
}