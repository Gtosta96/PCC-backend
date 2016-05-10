package br.com.pcc.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.dto.TravellerDto;
import br.com.pcc.entity.TravelEntity;
import br.com.pcc.service.TravelService;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

@Controller
public class TravelController {
	
	TravelService travelService = new TravelService();
	private static Logger LOGGER = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	@ResponseBody
	public List<TravelEntity> listTravelsFromTraveller(@RequestBody @Valid TravellerDto traveller,
			HttpServletResponse response) {
		
		List<TravelEntity> travelsList = null;
		try {
			LOGGER.info("Tentativa de listar viagens do usuário: " + traveller.getId());
			
			travelsList = travelService.findTravelsFromTraveller(traveller);
			LOGGER.info("Lista de viagens recuperada com sucesso");
		} catch (GenericExceptionEntity e) {
			LOGGER.error("Ocorreu um erro: " + e);
			throw e;
		}
		
		return travelsList;
	}
}