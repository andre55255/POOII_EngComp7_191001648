package com.store.dao;

import com.store.domain.Category;
import com.store.domain.Product;
import java.util.List;

public class CategoryDAO {

    public static int idCategory;

    public boolean Insert(Category category) {
        if (Context.dbCategories.isEmpty()) {
            CategoryDAO.idCategory = 1;
        }

        category.setId(idCategory);
        CategoryDAO.idCategory++;

        return Context.dbCategories.add(category);
    }

    public boolean Update(int id, Category category) {
        Category save = FindById(id);

        if (save == null) {
            return false;
        }

        save.setDescription(category.getDescription());
        save.setTax(category.getTax());

        return true;
    }

    public boolean Delete(int id) throws IllegalAccessException {
        Category catSave = FindById(id);
        if (catSave == null) {
            return false;
        }

        List<Product> products = new ProductDAO().FindAll();
        for (Product prod : products) {
            if (prod.getCategory() == catSave) {
                throw new IllegalAccessException(String.format("Categoria está vinculada com o produto %s, id %d, não é possível excluir", 
                        prod.getDescription(), prod.getId()));
            }
        }

        return Context.dbCategories.remove(catSave);
    }

    public Category FindById(int id) {
        Category category = null;

        for (Category cat : Context.dbCategories) {
            if (cat.getId() == id) {
                category = cat;
            }
        }

        return category;
    }

    public List<Category> FindAll() {
        return Context.dbCategories;
    }
}
