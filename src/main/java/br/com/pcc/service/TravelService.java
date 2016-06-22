package br.com.pcc.service;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.pcc.converter.TravelConverter;
import br.com.pcc.dao.TravelDao;
import br.com.pcc.dao.UserDao;
import br.com.pcc.dao.util.DaoFactory;
import br.com.pcc.dto.TravelDto;
import br.com.pcc.entity.TravelEntity;

//@Service
public class TravelService {

	TravelDao travelDao = DaoFactory.travelDaoInstance();
	UserDao userDao = DaoFactory.userDaoInstance();
	private static Logger LOGGER = Logger.getLogger(TravelService.class);

	public void saveTravel(Long id, TravelDto travelDto) {
		
		TravelEntity travel = TravelConverter.travelDtoToTravelEntity(travelDto);
		travel.setUser(userDao.findByIdOrFacebookId(id));
		
		travelDao.save(travel);
	}
	
	public List<TravelEntity> getTravelsInRange(Long id, Integer limit, Integer offset) {
		if (id != null) {
			return travelDao.findByIdInRange(id, limit, offset);
		} else {
			return travelDao.findInRange(limit, offset);
		}
	}
	
	public TravelEntity getTravelDetailsById(Long id) {
		LOGGER.info("Tentativa de busca de viagem, id: " + id);
		
		return travelDao.findTravelDetailsById(id);
	}

	public void deleteTravel(Long id) {
		TravelEntity travel = travelDao.findById(id);
		travelDao.delete(travel);
	}
}