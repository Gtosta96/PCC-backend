package br.com.pcc.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pcc.dao.FacebookUserDao;
import br.com.pcc.dao.TravelDao;
import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.UserDetailsDao;

/**
 * Dao Factory será responsável por inicializar o Entity Manager Factory
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

// @Repository
public class DaoFactory {

	// CONTRUTOR
	private DaoFactory() {
	}

	private static final String PERSISTENCE_UNIT_NAME = "PCC";
	private static EntityManagerFactory entityManageFactoryInstance;

	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (entityManageFactoryInstance == null) {
			entityManageFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}

		return entityManageFactoryInstance;
	}

	private static UserDao userDaoInstance;
	public static UserDao userDaoInstance() {
		if (userDaoInstance == null) {
			userDaoInstance = new UserDao();
		}

		return userDaoInstance;
	}
	
	private static UserDetailsDao userDetailsDaoInstance;
	public static UserDetailsDao userDetailsDaoInstance() {
		if (userDetailsDaoInstance == null) {
			userDetailsDaoInstance = new UserDetailsDao();
		}

		return userDetailsDaoInstance;
	}
	
	private static FacebookUserDao facebookUserDaoInstance;
	public static FacebookUserDao facebookUserDaoInstance() {
		if (facebookUserDaoInstance == null) {
			facebookUserDaoInstance = new FacebookUserDao();
		}

		return facebookUserDaoInstance;
	}
	
	private static TravelDao travelDaoInstance;
	public static TravelDao travelDaoInstance() {
		if (travelDaoInstance == null) {
			travelDaoInstance = new TravelDao();
		}

		return travelDaoInstance;
	}
}