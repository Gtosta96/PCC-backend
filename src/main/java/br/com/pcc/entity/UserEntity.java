package br.com.pcc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * UsersCredentialsEntity será responsável por mapear a tabela USER_CREDENTIALS no
 * banco de dados e construir objetos com informações pessoais do Usuário.
 * 
 * @version 1.0.0
 * @since version 1.0.0
 * @author Gabriel Tosta
 */

@Entity
@Table(name = "USERS", catalog = "PCC")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 02032016114140L;

	// PARAMETROS
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserDetailsEntity userDetails;
	
//	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<TravelEntity> travelsList;

	// CONSTRUTORES
	public UserEntity() {}
	
	public UserEntity(String firstName, String lastName, String bornDate, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornDate = bornDate;
		this.gender = gender;
	}

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

	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
	}

//	public List<TravelEntity> getTravelsList() {
//		return travelsList;
//	}
//
//	public void setTravelsList(List<TravelEntity> travelsList) {
//		this.travelsList = travelsList;
//	}	
}