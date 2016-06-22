package br.com.pcc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.TravelEntity;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public class TravelDao extends GenericDao<TravelEntity, Long> {
	
	List<TravelEntity> travelsAlreadySent = new ArrayList<TravelEntity>();
	List<TravelEntity> travelsByIdAlreadySent = new ArrayList<TravelEntity>();

	public List<TravelEntity> findInRange(Integer limit, Integer offset) {
		
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
															"photos p ON t.travel_id = p.travel_id " +
															"ORDER BY t.travel_id " +
															"limit ? offset ?", TravelEntity.class);
			
			query.setParameter(1, limit);
			query.setParameter(2, offset);
			
			Map<Long, TravelEntity> map = new HashMap<Long, TravelEntity>();
			for (Object travel : query.getResultList()) {
				TravelEntity t = (TravelEntity) travel;
				map.put(t.getTravelId(), t);
			}
			
			List<TravelEntity> travelsToServer = new ArrayList<TravelEntity>(map.values());
			
			return travelsToServer;
		} catch (Exception e) {
			throw new GenericExceptionEntity(ExceptionEnums.DAO_GET_ERROR);
		} finally {
			/*IMPLEMENTS*/
		}
	}

	public List<TravelEntity> findByIdInRange(Long id, Integer pag, Integer len) {
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " + 
															"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
															"users u ON t.user_id = u.user_id WHERE " +
															"(u.user_id = ? or u.facebook_user_id = ?) " + 
															"limit ? offset ?", TravelEntity.class);
			query.setParameter(1, id);
			query.setParameter(2, id);
			query.setParameter(3, pag);
			query.setParameter(4, len);
	
			Map<Long, TravelEntity> map = new HashMap<Long, TravelEntity>();
			for (Object travel : query.getResultList()) {
				TravelEntity t = (TravelEntity) travel;
				map.put(t.getTravelId(), t);
			}
			
			List<TravelEntity> travelsToServer = new ArrayList<TravelEntity>(map.values());
			
			return travelsToServer;
		} catch (Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_GET_ERROR);
		} finally {
			/*IMPLEMENTS*/
		}
	}
	
	public TravelEntity findTravelDetailsById(Long id) {
		try{
			Query query = entityManager.createNativeQuery("SELECT * FROM travels t LEFT JOIN " +
															"photos p ON t.travel_id = p.travel_id LEFT JOIN " +
															"comments c ON t.travel_id = c.travel_id " +
															"WHERE t.travel_id = ?", TravelEntity.class);
			query.setParameter(1, id);
			
			return (TravelEntity) query.getSingleResult();
		} catch (Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_GET_ERROR);
		} finally {
			/*IMPLEMENTS*/
		}
	}

	//TODO: corrigir para que funcione (Transational error).
	public void deleteById(Long id) {
		try {
			Query query = entityManager.createNativeQuery("DELETE FROM travels WHERE travel_id = ?", TravelEntity.class);
			query.setParameter(1, id);
			query.executeUpdate();
		} catch (Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_DELETE_ERROR);
		} finally {
			/*IMPLEMENTS*/
		}
	}
}