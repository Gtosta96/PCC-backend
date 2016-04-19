package br.com.pcc.service;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.pcc.converter.EntityConverter;
import br.com.pcc.dao.UserDetailsDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.mock.UserMock;

//@Service
public class UserService {

//	@Autowired
	private UserDetailsDao userDetailsDao;
	private UserDetailsEntity userDetails = new UserDetailsEntity();
	private static Logger LOGGER = Logger.getLogger(UserService.class);
	 
	public UserDetailsEntity getLoginCredentials(UserDetailsDto userDetailsDto) {

		userDetails = new EntityConverter().userDetailsDtoToUserDetailsEntity(userDetailsDto);
		
		LOGGER.info("Tentativa de busca de Usuário.");
		try {
			userDetailsDao = DaoFactory.userDetailsDaoInstance();
			//userDetails = userDetailsDao.findByUsernameOrEmail(userDetails.getUsernameOrEmail());
			
			List<UserDetailsEntity> usersDetails = userDetailsDao.listAll();
			for (UserDetailsEntity userDetails : usersDetails) {
				if (userDetails.getUsernameOrEmail() == userDetails.getUsernameOrEmail() && userDetails.getPassword() == userDetails.getPassword()){
					this.userDetails = userDetails;
					LOGGER.info("Usuário recuperado com sucesso: " + userDetails.getUsernameOrEmail());
					break;
				} else {
					LOGGER.info("Usuário não encontrado, lançado exception!");
					throw new Exception();
				}
			}
		} catch (Exception e) {
			userDetails = new UserMock().getMockLoginCredentialsEntity();
			LOGGER.warn("Ocorreu um erro!, pegando dados do mock...", e);
		}

		return userDetails;
	}
}