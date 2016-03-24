package br.com.pcc.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.dto.LoginCredentialsDto;
import br.com.pcc.entity.LoginCredentialsEntity;

@Service
public class UserService {

	@Autowired
	private GenericDao<LoginCredentialsDto, Long> dao;
	private static Logger LOGGER = Logger.getLogger(UserService.class); 
	
	public LoginCredentialsEntity getLoginCredentials(LoginCredentialsDto user) {
		dao = new GenericDao<LoginCredentialsDto, Long>();
		
		LOGGER.info("Tentativa de busca de Usuário.");
		try {
			dao.notifyAll();
			LOGGER.info("Usuário recuperado com sucesso, id: " + user.getUsernameOrEmail());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.warn("Ocorreu um erro!", e);
		}

		return null;
	}
}