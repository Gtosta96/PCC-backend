package br.com.pcc.dao;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.dto.SignUpDto;
import br.com.pcc.entity.UserDetailsEntity;

public class UserDetailsDao extends GenericDao<UserDetailsEntity, Long> {
	
	public Boolean hasFacebookUserByEmail(SignUpDto facebookUser) {
		
		//TODO: fazer isso de melhor forma
		try {
			Query query = entityManager.createNativeQuery("select * from user_details where email = ?", UserDetailsEntity.class);
			query.setParameter(1, facebookUser.getEmail());
			
			UserDetailsEntity user = (UserDetailsEntity) query.getSingleResult();
			return user != null ? true : false;
		} catch(Exception e) {
			return false;
		}	
	}

	public UserDetailsEntity findFacebookUserByEmail(SignUpDto signUpUser) {
		
		try {
			Query query = entityManager.createNativeQuery("select * from user_details where email = ?", UserDetailsEntity.class);
			query.setParameter(1, signUpUser.getEmail());
			
			return (UserDetailsEntity) query.getSingleResult();
		} catch(Exception e) {
			throw e;
		}	
	}
}