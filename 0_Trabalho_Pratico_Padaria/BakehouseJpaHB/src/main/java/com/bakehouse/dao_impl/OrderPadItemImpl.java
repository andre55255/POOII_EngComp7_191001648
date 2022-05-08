package com.bakehouse.dao_impl;

import com.bakehouse.dao_interfaces.IOrderPadItem;
import com.bakehouse.domain.OrderPad;
import com.bakehouse.domain.OrderPadItem;
import com.bakehouse.helpers.ConstantsStatic;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OrderPadItemImpl implements IOrderPadItem {

    @Override
    public List<OrderPadItem> findByIdOrderPad(OrderPad orderPad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from OrderPadItem opi.orderPad where :orderPad");
            query.setParameter("orderPad", orderPad);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }
}