package br.com.pcc.service;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.pcc.dao.TravelDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.TravellerDto;
import br.com.pcc.entity.TravelEntity;

//@Service
public class TravelService {

	private static Logger LOGGER = Logger.getLogger(TravelService.class);

	public List<TravelEntity> findTravelsFromTraveller(TravellerDto traveller) {

		TravelDao travelDao = DaoFactory.travelDaoInstance();

		LOGGER.info("Tentativa de busca de viagens.");
		List<TravelEntity> travelsList = null;

		if (traveller.getIsLoggedFromFacebook()) {
			travelsList = travelDao.findByTravellerId(traveller.getId());
		} else {
			travelsList = travelDao.findFacebookTravellerById(traveller.getId());
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