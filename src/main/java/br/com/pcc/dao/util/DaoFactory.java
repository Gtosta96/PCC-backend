package br.com.pcc.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pcc.dao.UserCredentialsDao;

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

	private static UserCredentialsDao userCredentialsDaoInstance;

	public static UserCredentialsDao userCredentialsInstance() {
		if (userCredentialsDaoInstance == null) {
			userCredentialsDaoInstance = new UserCredentialsDao();
		}

		return userCredentialsDaoInstance;
	}
}