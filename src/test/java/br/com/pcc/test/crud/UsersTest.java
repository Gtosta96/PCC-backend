package br.com.pcc.test.crud;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.TravelEntity;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;

public class UsersTest {

//	@Autowired
	private UserDao usersDao;
	private static Logger LOGGER;

	@Before
	public void setUp() {
		usersDao = DaoFactory.userDaoInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}
	
	@Test
	public void testSave() {
		UserEntity user = new UserEntity("Gabriel", "Tosta", "FIX it", "Masculino");
		UserDetailsEntity userDetails = new UserDetailsEntity("Gtosta96", "Gtosta96", "Mesma coisa que o usuário", "gabrieltosta3@gmail.com", true);
		
		List<TravelEntity> travelsList = new ArrayList<TravelEntity>();
		
		for(int i = 0; i < 5; i++) {
			TravelEntity travel = new TravelEntity("Mock" + i, "10/03/2016", "10/04/2016", 5d);
			travel.setUser(user);
			travelsList.add(travel);
		}
		
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
		
		user.setTravelsList(travelsList);
		
		try {
			usersDao.save(user);
			LOGGER.info("Usuário Inserido: " + user);
		} catch (Exception e) {
			LOGGER.error("Usuário não inserido, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testFindById() {		
		try {
			Long id = this.listAll().get(0).getUserId();
			UserEntity userData = this.usersDao.findById(id);
			LOGGER.info("Usuário Encontrado: " + userData);
		} catch (Exception e) {
			LOGGER.error("Usuário não encontrado, ocorreu um erro!", e);
		}
	}
	
	@Test
	public void testUpdate() {	
		try {
			UserEntity userData = this.listAll().get(0);
			
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
			UserEntity userData = this.listAll().get(0);
			usersDao.delete(userData);
			LOGGER.info("Usuário deletado: " + userData );	
		} catch (Exception e) {
			LOGGER.error("Usuário não deletado, ocorreu um erro!", e);
		}
	}

	@Test
	public void testListAll() {
		try {
			List<UserEntity> usersData = this.listAll();
			LOGGER.info("Usuários recuperados com sucesso!");
			for (UserEntity user : usersData) {
				System.out.println(user);
			}
			
		} catch (Exception e) {
			LOGGER.error("Usuários não listados, ocorreu um erro!", e);
		}
	}

	public List<UserEntity> listAll() throws Exception {
		return this.usersDao.listAll();
	}
}