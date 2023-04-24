package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Evento;
import util.JpaUtil;

public class EventoDAO implements IEventoDAO {

	@Override
	public void save(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Evento ev = em.find(Evento.class, id);
			em.getTransaction().commit();
			return ev;
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public List<Evento> getAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q = em.createNamedQuery("Evento.findAll");
		return q.getResultList();
	}

}
