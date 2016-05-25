package br.com.pcc.dao;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.FacebookUserEntity;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public class FacebookUserDao extends GenericDao<FacebookUserEntity, Long> {

	public FacebookUserEntity findByUserFacebookId(Long facebookId) {
		
		try {
			Query query = entityManager.createNativeQuery("select * from facebook_users where facebook_user_id = ?", FacebookUserEntity.class);
			query.setParameter(1, facebookId);
			
			return (FacebookUserEntity) query.getSingleResult();
			} catch (Exception e) {
				throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
			}
	}
}