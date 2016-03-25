package br.com.pcc.test.crud;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.UserCredentialsDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.LoginCredentialsEntity;
import br.com.pcc.entity.UserCredentialsEntity;

public class UsersTest {

//	@Autowired
	private UserCredentialsDao usersDao;
	private static Logger LOGGER;

	@Before
	public void setUp() {
		usersDao = DaoFactory.userCredentialsInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}
	
	@Test
	public void testSave() {
		UserCredentialsEntity userData = new UserCredentialsEntity("Gabriel", "Tosta", "FIX it", "Masculino");
		LoginCredentialsEntity loginUserData = new LoginCredentialsEntity("Gtosta96", "Gtosta96", "Mesma coisa que o usuário", "gabrieltosta3@gmail.com", true);
		
		userData.setLoginCredentials(loginUserData);
		loginUserData.setUserCredentials(userData);
		
		try {
			usersDao.save(userData);
			LOGGER.info("Usuário Inserido: " + userData);
		} catch (Exception e) {
			LOGGER.error("Usuário não inserido, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testFindById() {		
		try {
			Long id = this.listAll().get(0).getUserId();
			UserCredentialsEntity userData = this.usersDao.findById(id);
			LOGGER.info("Usuário Encontrado: " + userData);
		} catch (Exception e) {
			LOGGER.error("Usuário não encontrado, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testUpdate() {	
		try {
			UserCredentialsEntity userData = this.listAll().get(0);
			
			userData.setFirstName("Gabriel2");
			userData.setLastName("Tosta2");
			userData.setBornDate("10/03/1996");
			
			usersDao.update(userData);
			LOGGER.info("Usuário Alterado: " + userData);
		} catch (Exception e) {
			LOGGER.error("Usuário não alterado, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testDelete() {
		try {
			UserCredentialsEntity userData = this.listAll().get(0);
			usersDao.delete(userData);
			LOGGER.info("Usuário deletado: " + userData );	
		} catch (Exception e) {
			LOGGER.error("Usuário não deletado, ocorreu um erro!", e);
		}
	}

	@Test
	public void testListAll() {
		try {
			List<UserCredentialsEntity> usersData = this.listAll();
			LOGGER.info(usersData);
		} catch (Exception e) {
			LOGGER.error("Usuários não listados, ocorreu um erro!", e);
		}
	}
	
	public List<UserCredentialsEntity> listAll() throws Exception {
		return this.usersDao.listAll();
	}
}