package br.com.pcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pcc.dto.TravelDto;
import br.com.pcc.entity.TravelEntity;
import br.com.pcc.service.TravelService;

@Controller
public class TravelController {

	TravelService travelService = new TravelService();
	private static Logger LOGGER = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/saveTravel/{id}", method = RequestMethod.POST)
	@ResponseBody
	public void saveTravel(@RequestBody @PathVariable("id") Long id, @RequestBody @Valid TravelDto travel) {
		LOGGER.info("Tentativa de salvar viagem:, UserID: " + id);

		travelService.saveTravel(id, travel);
		LOGGER.info("Viagem salva com sucesso!");		
	}

	@RequestMapping(value = "/travelsList", method = RequestMethod.GET)
	@ResponseBody
	public List<TravelEntity> listTravelsFromTraveller(@RequestParam(required = false) Long id, @RequestParam Integer pag, @RequestParam Integer len) {
		LOGGER.info("Iniciado busca paginada");
		return travelService.getTravelsInRange(id, pag, len);
	}
}