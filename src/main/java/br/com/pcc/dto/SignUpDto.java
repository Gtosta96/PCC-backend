package br.com.pcc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SignUpDto será responsável por transferir dados do usuário no momento do cadastro para manipulações.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

public class SignUpDto implements Serializable {

	private static final long serialVersionUID = 15032016140458L;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
	
	private String passwordHint;

	private String gender;
	
	private Date bornDate;
	
	@NotNull
	private Boolean enabled;
	
	@NotNull
	private Boolean facebookUser;
	
	private Long facebookUserId;
	
	public SignUpDto() {}

	public SignUpDto(String firstName, String lastName, String email, String username, String password,
			String passwordHint, String gender, Date bornDate, Boolean enabled, Boolean facebookUser) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.gender = gender;
		this.bornDate = bornDate;
		this.enabled = enabled;
		this.facebookUser = facebookUser;
	}
	
	public SignUpDto(String firstName, String lastName, String email, String username, String password,
			String passwordHint, String gender, Date bornDate, Boolean enabled, Boolean facebookUser, Long facebookUserId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.gender = gender;
		this.bornDate = bornDate;
		this.enabled = enabled;
		this.facebookUser = facebookUser;
		this.facebookUserId = facebookUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(Boolean facebookUser) {
		this.facebookUser = facebookUser;
	}

	public Long getFacebookUserId() {
		return facebookUserId;
	}

	public void setFacebookUserId(Long facebookUserId) {
		this.facebookUserId = facebookUserId;
	}
}