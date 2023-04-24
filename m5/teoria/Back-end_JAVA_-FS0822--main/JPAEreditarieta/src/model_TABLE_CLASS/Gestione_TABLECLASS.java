package model_TABLE_CLASS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Gestione_TABLECLASS {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEreditarieta");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Automobile3 auto = new Automobile3();
		auto.setMarca("Fiat");
		auto.setModello("500");
		auto.setNporte(3);
		auto.setAlimentazione("Benzina");
		
		//saveAuto(auto);
		
		Moto3 moto = new Moto3();
		moto.setMarca("Honda");
		moto.setModello("Hornet");
		moto.setNposti(2);
		
		//saveMoto(moto);
		
		//List<Veicolo3> listaVeicoli = findVeicoloByMarca("Fiat");
		List<Veicolo3> listaVeicoli = findAllVeicoli();
		listaVeicoli.forEach(v -> System.out.println(v.getModello()));
		
	}
	
	public static void saveAuto(Automobile3 a) {
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
	
	public static void saveMoto(Moto3 m) {
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
	
	public static List<Veicolo3> findAllVeicoli() {
		Query q = em.createNamedQuery("Veicoli3.FindAll");
		return q.getResultList();
	}
	
	public static List<Veicolo3> findVeicoloByMarca(String marca) {
		Query q = em.createQuery("SELECT v FROM Veicolo3 v WHERE v.marca = :vm");
		q.setParameter("vm", marca);
		return q.getResultList();
	}
	
}
