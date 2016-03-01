package br.com.pcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.entity.UsersEntity;

@Controller
public class UsersController {

	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public UsersEntity authLogin(@RequestParam("username") String username,
							@RequestParam("password") String password) {
		
		UsersEntity user = new UsersEntity();
		user.setUsername("USUARIO1");
		user.setPassword("USUARIO1");
		user.setEmail("USUARIO1");
		
		return user;
	}
}