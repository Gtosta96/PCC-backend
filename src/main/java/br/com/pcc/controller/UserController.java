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
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.service.UserService;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

@Controller
public class UserController {
	
	UserService userService = new UserService();
	private static Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public UserDetailsEntity authLogin(@RequestBody @Valid UserDetailsDto user, HttpServletResponse response) {		
		UserDetailsEntity loginCredentials = null;
		try {
			LOGGER.info("Tentativa de login, username/email: " + user.getUsernameOrEmail());
			
			loginCredentials = userService.getLoginCredentials(user);
			LOGGER.info("Usuário logado com sucesso: " + loginCredentials.getUsernameOrEmail());
		} catch (GenericExceptionEntity e) {
			LOGGER.error("Usuário não autorizado: " + e);
			throw e;
		}

		return loginCredentials;
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