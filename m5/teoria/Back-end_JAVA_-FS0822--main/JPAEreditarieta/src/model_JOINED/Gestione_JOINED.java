package model_JOINED;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Gestione_JOINED {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEreditarieta");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Automobile2 auto = new Automobile2();
		auto.setMarca("Fiat");
		auto.setModello("500");
		auto.setNporte(3);
		auto.setAlimentazione("Benzina");
		
		//saveAuto(auto);
		
		Moto2 moto = new Moto2();
		moto.setMarca("Honda");
		moto.setModello("Hornet");
		moto.setNposti(2);
		
		//saveMoto(moto);
		
		//List<Veicolo2> listaVeicoli = findVeicoloByMarca("Fiat");
		List<Veicolo2> listaVeicoli = findAllVeicoli();
		listaVeicoli.forEach(v -> System.out.println(v.getModello()));
		
	}
	
	public static void saveAuto(Automobile2 a) {
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void saveMoto(Moto2 m) {
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Veicolo2> findAllVeicoli() {
		Query q = em.createNamedQuery("Veicoli2.FindAll");
		return q.getResultList();
	}
	
	public static List<Veicolo2> findVeicoloByMarca(String marca) {
		Query q = em.createQuery("SELECT v FROM Veicolo2 v WHERE v.marca = :vm");
		q.setParameter("vm", marca);
		return q.getResultList();
	}
	
}
