package br.com.pcc.service;

import org.apache.log4j.Logger;

import br.com.pcc.converter.EntityConverter;
import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.UserDetailsDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.SignUpDto;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

//@Service
public class UserService {

	private static Logger LOGGER = Logger.getLogger(UserService.class);
	 
	public UserDetailsEntity getLoginCredentials(UserDetailsDto userDetailsDto) throws GenericExceptionEntity {
		UserDetailsDao userDetailsDao = DaoFactory.userDetailsDaoInstance();
		UserDetailsEntity userDetails = EntityConverter.userDetailsDtoToUserDetailsEntity(userDetailsDto);
		
		LOGGER.info("Tentativa de busca de Usuário.");
		UserDetailsEntity userDetailsFinal = null;
		userDetailsFinal = userDetailsDao.findByUsernameOrEmail(userDetails.getUsernameOrEmail(), userDetails.getPassword());
		
		if (userDetailsFinal != null) {
			LOGGER.info("Usuário recuperado com sucesso: " + userDetailsFinal.getUsernameOrEmail());
		} else {
				LOGGER.info("Usuário não encontrado, pegando dados do mock/lançando exception");
				//userDetailsFinal = new UserMock().getMockLoginCredentialsEntity();
				throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
			}

		return userDetailsFinal;
	}
	
	public void saveUser(SignUpDto signUpUser) {
		UserDao userDao = DaoFactory.userDaoInstance();
		
		UserEntity user = EntityConverter.signUpDtoToUserEntity(signUpUser);
		UserDetailsEntity userDetails = EntityConverter.signUpDtoToUserDetailsEntity(signUpUser);
		
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
		
		userDao.save(user);
	}
}