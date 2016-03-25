package br.com.pcc.converter;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.pcc.dto.LoginCredentialsDto;
import br.com.pcc.entity.LoginCredentialsEntity;

public class EntityConverter {

	public LoginCredentialsEntity loginCredentialsDtoToLoginCredentialsEntity(LoginCredentialsDto dto) {
		
		LoginCredentialsEntity entity = new LoginCredentialsEntity();
		boolean isEmail = EmailValidator.getInstance().isValid(dto.getUsernameOrEmail());
		
		if (isEmail) {
			entity.setEmail(dto.getUsernameOrEmail());
		}else {
			entity.setUsername(dto.getUsernameOrEmail());
		}
		entity.setPassword(dto.getPassword());
		
		return entity;
	}
}
