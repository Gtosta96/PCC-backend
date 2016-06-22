package br.com.pcc.dao;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.dto.SignUpDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

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
		} finally {
			/*IMPLEMENTS*/
		}
	}

	public UserDetailsEntity findFacebookUserByEmail(SignUpDto signUpUser) {
		
		try {
			Query query = entityManager.createNativeQuery("select * from user_details where email = ?", UserDetailsEntity.class);
			query.setParameter(1, signUpUser.getEmail());
			
			return (UserDetailsEntity) query.getSingleResult();
		} catch(Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_GET_ERROR);
		} finally {
			/*IMPLEMENTS*/
		}
	}
}