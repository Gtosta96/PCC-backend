package br.com.pcc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.dto.SignUpDto;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserEntity;
import br.com.pcc.service.UserService;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

@Controller
public class UserController {
	
	UserService userService = new UserService();
	private static Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public UserEntity authLogin(@RequestBody @Valid UserDetailsDto credentials, HttpServletResponse response) {		
		UserEntity user = null;
		try {
			LOGGER.info("Tentativa de login, username/email: " + credentials.getUsernameOrEmail());
			
			user = userService.findByLoginCredentials(credentials);
			LOGGER.info("Usuário logado com sucesso: " + user.getUserDetails().getUsernameOrEmail());
		} catch (GenericExceptionEntity e) {
			LOGGER.error("Usuário não autorizado: " + e);
			throw e;
		}

		return user;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public void signUp(@RequestBody @Valid SignUpDto user, HttpServletResponse response) {		
		try {
			LOGGER.info("Tentativa de cadastro, email: " + user.getEmail());
			
			userService.saveUser(user);
			LOGGER.info("Usuário cadastrado com sucesso: " + user.getEmail());
		} catch (GenericExceptionEntity e) {
			LOGGER.error("Usuário não cadastrado: " + e);
			throw e;
		}
	}	
}