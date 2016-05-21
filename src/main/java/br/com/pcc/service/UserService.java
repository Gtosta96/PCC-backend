package br.com.pcc.service;

import org.apache.log4j.Logger;

import br.com.pcc.converter.UserConverter;
import br.com.pcc.dao.UserDao;
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
	UserDao userDao = DaoFactory.userDaoInstance();
	 
	public UserEntity findByLoginCredentials(UserDetailsDto userDetailsDto) throws GenericExceptionEntity {
		UserDetailsEntity userDetails = UserConverter.userDetailsDtoToUserDetailsEntity(userDetailsDto);
		
		LOGGER.info("Tentativa de busca de Usuário.");
		UserEntity user = null;
		user = userDao.findUserByUsernameOrEmail(userDetails.getUsernameOrEmail(), userDetails.getPassword()); 
		
		if (user != null) {
			LOGGER.info("Usuário recuperado com sucesso: " + user.getUserDetails().getUsername());
		} else {
				LOGGER.info("Usuário não encontrado, pegando dados do mock/lançando exception");
				//userDetailsFinal = new UserMock().getMockLoginCredentialsEntity();
				throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
			}

		return user;
	}
	
	public void saveUser(SignUpDto signUpUser) {
		
		UserEntity user = UserConverter.signUpDtoToUserEntity(signUpUser);
		UserDetailsEntity userDetails = UserConverter.signUpDtoToUserDetailsEntity(signUpUser);
		
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
		userDetails.setEnabled(true);
		
		userDao.save(user);
	}
}