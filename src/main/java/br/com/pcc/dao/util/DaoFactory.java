package br.com.pcc.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pcc.dao.UserDao;

/** Dao Factory será responsável por inicializar o Entity Manager Factory
 *  @version 1.0.0
 *  @since version 1.0.0
 *  @author Gabriel Tosta
 */
public class DaoFactory {

	//CONTRUTOR
	private DaoFactory(){}
	
	//variavel estática com o nome da unidade de persistencia (persistence.xml).
	private static final String PERSISTENCE_UNIT_NAME = "PCC";
	
	//responsável por gerenciar conexão com banco de dados
	private static EntityManagerFactory entityManageFactoryInstance;
	
	//método responsável por abrir conexão com banco de dados
	public static EntityManagerFactory entityManagerFactoryInstance() {
		if (entityManageFactoryInstance == null)
			entityManageFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		return entityManageFactoryInstance;
	}
	
	//método responsável por criar nova instancia de Users
	private static UserDao usersDaoInstance;
	
	public static UserDao UsersInstance() {
		if(usersDaoInstance == null)
			usersDaoInstance = new UserDao();
		
		return usersDaoInstance;
	}
}