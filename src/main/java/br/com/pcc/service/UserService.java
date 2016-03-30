package br.com.pcc.service;

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
			userDetails = userDetailsDao.findByUsernameOrEmail(userDetails.getUsernameOrEmail());
			
			LOGGER.info("Usuário recuperado com sucesso: " + userDetails.getUsernameOrEmail());
		} catch (Exception e) {
			LOGGER.warn("Ocorreu um erro!, pegando dados do mock...", e);
			
			userDetails = new UserMock().getMockLoginCredentialsEntity();
		}

		return userDetails;
	}
}