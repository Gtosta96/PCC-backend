package br.com.pcc.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.entity.LoginCredentialsEntity;

@Controller
public class UserController {

	private static Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public LoginCredentialsEntity authLogin(@RequestBody LoginCredentialsEntity user, HttpServletResponse response) {

		LOGGER.info("Tentativa de login, username: " + user.getUsername());
		
		if (user.getUsername().equals("123456") && user.getPassword().equals("123456")) {

			user.setUsername("USUARIO1");
			user.setPassword("USUARIO1");
			user.setEmail("USUARIO1");
		
			LOGGER.info("Usuário logado com sucesso: " + user.getUsername());
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			LOGGER.error("Usuário não autorizado: " + user.getUsername());
		}

		return user;
	}
}