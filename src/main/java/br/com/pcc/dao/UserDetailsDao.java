package br.com.pcc.dao;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public class UserDetailsDao extends GenericDao<UserDetailsEntity, Long> {
	
	public UserDetailsEntity findByUsernameOrEmail(String usernameOrEmail, String password) throws GenericExceptionEntity {
		
//		select * from user_details where (username || email) iLIKE ? and password = ?
//		TypedQuery<UserDetailsEntity> query = (TypedQuery<UserDetailsEntity>) entityManager.createNativeQuery("select * from user_details where (username || email) iLIKE ?", UserDetailsEntity.class);
		Query query = entityManager.createNativeQuery("select * from user_details where (username || email) iLIKE ?", UserDetailsEntity.class);
		query.setParameter(1, "%" + usernameOrEmail + "%");
//		query.setParameter(2, password);
		
		return (UserDetailsEntity) query.getSingleResult();
	}
}