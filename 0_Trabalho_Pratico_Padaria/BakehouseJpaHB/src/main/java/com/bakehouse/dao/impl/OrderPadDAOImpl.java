package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IOrderPadDAO;
import com.bakehouse.domain.OrderPad;
import com.bakehouse.domain.OrderPadItem;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OrderPadDAOImpl implements IOrderPadDAO {

    @Override
    public Result insert(OrderPad orderPad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(orderPad);
            em.getTransaction().commit();
            
            return new Result("Comanda inserida no banco com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao persistir comanda no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(OrderPad orderPad) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(orderPad);
            em.getTransaction().commit();
            
            return new Result("Comanda editada no banco com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar comanda no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            OrderPad orderPad = findById(id);
            if (orderPad == null)
                return new Result("Comanda nao encontrada", false);
            
            em.getTransaction().begin();
            em.remove(orderPad);
            em.getTransaction().commit();
            
            return new Result("Comanda deletada no banco com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar comanda no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public OrderPad findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            OrderPad save = em.find(OrderPad.class, id);
            if (save != null) {
                Query queryItems = em.createQuery("from OrderPadItem opi.orderPad where :orderPad");
                queryItems.setParameter("orderPad", save);
                List<OrderPadItem> items = queryItems.getResultList();
                save.setItems(items);
            }
            return save;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<OrderPad> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from OrderPad op order by op.dateReference desc");
            List<OrderPad> listSaves = query.getResultList();
            for (OrderPad orderPad : listSaves) {
                if (orderPad.getItems().size() <= 0) {
                    Query queryItems = em.createQuery("from OrderPadItem opi.orderPad where :orderPad");
                    queryItems.setParameter("orderPad", orderPad);
                    List<OrderPadItem> items = queryItems.getResultList();
                    orderPad.setItems(items);
                }
            }
            return listSaves;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<OrderPad> findByDate(LocalDateTime dateInitial, LocalDateTime dateFinal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from OrderPad op where op.dateReference > :dateInitial "
                    + "and op.dateReference < :dateFinal order by op.dateReference desc");
            query.setParameter("dateInitial", dateInitial);
            query.setParameter("dateFinal", dateFinal);

            List<OrderPad> listSaves = query.getResultList();
            for (OrderPad orderPad : listSaves) {
                if (orderPad.getItems().size() <= 0) {
                    Query queryItems = em.createQuery("from OrderPadItem opi.orderPad where :orderPad");
                    queryItems.setParameter("orderPad", orderPad);
                    List<OrderPadItem> items = queryItems.getResultList();
                    orderPad.setItems(items);
                }
            }
            return listSaves;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }
}