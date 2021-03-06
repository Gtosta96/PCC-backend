package br.com.pcc.converter;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.pcc.dto.SignUpDto;
import br.com.pcc.dto.UserDetailsDto;
import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;

public final class UserConverter {

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
		
		if(dto.getFacebookUser()) {
			entity.setFacebookUser(dto.getFacebookUser());
			entity.setFacebookUserId(dto.getFacebookUserId());
		} else {
			entity.setFacebookUser(false);
		}
		
		return entity;
	}
	
	public static UserDetailsEntity signUpDtoToUserDetailsEntity(SignUpDto dto) {
		
		UserDetailsEntity entity = new UserDetailsEntity();
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setPasswordHint(dto.getPasswordHint());
		entity.setEmail(dto.getEmail());
		entity.setEnabled(dto.getEnabled());
		
		if(entity.getUsername() == null && entity.getPassword() == null) {
			entity.setFacebookUser(true);
			entity.setEnabled(true);
		}
		
		return entity;
	}
	
public static UserDetailsEntity signUpDtoUpdateUserDetails(SignUpDto dto, UserDetailsEntity userDetails) {
		
		userDetails.setUsername(dto.getUsername());
		userDetails.setPassword(dto.getPassword());
		userDetails.setPasswordHint(dto.getPasswordHint());
				
		return userDetails;
	}
}