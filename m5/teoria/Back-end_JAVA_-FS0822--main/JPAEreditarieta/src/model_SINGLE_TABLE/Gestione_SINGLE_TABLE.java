package model_SINGLE_TABLE;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Gestione_SINGLE_TABLE {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEreditarieta");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		Automobile1 auto = new Automobile1();
		auto.setMarca("Fiat");
		auto.setModello("500");
		auto.setNporte(3);
		auto.setAlimentazione("Benzina");
		
		//saveAuto(auto);
		
		Moto1 moto = new Moto1();
		moto.setMarca("Honda");
		moto.setModello("Hornet");
		moto.setNposti(2);
		
		//saveMoto(moto);
		
		List<Veicolo1> listaVeicoli = findVeicoloByMarca("Fiat");
		listaVeicoli.forEach(v -> System.out.println(v.getModello()));
		
	}
	
	public static void saveAuto(Automobile1 a) {
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
	
	public static void saveMoto(Moto1 m) {
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
	
	public static List<Veicolo1> findAllVeicoli() {
		Query q = em.createNamedQuery("Veicoli.FindAll");
		return q.getResultList();
	}
	
	public static List<Veicolo1> findVeicoloByMarca(String marca) {
		Query q = em.createQuery("SELECT v FROM Veicolo1 v WHERE v.marca = :vm");
		//Query q = em.createNamedQuery("VeicoloByMarca");
		q.setParameter("vm", marca);
		return q.getResultList();
	}
	
	public static Veicolo1 findVeicoloById(Long id) {
		Query q = em.createQuery("SELECT v FROM Veicolo1 v WHERE v.id = :id");
		//Query q = em.createNamedQuery("VeicoloByMarca");
		q.setParameter("id", id);
		return (Veicolo1) q.getSingleResult();
	}
	
	public static List<Veicolo1> findVeicoloByModello(String mod1, String mod2, String mod3, String marca) {
		//Query q = em.createQuery("SELECT v FROM Veicolo1 v WHERE v.modello IN ('Punto', '500', 'Smart')");
		//Query q = em.createQuery("SELECT v FROM Veicolo1 v WHERE v.modello IN (:mod1, :mod2, :mod3)");
		//q.setParameter("mod1", mod1);
		//q.setParameter("mod2", mod2);
		//q.setParameter("mod3", mod3);
		Query q = em.createQuery("SELECT v FROM Veicolo1 v WHERE v.modello IN (SELECT c.modello FROM Categoria c WHERE c.marca LIKE :marca)");
		q.setParameter("marca", marca);
		return q.getResultList();
	}
	
}
