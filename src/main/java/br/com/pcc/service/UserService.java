package br.com.pcc.service;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.pcc.converter.EntityConverter;
import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.UserDetailsDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.SignUpDto;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;
import br.com.pcc.mock.UserMock;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

//@Service
public class UserService {

	private EntityConverter converter;
	private static Logger LOGGER = Logger.getLogger(UserService.class);
	 
	public UserDetailsEntity getLoginCredentials(UserDetailsDto userDetailsDto) throws GenericExceptionEntity {
		UserDetailsEntity userDetails = converter.userDetailsDtoToUserDetailsEntity(userDetailsDto);
		UserDetailsDao userDetailsDao = DaoFactory.userDetailsDaoInstance();
		
		LOGGER.info("Tentativa de busca de Usuário.");
			//userDetails = userDetailsDao.findByUsernameOrEmail(userDetails.getUsernameOrEmail());
			
			List<UserDetailsEntity> usersDetails = userDetailsDao.listAll();
			for (UserDetailsEntity thisUserDetails : usersDetails) {
				if (thisUserDetails.getUsernameOrEmail() == userDetails.getUsernameOrEmail() && thisUserDetails.getPassword() == userDetails.getPassword()){
					userDetails = thisUserDetails;
					LOGGER.info("Usuário recuperado com sucesso: " + userDetails.getUsernameOrEmail());
					break;
				}
			}
			
			if (userDetails == null) {
				LOGGER.info("Usuário não encontrado, pegando dados do mock");
				userDetails = new UserMock().getMockLoginCredentialsEntity();
				//throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
			}

		return userDetails;
	}
	
	public void saveUser(SignUpDto signUpUser) {
		UserDao userDao = DaoFactory.userDaoInstance();
		
		UserEntity user = converter.signUpDtoToUserEntity(signUpUser);
		UserDetailsEntity userDetails = converter.signUpDtoToUserDetailsEntity(signUpUser);
		
		user.setUserDetails(userDetails);
		userDetails.setUser(user);
		
		userDao.save(user);
	}
}