package br.com.pcc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * LoginCredentialsDto será responsável por transferir dados no momento de login para manipulações.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

public class LoginCredentialsDto implements Serializable {

	private static final long serialVersionUID = 8032016125043L;
	
	//PARAMETROS
    //@Size(min=5, max=16)
	@NotEmpty
	private String usernameOrEmail;
	
    @NotEmpty
	//@Size(min=6, max=18)
	private String password;

	//CONSTRUTORES
	public LoginCredentialsDto() {}
	
	public LoginCredentialsDto(String email, String password) {
		this.usernameOrEmail = email;
		this.password = password;
	}

	//GETTERS AND SETTERS
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String email) {
		this.usernameOrEmail = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usernameOrEmail == null) ? 0 : usernameOrEmail.hashCode());
		return result;
	}

	//EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginCredentialsDto other = (LoginCredentialsDto) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usernameOrEmail == null) {
			if (other.usernameOrEmail != null)
				return false;
		} else if (!usernameOrEmail.equals(other.usernameOrEmail))
			return false;
		return true;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "LoginCredentialsDto [usernameOrEmail=" + usernameOrEmail + ", password=" + password + "]";
	}	
}