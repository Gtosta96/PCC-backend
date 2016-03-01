package br.com.pcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.entity.UsersEntity;

@Controller
public class UsersController {

	@RequestMapping(value = "/loginAuth", method = RequestMethod.GET)
	@ResponseBody
	public UsersEntity authLogin(@RequestParam(name = "username", required = false) String username,
								 @RequestParam(name = "password", required = false) String password) {
		
		UsersEntity user = new UsersEntity();
		
		System.out.println(username);
		System.out.println(password);
		
		user.setUsername("USUARIO1");
		user.setPassword("USUARIO1");
		user.setEmail("USUARIO1");

		return user;
	}
}