package br.com.pcc.converter;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.pcc.dto.SignUpDto;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;

public final class EntityConverter {

	public static UserDetailsEntity userDetailsDtoToUserDetailsEntity(UserDetailsDto dto) {
		
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
	
	public static UserEntity signUpDtoToUserEntity(SignUpDto dto) {
		
		UserEntity entity = new UserEntity();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setBornDate(dto.getBornDate());
		entity.setGender(dto.getGender());
		
		return entity;
	}
	
	public static UserDetailsEntity signUpDtoToUserDetailsEntity(SignUpDto dto) {
		
		UserDetailsEntity entity = new UserDetailsEntity();
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setPasswordHint(dto.getPasswordHint());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}
}