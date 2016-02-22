package br.com.pcc.mock;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pcc.model.Users;

public class Test {

	//TODO: REMOVE AND CREATE A TEST CLASS!
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PCC");
		EntityManager manager = factory.createEntityManager();
		
		Users user = new Users();
		
		user.setUsername("abc");
		user.setPassword("abc");
		user.setEmail("abc");
		user.setPasswordHint("abc");
		user.setEnabled(true);
		
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
	}
}