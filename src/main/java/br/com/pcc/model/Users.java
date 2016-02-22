package br.com.pcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Model class Users who will login on application
 *  @version 1.0.0
 *  @since version 1.0.0
 *  @author Gabriel
 */

@Entity
@Table (name="USERS")
public class Users implements Serializable{

	private static final long serialVersionUID = 22022016080210L;

	//PARAMETERS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private int id;
	
	@Column (name = "USERNAME")
	private String username;
	
	@Column (name = "PASSWORD")
	private String password;
	
	@Column (name = "EMAIL")
	private String email;
	
	@Column (name = "PASSWORD_HINT")
	private String passwordHint;
	
	@Column (name = "ENABLED")
	private Boolean enabled;
	
	// CONSTRUCTORS
	public Users(){}

	public Users(int id, String username, String password, String email, String passwordHint, Boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.passwordHint = passwordHint;
		this.enabled = enabled;
	}

	//GETTERS AND SETTERS
	public int getId() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	//HASHCODE METHOD
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordHint == null) ? 0 : passwordHint.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	//EQUALS METHOD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
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
		if (id != other.id)
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

	//TOSTRING METHOD
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", passwordHint=" + passwordHint + ", enabled=" + enabled + "]";
	}
}