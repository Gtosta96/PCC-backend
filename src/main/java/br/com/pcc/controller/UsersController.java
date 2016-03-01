package br.com.pcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

	@RequestMapping(value = "/authLogin", method = RequestMethod.GET, produces = "application/json")
	public String authLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		
		System.out.println("entrou");
		return "Work it!";
	}
}
