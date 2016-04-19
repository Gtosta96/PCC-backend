package br.com.pcc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.service.UserService;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

@Controller
public class UserController {

//	@Autowired
	UserService userService = new UserService();
	UserDetailsEntity loginCredentials;
	
	private static Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public UserDetailsDto authLogin(@RequestBody @Valid UserDetailsDto user, HttpServletResponse response) {
 
		LOGGER.info("Tentativa de login, username: " + user.getUsernameOrEmail());
		loginCredentials = userService.getLoginCredentials(user);
		
		if (loginCredentials != null) {
			LOGGER.info("Usuário logado com sucesso: " + user.getUsernameOrEmail());
		} else {
			LOGGER.error("Usuário não autorizado: " + user.getUsernameOrEmail());
			throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
		}

		return user;
	}
}