package com.bakehouse.services.impl;

import com.bakehouse.dao.impl.CategoryDAOImpl;
import com.bakehouse.dao.impl.ProductDAOImpl;
import com.bakehouse.dao.interfaces.ICategoryDAO;
import com.bakehouse.dao.interfaces.IProductDAO;
import com.bakehouse.domain.Category;
import com.bakehouse.domain.Product;
import com.bakehouse.helpers.Result;
import com.bakehouse.services.interfaces.ICategoryService;
import com.bakehouse.viewobjects.category.CategoryVO;
import java.util.List;

public class CategoryService implements ICategoryService {

    private ICategoryDAO catDao;
    private IProductDAO prodDao;
    
    public CategoryService() {
        catDao = new CategoryDAOImpl();
        prodDao = new ProductDAOImpl();
    }
    
    @Override
    public Result create(CategoryVO catVO) {
        try {
            Result valid = catVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            Category catEntity = new Category();
            catEntity.setId(0);
            catEntity.setDescription(catVO.getDescription());
            
            Result result = catDao.insert(catEntity);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao criar categoria", false);
        }
    }

    @Override
    public Result edit(CategoryVO catVO) {
        try {
            Result valid = catVO.valid();
            if (!valid.isSuccess())
                return valid;
            
            Category catEdit = catDao.findById(catVO.getId());
            if (catEdit == null)
                return new Result("Categoria não encontrado para editar", false);
            
            catEdit.setDescription(catVO.getDescription());

            Result result = catDao.update(catEdit);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao editar categoria", false);
        }
    }

    @Override
    public Result delete(int id) {
        try {
            if (id <= 0)
                return new Result("ID inválido", false);
            
            Category cat = catDao.findById(id);
            if (cat == null)
                return new Result("Categoria não encontrada", false);
            
            List<Product> prodsToCategory = prodDao.findByCategory(cat);
            if (prodsToCategory != null && prodsToCategory.size() > 0)
                return new Result("Categoria está vinculada a algum produto, não é possível deletá-la", false);
            
            Result result = catDao.delete(id);
            return result;
        } catch (Exception ex) {
            return new Result("Falha inesperada ao deletar categoria", false);
        }
    }
}