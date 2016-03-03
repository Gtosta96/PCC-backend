package br.com.pcc.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pcc.dao.LoginCredentialsDao;

/** Dao Factory ser� respons�vel por inicializar o Entity Manager Factory
 *  @version 1.0.0
 *  @since version 1.0.0
 *  @author Gabriel Tosta
 */
public class DaoFactory {

	//CONTRUTOR
	private DaoFactory(){}
	
	//variavel est�tica com o nome da unidade de persistencia (persistence.xml).
	private static final String PERSISTENCE_UNIT_NAME = "PCC";
	
	//respons�vel por gerenciar conex�o com banco de dados
	private static EntityManagerFactory entityManageFactoryInstance;
	
	//m�todo respons�vel por abrir conex�o com banco de dados
	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (entityManageFactoryInstance == null)
			entityManageFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		return entityManageFactoryInstance;
	}
	
	//m�todo respons�vel por criar e garantir uma �nica instancia para LoginCredentials
	private static LoginCredentialsDao loginCredentialsDaoInstance;
	
	public static LoginCredentialsDao loginCredentialsInstance() {
		if(loginCredentialsDaoInstance == null)
			loginCredentialsDaoInstance = new LoginCredentialsDao();
		
		return loginCredentialsDaoInstance;
	}
}