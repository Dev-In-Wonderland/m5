package model_MappedSuperClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Gestione_MappedSuperClass {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEreditarieta");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Automobile4 auto = new Automobile4();
		auto.setMarca("Fiat");
		auto.setModello("500");
		auto.setNporte(3);
		auto.setAlimentazione("Benzina");
		
		//saveAuto(auto);
		
		Moto4 moto = new Moto4();
		moto.setMarca("Honda");
		moto.setModello("Hornet");
		moto.setNposti(2);
		
		//saveMoto(moto);
		
		//List<Veicolo4> listaVeicoli = findVeicoloByMarca("Fiat");
		//List<Veicolo4> listaVeicoli = findAllVeicoli();
		//listaVeicoli.forEach(v -> System.out.println(v.getModello()));
		
	}
	
	public static void saveAuto(Automobile4 a) {
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
	
	public static void saveMoto(Moto4 m) {
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
	
	public static List<Veicolo4> findAllVeicoli() {
		Query q = em.createNamedQuery("Veicoli4.FindAll");
		return q.getResultList();
	}
	
	public static List<Veicolo4> findVeicoloByMarca(String marca) {
		Query q = em.createQuery("SELECT v FROM Veicolo4 v WHERE v.marca = :vm");
		q.setParameter("vm", marca);
		return q.getResultList();
	}
	
}
