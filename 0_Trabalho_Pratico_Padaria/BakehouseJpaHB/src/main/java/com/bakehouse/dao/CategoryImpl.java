package com.bakehouse.dao;

import com.bakehouse.domain.Category;
import com.bakehouse.helpers.ConstantsStatic;
import com.bakehouse.helpers.Result;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CategoryImpl implements ICategoryDAO {

    @Override
    public Result Insert(Category category) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();

            return new Result("Categoria inserida com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar categoria", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result Update(Category category) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(category);
            em.getTransaction().commit();

            return new Result("Categoria editada com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Erro ao editar categoria no banco de dados", false);
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Category> FindAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from Category");
            List<Category> categories = query.getResultList();

            return categories;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Category FindById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            Category save = em.find(Category.class, id);

            return save;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public List<Category> FindByDescription(String description) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from Category cat where cat.description like :desc");
            query.setParameter("desc", "%"+description+"%");
            List<Category> listSave = query.getResultList();

            return listSave;
        } catch (Exception ex) {
            return null;
        } finally {
            emf.close();
            em.close();
        }
    }

    @Override
    public Result Delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ConstantsStatic.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        
        try {
            Category save = em.find(Category.class, id);
            if (save == null)
                return new Result("Categoria não encontrada para deletar", false);
            
            em.getTransaction().begin();
            em.remove(save);
            em.getTransaction().commit();
            
            return new Result("Categoria deletada com sucesso", true);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return new Result("Falha ao deletar categoria", false);
        } finally {
            emf.close();
            em.close();
        }
    }
}
