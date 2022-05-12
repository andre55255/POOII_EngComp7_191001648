package com.bakehouse.dao.impl;

import com.bakehouse.dao.interfaces.IRoleDAO;
import com.bakehouse.domain.Role;
import com.bakehouse.domain.User;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RoleDAOImpl implements IRoleDAO {

    @Override
    public Result insert(Role role) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
            
            return new Result("Perfil inserido com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao persistir perfil no banco", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result update(Role role) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(role);
            em.getTransaction().commit();
            
            return new Result("Perfil editado com sucesso no banco", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao editar perfil no banco", false);
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
            Role role = findById(id);
            if (role == null)
                return new Result("Perfil não encontrado", false);

            Query queryRelationals = em.createQuery("from User u where u.role = :role");
            List<User> users = queryRelationals.getResultList();
            if (users != null && users.size() > 0)
                return new Result("Perfil possui vinculos, não é possível excluir", false);
            
            em.getTransaction().begin();
            Query query = em.createQuery("Delete from Role r where r.id = :id");
            query.setParameter("id", id);
            int res = query.executeUpdate();
            em.getTransaction().commit();
            
            if (res > 0)
                return new Result("Perfil deletado com sucesso", true);
            else
                return new Result("Falha ao deletar perfil no banco", false);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar perfil no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Role findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Role role = em.find(Role.class, id);
            return role;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Role> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Role r order by r.description asc");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Role> findByDescription(String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("from Role rol where rol.description like :desc order by rol.description asc");
            query.setParameter("desc", "%"+description+"%");
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }
}