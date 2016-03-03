package br.com.pcc.test.crud;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.LoginCredentialsEntity;

public class UsersTest {

	private UserDao usersDao;
	private static Logger LOGGER;

	@Before
	public void setUp() {
		usersDao = DaoFactory.UsersInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}
	
	@Test
	public void testSave() {
		LoginCredentialsEntity user = new LoginCredentialsEntity("Gabriel", "Gabriel", "Gabriel@gmail.com", "Gabriel", null);
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