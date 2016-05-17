package br.com.pcc.dto;

import java.io.Serializable;

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

	@NotEmpty
	private String gender;
	
	@NotEmpty
	private Long bornDate;
	
	public SignUpDto() {}
	
	public SignUpDto(String firstName, String lastName, String email, String username, String password,
			String passwordHint, String gender, Long bornDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordHint = passwordHint;
		this.gender = gender;
		this.bornDate = bornDate;
	}

	//GETTERS SETTERS
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

	public Long getBornDate() {
		return bornDate;
	}

	public void setBornDate(Long bornDate) {
		this.bornDate = bornDate;
	}

	//HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordHint == null) ? 0 : passwordHint.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		SignUpDto other = (SignUpDto) obj;
		if (bornDate == null) {
			if (other.bornDate != null)
				return false;
		} else if (!bornDate.equals(other.bornDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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

	//TOSTRING
	@Override
	public String toString() {
		return "SignUpDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username="
				+ username + ", password=" + password + ", passwordHint=" + passwordHint + ", gender=" + gender
				+ ", bornDate=" + bornDate + "]";
	}
}