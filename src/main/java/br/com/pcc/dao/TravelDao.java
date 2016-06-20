package br.com.pcc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.TravelEntity;

public class TravelDao extends GenericDao<TravelEntity, Long> {

	public List<TravelEntity> findInRange(Integer limit, Integer offset) {
		Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
														"photos p ON t.travel_id = p.travel_id " +
														"ORDER BY t.travel_id desc " +
														"limit ? offset ?", TravelEntity.class);
		query.setParameter(1, limit);
		query.setParameter(2, offset);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			TravelEntity newTravel = (TravelEntity) travel;
			if(!travels.contains(newTravel)) {
				travels.add(newTravel);
			}
		}
		return travels;
	}

	public List<TravelEntity> findByIdInRange(Long id, Integer pag, Integer len) {
		Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " + 
														"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
														"users u ON t.user_id = u.user_id WHERE " +
														"(u.user_id = ? or u.facebook_user_id = ?) " + 
														"limit ? offset ?", TravelEntity.class);
		query.setParameter(1, id);
		query.setParameter(2, id);
		query.setParameter(3, pag);
		query.setParameter(4, len);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			travels.add((TravelEntity) travel);
		}
		return travels;
	}
	
	public TravelEntity findTravelDetailsById(Long id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
														"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
														"comments c ON t.travel_id = c.travel_id " +
														"WHERE t.travel_id = ?", TravelEntity.class);
		query.setParameter(1, id);
		
		return (TravelEntity) query.getSingleResult();
	}

	public void deleteById(Long id) {
		Query query = entityManager.createNativeQuery("DELETE FROM travels WHERE travel_id = ?");
		query.setParameter(1, id);
		
		query.executeUpdate();
	}
}