package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

public class MainProject {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_project");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		User u = new User();
		u.setName("Mario");
		u.setLastname("Rossi");
		u.setEmail("m.rossi@example.com");
		
		User u2 = new User();
		u2.setName("Giuseppe");
		u2.setLastname("Verdi");
		u2.setEmail("g.verdi@example.com");
	

		try {

			//addUser(u2);
		
			//User utenteletto = findUser(1l);
			//System.out.println(utenteletto);
			
			//utenteletto.setEmail("test@example.com");
			// updateUser(utenteletto);
			
			//removeUser(utenteletto);
			
			List<User> lista = findAllUser();
			lista.forEach(ut -> System.out.println(ut));
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
			emf.close();
		}
		
	}
	
	public static void addUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente salvato nel DB!!!");
	}
	
	public static User findUser(Long id) {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public static void updateUser(User u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("Utente modificato nel DB!!!");
	}
	
	public static void removeUser(User u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("Utente eliminato nel DB!!!");
	}
	
	public static List<User> findAllUser(){
		Query q = em.createNamedQuery("User.findAll");
		return q.getResultList();
	}

}
