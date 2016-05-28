package br.com.pcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.TravelEntity;

public class TravelDao extends GenericDao<TravelEntity, Long> {

	public List<TravelEntity> findByTravellerId(Long id) {
		// TODO Auto-generated method stub

		return null;
	}

	public List<TravelEntity> findByFacebookTravellerId(Long id) {
		// TODO Auto-generated method stub

		return null;
	}

	public List<TravelEntity> findInRange(Integer pag, Integer len) {
		Query query = entityManager.createNativeQuery("select * from travels where travel_id >= ? and travel_id <= ?", TravelEntity.class);
		query.setParameter(1, pag);
		query.setParameter(2, len);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			travels.add((TravelEntity) travel);
		}
		return travels;
	}

	public List<TravelEntity> findByIdInRange(Long id, Integer pag, Integer len) {
		Query query = entityManager.createNativeQuery("select * from travels where travel_id >= ? and travel_id <= ? and (user_id = ? or facebook_id = ?)", TravelEntity.class);
		query.setParameter(1, pag);
		query.setParameter(2, len);
		query.setParameter(3, id);
		query.setParameter(4, id);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			travels.add((TravelEntity) travel);
		}
		return travels;
	}
}