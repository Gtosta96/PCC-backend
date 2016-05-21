package br.com.pcc.service;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.pcc.converter.TravelConverter;
import br.com.pcc.dao.TravelDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.TravelDto;
import br.com.pcc.dto.TravellerDto;
import br.com.pcc.entity.TravelEntity;

//@Service
public class TravelService {

	TravelDao travelDao = DaoFactory.travelDaoInstance();
	private static Logger LOGGER = Logger.getLogger(TravelService.class);

	public void saveTravel(TravelDto travelDto) {
		
		TravelEntity travel = TravelConverter.travelDtoToTravelEntity(travelDto);
		travelDao.save(travel);
	}
	
	public List<TravelEntity> findTravelsFromTraveller(TravellerDto traveller) {

		LOGGER.info("Tentativa de busca de viagens.");
		List<TravelEntity> travelsList = null;

		if (traveller.getIsFacebookUser()) {
			travelsList = travelDao.findByTravellerId(traveller.getId());
		} else {
			travelsList = travelDao.findByFacebookTravellerId(traveller.getId());
		}

		if (travelsList != null) {
			LOGGER.info("Viagens recuperadas com sucesso");
		} else {
			LOGGER.info("Viagens não encontrada, pegando dados do mock");
			// UserMock().getMockLoginCredentialsEntity();
		}

		return travelsList;
	}
}