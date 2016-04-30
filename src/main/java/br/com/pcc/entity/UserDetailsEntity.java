package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Column(name = "LOGIN_ID")
	private Long loginId;

	@NotEmpty
	@Column(name = "USERNAME")
	private String username;

	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PASSWORD_HINT")
	private String passwordHint;

	@NotEmpty
	@Email
	@Column(name = "EMAIL")
	private String email;

	@NotNull
	@Column(name = "ENABLED")
	private Boolean enabled;
	
	@OneToOne(fetch = FetchType.LAZY) //	(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonBackReference // Annotation para resolver problema: jackson-infinite-recursion
	private UserEntity user;
	
	@Transient
	private String usernameOrEmail;

	// CONSTRUTORES
	public UserDetailsEntity() {}

	public UserDetailsEntity(String username, String password, String passwordHint, String email, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.email = email;
		this.enabled = enabled;
	}

	public Long getLoginId() {
		return loginId;
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
}