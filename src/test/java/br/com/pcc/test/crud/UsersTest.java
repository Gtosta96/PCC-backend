package br.com.pcc.test.crud;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.UsersDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.UsersEntity;

public class UsersTest {

	private UsersDao usersDao;
	private static Logger LOGGER;

	@Before
	public void setUp() {
		usersDao = DaoFactory.UsersInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}
	
	@Test
	public void testSave() {
		UsersEntity user = new UsersEntity("Gabriel", "Gabriel", "Gabriel@gmail.com", "Gabriel", true);
		try {
			usersDao.save(user);
			LOGGER.info("Usu�rio Inserido: " + user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Usu�rio n�o inserido, ocorreu um erro!");
		}
	}
	
	@Test
	public void testFindById() {		
		try {
			Long id = this.listAll().get(0).getId();
			UsersEntity user = this.usersDao.findById(id);
			LOGGER.info("Usu�rio Encontrado: " + user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Usu�rio n�o encontrado, ocorreu um erro!");
		}
	}
	
	@Test
	public void testUpdate() {	
		try {
			UsersEntity user = this.listAll().get(0);
			
			user.setUsername("Gabriel2");
			user.setPassword("Gabriel2");
			user.setEmail("Gabriel2@gmail.com");
			user.setPasswordHint("Gabriel2");
			
			usersDao.update(user);
			LOGGER.info("Usu�rio Alterado: " + user);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Usu�rio n�o alterado, ocorreu um erro!" );
		}
	}
	
	@Test
	public void testDelete() {
		try {
			UsersEntity user = this.listAll().get(0);
			usersDao.delete(user);
			LOGGER.info("Usu�rio n�o deletado, ocorreu um erro!" );	
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Usu�rio Deletado, ocorreu um erro!");
		}
	}

	@Test
	public void testListAll() {
		try {
			List<UsersEntity> users = this.listAll();
			LOGGER.info(users);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Usu�rios n�o listados, ocorreu um erro!");
		}
	}
	
	public List<UsersEntity> listAll() throws Exception {
		return this.usersDao.listAll();
	}
}