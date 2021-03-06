package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * LoginCredentialsEntity será responsável por mapear a tabela LOGIN_CREDENTIALS no banco de
 * dados e construir objetos com informações de login do Usuário.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

@Entity
@Table(name = "USER_DETAILS", catalog = "PCC")
public class UserDetailsEntity implements Serializable {

	private static final long serialVersionUID = 22022016080210L;

	// PARAMETROS
	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_DETAILS_ID")
	private Long userDetailsId;

	@Column(name = "USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PASSWORD_HINT")
	private String passwordHint;

	@Email
	@Column(name = "EMAIL", unique = true)
	private String email;

	@NotNull
	@Column(name = "ENABLED")
	private Boolean enabled;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	private UserEntity user;
	
	@Transient
	private String usernameOrEmail;
	
	@Column(name = "FACEBOOK_USER")
	private Boolean facebookUser;

	// CONSTRUTORES
	public UserDetailsEntity() {}

	public UserDetailsEntity(String username, String password, String passwordHint, String email, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.email = email;
		this.enabled = enabled;
	}

	public Long getUserDetailsId() {
		return userDetailsId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity userCredentials) {
		this.user = userCredentials;
	}

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public Boolean getFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(Boolean facebookUser) {
		this.facebookUser = facebookUser;
	}
}