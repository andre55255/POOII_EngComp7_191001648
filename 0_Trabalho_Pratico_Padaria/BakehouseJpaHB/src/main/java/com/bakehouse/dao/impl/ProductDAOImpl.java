package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IProductDAO;
import com.bakehouse.domain.Category;
import com.bakehouse.domain.Product;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public Result insert(Product product) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            em.persist(product);
            
            em.getTransaction().commit();
            
            return new Result("Produto inserido com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao inserir produto no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(Product product) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            em.merge(product);
            
            em.getTransaction().commit();
            
            return new Result("Produto editado com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar produto no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Product> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Product p order by p.description asc");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Product findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Product save = em.find(Product.class, id);
            return save;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Product> findByDescription(String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Product prod where prod.description like :desc order by prod.description asc");
            query.setParameter("desc", "%"+description+"%");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Product> findByCategory(Category category) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Product prod where prod.category = :cat order by prod.description asc");
            query.setParameter("cat", category);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Product> findByUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Product prod where prod.unitOfMeasurement = :unitOfMeas "
                    + "order by prod.description asc");
            query.setParameter("unitOfMeas", unitOfMeasurement);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
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
            Product save = findById(id);
            if (save == null)
                return new Result("Produto a ser deletado não encontrado", false);
            
            em.getTransaction().begin();
            em.remove(save);
            em.getTransaction().commit();
            
            return new Result("Produto deletado com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar produto, id: "+id, false);
        } finally {
            emf.close();
            em.close();
        }
    }
}