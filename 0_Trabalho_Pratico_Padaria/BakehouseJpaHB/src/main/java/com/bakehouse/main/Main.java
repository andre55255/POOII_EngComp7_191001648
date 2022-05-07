package com.bakehouse.main;

import com.bakehouse.dao.CategoryImpl;
import com.bakehouse.domain.Category;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CategoryImpl catDao = new CategoryImpl();

        /*
        Category catSave = new Category();
        catSave.setDescription("Bebidas");
        catDao.Insert(catSave);
         */

 /*
        Category cat1 = catDao.FindById(41);
        System.out.println(cat1.getId()+"-"+cat1.getDescription());
         */
 /*
        List<Category> listCat = catDao.FindAll();
        for (Category cat : listCat) {
            System.out.println(cat.getId()+":"+cat.getDescription());
        }
         */
 /*
        Category catUpdate = new Category();
        catUpdate.setId(42);
        catUpdate.setDescription("Leite momo");
        
        catDao.Update(catUpdate);
         */
 /*
        catDao.Delete(14);
         */
 
        List<Category> listCat2 = catDao.FindByDescription("este");
        for (Category cat : listCat2) {
            System.out.println(cat.getId()+":"+cat.getDescription());
        }
    }
}
