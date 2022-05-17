package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IUnitOfMeasurementDAO;
import com.bakehouse.domain.UnitOfMeasurement;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UnitOfMeasurementDAOImpl implements IUnitOfMeasurementDAO {
    @Override
    public Result insert(UnitOfMeasurement unitOfMeasurement) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(unitOfMeasurement);
            em.getTransaction().commit();

            return new Result("Unidade de medida inserida com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar unidade de medida", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(UnitOfMeasurement unitOfMeasurement) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(unitOfMeasurement);
            em.getTransaction().commit();

            return new Result("Unidade de medida editada com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Erro ao editar unidade de medida no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<UnitOfMeasurement> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from UnitOfMeasurement u order by u.description asc");
            List<UnitOfMeasurement> categories = query.getResultList();

            return categories;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public UnitOfMeasurement findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            UnitOfMeasurement save = em.find(UnitOfMeasurement.class, id);

            return save;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<UnitOfMeasurement> findByDescription(String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from UnitOfMeasurement cat where cat.description like :desc order by cat.description asc");
            query.setParameter("desc", "%"+description+"%");
            List<UnitOfMeasurement> listSave = query.getResultList();

            return listSave;
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
            em.getTransaction().begin();
            Query query = em.createQuery("delete from UnitOfMeasurement u where u.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
            
            return new Result("Unidade de medida deletada com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar unidade de medida", false);
        } finally {
            emf.close();
            em.close();
        }
    }
}