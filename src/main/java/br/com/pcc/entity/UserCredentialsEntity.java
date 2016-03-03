package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * UsersCredentials será responsável por mapear a tabela USER_CREDENTIALS no
 * banco de dados e construir objetos com informações pessoais do Usuário.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

@Entity
@Table(name = "USER_CREDENTIALS")
public class UserCredentialsEntity implements Serializable {

	private static final long serialVersionUID = 02032016114140L;

	// PARAMETROS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotEmpty
	@Column(name = "BORN_DATE")
	private String bornDate;

	@NotEmpty
	@Column(name = "GENDER")
	private String gender;

	// CONSTRUTORES
	public UserCredentialsEntity() {
	}

	public UserCredentialsEntity(String firstName, String lastName, String bornDate, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornDate = bornDate;
		this.gender = gender;
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
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

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		UserCredentialsEntity other = (UserCredentialsEntity) obj;
		if (bornDate == null) {
			if (other.bornDate != null)
				return false;
		} else if (!bornDate.equals(other.bornDate))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "UserCredentialsEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bornDate="
				+ bornDate + ", gender=" + gender + "]";
	}
}