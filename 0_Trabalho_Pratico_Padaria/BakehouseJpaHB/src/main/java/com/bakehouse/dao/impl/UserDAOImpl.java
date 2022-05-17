package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IRoleDAO;
import com.bakehouse.dao.interfaces.IUserDAO;
import com.bakehouse.domain.Role;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAOImpl implements IUserDAO {

    @Override
    public Result insert(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            
            return new Result("Usuário inserido com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao pesistir usuário no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            
            return new Result("Usuário editado com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar usuário no banco", false);
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
            Query query = em.createQuery("delete from User us where us.id = :id");
            query.setParameter("id", id);
            int res = query.executeUpdate();
            em.getTransaction().commit();
            
            if (res > 0)
                return new Result("Usuário deletado com sucesso", true);
            else
                return new Result("Falha ao deletar usuário no banco", false);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar usuário no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public User findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            User user = em.find(User.class, id);
            return user;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<User> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from User");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<User> findByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from User us where us.name like :name");
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<User> findByRole(String roleStr) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            IRoleDAO roleDao = new RoleDAOImpl();
            List<Role> roles = roleDao.findByDescription(roleStr);
            List<User> users = new ArrayList<>();
            for (Role role : roles) {
                Query query = em.createQuery("from User us where us.role = :role");
                query.setParameter("role", role);
                users.addAll(query.getResultList());
            }
            return users;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public User findByLogin(String login) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from User us where us.login = :login");
            query.setParameter("login", login);
            return (User) query.getResultList().get(0);
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public int countUsersByRole(Role role) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from User us where us.role = :role");
            query.setParameter("role", role);
            List<User> users = query.getResultList();
            if (users != null)
                return users.size();
            return 0;
        } catch (Exception ex) {
            return -1;
        } finally {
            emf.close();
            em.close();
        }
    }
}