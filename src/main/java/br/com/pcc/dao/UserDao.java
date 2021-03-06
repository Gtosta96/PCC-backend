package br.com.pcc.dao;

import javax.persistence.Query;

import br.com.pcc.dao.util.GenericDao;
import br.com.pcc.entity.UserEntity;
import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public class UserDao extends GenericDao<UserEntity, Long> {

public UserEntity findUserByUsernameOrEmail(String usernameOrEmail, String password) {	
	try {
		Query query = entityManager.createNativeQuery("select * from users u INNER JOIN user_details ud ON u.user_id = ud.user_id where ud.username iLIKE ? or ud.email iLIKE ? and password = ?", UserEntity.class);
		query.setParameter(1, "%" + usernameOrEmail + "%");
		query.setParameter(2, "%" + usernameOrEmail + "%");
		query.setParameter(3, password);
		
		return (UserEntity) query.getSingleResult();
		} catch (Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
		} finally {
			/*IMPLEMENTS*/
		}
	}

public UserEntity findByIdOrFacebookId(Long id) {
	try {
		Query query = entityManager.createNativeQuery("select * from users where user_id = ? or facebook_user_id = ?", UserEntity.class);
		query.setParameter(1, id);
		query.setParameter(2, id);
		
		return (UserEntity) query.getSingleResult();
		} catch (Exception e) {
			rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.INVALID_USER);
		} finally {
			/*IMPLEMENTS*/
		}
	}
}