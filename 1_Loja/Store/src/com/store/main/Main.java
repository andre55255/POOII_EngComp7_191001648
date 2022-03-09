package com.store.main;

import com.store.dao.CategoryDAO;
import com.store.domain.Category;
import com.store.gui.Initial;

public class Main {
    public static void main(String[] args) {
        Category c1 = new Category(1, "Bebidas", 0.25);
        Category c2 = new Category(2, "Alimentação", 0.05);
        Category c3 = new Category(3, "Vestuários", 0.1);
        Category c4 = new Category(4, "Higiene", 0.05);
        Category c5 = new Category(5, "Eletrônicos", 0.3);
        CategoryDAO dbCat = new CategoryDAO();
        dbCat.Insert(c1);
        dbCat.Insert(c2);
        dbCat.Insert(c3);
        dbCat.Insert(c4);
        dbCat.Insert(c5);
        
        new Initial().setVisible(true);
    }
}