package br.com.pcc.test.crud;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.LoginCredentialsDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.LoginCredentialsEntity;
import br.com.pcc.entity.UserCredentialsEntity;

public class UsersTest {

	private LoginCredentialsDao usersDao;
	private static Logger LOGGER;

	@Before
	public void setUp() {
		usersDao = DaoFactory.loginCredentialsInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}
	
	@Test
	public void testSave() {
		UserCredentialsEntity credentials = new UserCredentialsEntity("Gabriel", "Tosta", "FIX it", "Masculino");
		LoginCredentialsEntity user = new LoginCredentialsEntity("Gtosta96", "Gtosta96", "Mesma coisa que o usu�rio", "gabrieltosta3@gmail.com", credentials, true);
		try {
			usersDao.save(user);
			LOGGER.info("Usu�rio Inserido: " + user);
		} catch (Exception e) {
			LOGGER.error("Usu�rio n�o inserido, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testFindById() {		
		try {
			Long id = this.listAll().get(0).getId();
			LoginCredentialsEntity user = this.usersDao.findById(id);
			LOGGER.info("Usu�rio Encontrado: " + user);
		} catch (Exception e) {
			LOGGER.error("Usu�rio n�o encontrado, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testUpdate() {	
		try {
			LoginCredentialsEntity user = this.listAll().get(0);
			
			user.setUsername("Gabriel2");
			user.setPassword("Gabriel2");
			user.setEmail("Gabriel2@gmail.com");
			user.setPasswordHint("Gabriel2");
			
			usersDao.update(user);
			LOGGER.info("Usu�rio Alterado: " + user);
		} catch (Exception e) {
			LOGGER.error("Usu�rio n�o alterado, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testDelete() {
		try {
			LoginCredentialsEntity user = this.listAll().get(0);
			usersDao.delete(user);
			LOGGER.info("Usu�rio deletado: " + user );	
		} catch (Exception e) {
			LOGGER.error("Usu�rio n�o deletado, ocorreu um erro!", e);
		}
	}

	@Test
	public void testListAll() {
		try {
			List<LoginCredentialsEntity> users = this.listAll();
			LOGGER.info(users);
		} catch (Exception e) {
			LOGGER.error("Usu�rios n�o listados, ocorreu um erro!", e);
		}
	}
	
	public List<LoginCredentialsEntity> listAll() throws Exception {
		return this.usersDao.listAll();
	}
}