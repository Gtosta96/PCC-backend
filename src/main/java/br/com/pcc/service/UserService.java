package br.com.pcc.service;

import org.apache.log4j.Logger;

import br.com.pcc.converter.EntityConverter;
import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.dto.LoginCredentialsDto;
import br.com.pcc.entity.LoginCredentialsEntity;
import br.com.pcc.mock.UserMock;

//@Service
public class UserService {

//	@Autowired
	private GenericDao<LoginCredentialsEntity, Long> dao;
	
	private EntityConverter parser = new EntityConverter();
	private LoginCredentialsEntity userEntity = new LoginCredentialsEntity();
	private UserMock mock = new UserMock();
	
	private static Logger LOGGER = Logger.getLogger(UserService.class);
	 
	public LoginCredentialsEntity getLoginCredentials(LoginCredentialsDto userDto) {
		
		dao = new GenericDao<LoginCredentialsEntity, Long>();
		userEntity = parser.loginCredentialsDtoToLoginCredentialsEntity(userDto);
		
		LOGGER.info("Tentativa de busca de Usuário.");
		try {
			userEntity = dao.findByUsernameOrEmail(userEntity);
			
			LOGGER.info("Usuário recuperado com sucesso: " + userDto.getUsernameOrEmail());
		} catch (Exception e) {
			LOGGER.warn("Ocorreu um erro!, pegando dados do mock...", e);
			
			userEntity = mock.getMockLoginCredentialsEntity();
		}

		return userEntity;
	}
}