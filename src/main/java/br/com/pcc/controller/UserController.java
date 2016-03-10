package br.com.pcc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.dto.LoginCredentialsDto;
import br.com.pcc.exception.model.GenericException;

@Controller
public class UserController {

	private static Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public LoginCredentialsDto authLogin(@RequestBody @Valid LoginCredentialsDto user, HttpServletResponse response) {

		LOGGER.info("Tentativa de login, username: " + user.getUsernameOrEmail());
				
		if (user.getUsernameOrEmail().equals("123456") && user.getPassword().equals("123456")) {
			LOGGER.info("Usu√°rio logado com sucesso: " + user.getUsernameOrEmail());
		} else {
			LOGGER.error("Usu√°rio n√£o autorizado: " + user.getUsernameOrEmail());
			throw new GenericException("Erro", "Usu·rio n„o encontrado");
		}

		return user;
	}
}