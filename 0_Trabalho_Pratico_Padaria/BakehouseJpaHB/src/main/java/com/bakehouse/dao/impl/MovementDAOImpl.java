package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IMovementDAO;
import com.bakehouse.domain.Movement;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MovementDAOImpl implements IMovementDAO {

    @Override
    public Result insert(Movement movement) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movement);
            em.getTransaction().commit();
            
            return new Result("Movimento inserido com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao persistir movimento no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(Movement movement) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(movement);
            em.getTransaction().commit();
            
            return new Result("Movimento editado com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar movimento no banco", false);
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
            Movement save = findById(id);
            if (save == null)
                return new Result("Movimento não encontrado no banco", false);
            
            em.getTransaction().begin();
            em.remove(save);
            em.getTransaction().commit();
            
            return new Result("Movimento editado com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar movimento no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m order by m.dateReference desc");
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Movement findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Movement movement = em.find(Movement.class, id);
            return movement;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findByDate(LocalDateTime dateInitial, LocalDateTime dateFinal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m where m.dateReference > :dateInitial "
                    + "and m.dateReference < :dateFinal order by m.dateReference desc");
            query.setParameter("dateInitial", dateInitial);
            query.setParameter("dateFinal", dateFinal);
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findByUser(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m where m.user = :user order by m.dateReference desc");
            query.setParameter("user", user);
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findByType(String type) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m where m.type = :type order by m.dateReference desc");
            query.setParameter("type", type);
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findbyValue(double valueInitial, double finalValue) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m where m.totalValue > :valueInitial "
                    + "and m.totalValue < :finalValue order by m.dateReference desc");
            query.setParameter("valueInitial", valueInitial);
            query.setParameter("finalValue", finalValue);
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Movement> findByDescription(String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Movement m where m.description = :description order by m.dateReference desc");
            query.setParameter("description", description);
            List<Movement> movements = query.getResultList();
            return movements;
        } catch (Exception ex ) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }
}