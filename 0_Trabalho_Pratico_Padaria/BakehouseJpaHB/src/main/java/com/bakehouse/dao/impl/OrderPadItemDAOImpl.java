package com.bakehouse.dao.impl;

import com.bakehouse.domain.OrderPad;
import com.bakehouse.domain.OrderPadItem;
import com.bakehouse.domain.Product;
import com.bakehouse.helpers.ConstantsStatic;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.bakehouse.dao.interfaces.IOrderPadItemDAO;

public class OrderPadItemDAOImpl implements IOrderPadItemDAO {

    @Override
    public List<OrderPadItem> findByIdOrderPad(OrderPad orderPad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from OrderPadItem opi where opi.orderPad = :orderPad");
            query.setParameter("orderPad", orderPad);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<OrderPadItem> findByOrderPadItemProduct(Product prod) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from OrderPadItem opi where opi.product = :prod");
            query.setParameter("prod", prod);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }
}