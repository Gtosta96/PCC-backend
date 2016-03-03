package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * LoginCredentials será responsável por mapear a tabela LOGIN_CREDENTIALS no banco de
 * dados e construir objetos com informações de login do Usuário.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

@Entity
@Table(name = "LOGIN_CREDENTIALS")
public class LoginCredentialsEntity implements Serializable {

	private static final long serialVersionUID = 22022016080210L;

	// PARAMETROS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotEmpty
	@Column(name = "USERNAME")
	private String username;

	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "PASSWORD_HINT")
	private String passwordHint;

	@NotEmpty
	@Column(name = "EMAIL")
	private String email;

	@NotEmpty
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_CREDENTIALS", referencedColumnName = "ID")
	@Column(name = "CREDENTIALS_ID")
	private UserCredentialsEntity credentials;

	@NotNull
	@Column(name = "ENABLED")
	private Boolean enabled;

	// CONSTRUTORES
	public LoginCredentialsEntity() {
	}

	public LoginCredentialsEntity(String username, String password, String passwordHint, String email,
			UserCredentialsEntity credentials, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.email = email;
		this.credentials = credentials;
		this.enabled = enabled;
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
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

	public UserCredentialsEntity getCredentials() {
		return credentials;
	}

	public void setCredentials(UserCredentialsEntity credentials) {
		this.credentials = credentials;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	// HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordHint == null) ? 0 : passwordHint.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	// EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginCredentialsEntity other = (LoginCredentialsEntity) obj;
		if (credentials == null) {
			if (other.credentials != null)
				return false;
		} else if (!credentials.equals(other.credentials))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordHint == null) {
			if (other.passwordHint != null)
				return false;
		} else if (!passwordHint.equals(other.passwordHint))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "LoginCredentialsEntity [id=" + id + ", username=" + username + ", password=" + password
				+ ", passwordHint=" + passwordHint + ", email=" + email + ", credentials=" + credentials + ", enabled="
				+ enabled + "]";
	}
}