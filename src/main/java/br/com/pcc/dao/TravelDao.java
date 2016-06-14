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

	public List<TravelEntity> findInRange(Integer pag, Integer len) {
		Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
														"users u ON u.user_id = t.user_id LEFT JOIN " +
														"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
														"comments c ON t.travel_id = c.travel_id " +
														"WHERE t.travel_id >= ? AND t.travel_id <= ?", TravelEntity.class);
		query.setParameter(1, pag);
		query.setParameter(2, len);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			travels.add((TravelEntity) travel);
		}
		return travels;
	}

	public List<TravelEntity> findByIdInRange(Long id, Integer pag, Integer len) {
		Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
													 	"users u ON u.user_id = t.user_id LEFT JOIN " +
													 	"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
													 	"comments c ON t.travel_id = c.travel_id " +
													 	"WHERE t.travel_id >= ? AND t.travel_id <= ? " +
													 	"AND u.user_id = ?", TravelEntity.class);
		query.setParameter(1, pag);
		query.setParameter(2, len);
		query.setParameter(3, id);

		List<TravelEntity> travels = new ArrayList<TravelEntity>();
		for (Object travel : query.getResultList()) {
			travels.add((TravelEntity) travel);
		}
		return travels;
	}
}