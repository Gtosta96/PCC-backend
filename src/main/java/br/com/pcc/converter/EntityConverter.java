package br.com.pcc.converter;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;

public class EntityConverter {

	public UserDetailsEntity userDetailsDtoToUserDetailsEntity(UserDetailsDto dto) {
		
		UserDetailsEntity entity = new UserDetailsEntity();
		boolean isEmail = EmailValidator.getInstance().isValid(dto.getUsernameOrEmail());
		
		if (isEmail) {
			entity.setEmail(dto.getUsernameOrEmail());
		}else {
			entity.setUsername(dto.getUsernameOrEmail());
		}
		entity.setUsernameOrEmail(dto.getUsernameOrEmail());
		entity.setPassword(dto.getPassword());
		
		return entity;
	}
}
