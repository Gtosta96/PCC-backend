package br.com.pcc.test.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.pcc.dao.FacebookUserDao;
import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.entity.FacebookUserEntity;
import br.com.pcc.entity.TravelEntity;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;

public class UsersTest {

	private static final int USER = 0;
	private static final int USER_DETAILS = 1;
	// @Autowired
	private UserDao usersDao;
	private FacebookUserDao facebookUsersDao;
	private static Logger LOGGER;
	
	static Date today = new Date();
	static Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

	@Before
	public void setUp() {
		usersDao = DaoFactory.userDaoInstance();
		facebookUsersDao = DaoFactory.facebookUserDaoInstance();
		LOGGER = Logger.getLogger(UsersTest.class);
	}

	
	@Test
	public void testSaveUser() {
		
		Object[] randomUser = generateRandomUser();
		UserEntity user = ((UserEntity) randomUser[USER]);
		UserDetailsEntity userDetails = ((UserDetailsEntity) randomUser[USER_DETAILS]);

		user.setUserDetails(userDetails);
		userDetails.setUser(user);

		try {
			usersDao.save(user);
			LOGGER.info("Usuário Inserido: " + user);
		} catch (Exception e) {
			LOGGER.error("Usuário não inserido, ocorreu um erro!", e);
		}
	}

	@Test
	public void testSaveUserAndAddTravels() {

		Object[] randomUser = generateRandomUser();
		UserEntity user = ((UserEntity) randomUser[USER]);
		UserDetailsEntity userDetails = ((UserDetailsEntity) randomUser[USER_DETAILS]);

		List<TravelEntity> travelsList = new ArrayList<TravelEntity>();

		int n = generateRandomNumber();
		for (int i = 0; i < 5; i++) {
			TravelEntity travel = new TravelEntity("Travel-" + i + "-" + n, today, tomorrow, 5d);
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
	public void testSaveFacebookUserAndAddTravels() {

		FacebookUserEntity facebookUser = new FacebookUserEntity();
		List<TravelEntity> travelsList = new ArrayList<TravelEntity>();

		int n = generateRandomNumber();
		for (int i = 0; i < 5; i++) {
			TravelEntity travel = new TravelEntity("Travel-" + i + "-" + n, today, tomorrow, 5d);
			travel.setFacebookUser(facebookUser);
			travelsList.add(travel);
		}
		facebookUser.setFacebookId(230293023l);
		facebookUser.setTravelsList(travelsList);

		try {
			facebookUsersDao.save(facebookUser);
			LOGGER.info("Usuário Inserido: " + facebookUser);
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
			userData.setBornDate(tomorrow);

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
			LOGGER.info("Usuário deletado: " + userData);
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

	public Object[] generateRandomUser() {
		int n = generateRandomNumber();

		UserEntity user = new UserEntity("name-" + n, "lastName-" + n, new Date(), "Masculino");
		UserDetailsEntity userDetails = new UserDetailsEntity("myUser-" + n, "myUser-" + n, "",
				"myUser-" + n + "@gmail.com", true);
		Object array[] = { user, userDetails };

		return array;
	}
	
	public int generateRandomNumber() {
		return new Random().nextInt(500);
	}
}