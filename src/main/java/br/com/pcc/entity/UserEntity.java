package br.com.pcc.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BORN_DATE")
	@Temporal(TemporalType.DATE)
	private Date bornDate;

	@Column(name = "GENDER")
	private String gender;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserDetailsEntity userDetails;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TravelEntity> travelsList;
	
	@NotNull
	@Column(name = "FACEBOOK_USER")
	private Boolean facebookUser;
	
	@Column(name = "FACEBOOK_USER_ID")
	private Long facebookUserId;

	// CONSTRUTORES
	public UserEntity() {}
	
	public UserEntity(String firstName, String lastName, Date bornDate, String gender, Boolean facebookUser) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornDate = bornDate;
		this.gender = gender;
		this.facebookUser = facebookUser;
	}

	public UserEntity(String firstName, String lastName, Date bornDate, String gender, Boolean facebookUser, Long facebookUserId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornDate = bornDate;
		this.gender = gender;
		this.facebookUser = facebookUser;
		this.facebookUserId = facebookUserId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
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

	public List<TravelEntity> getTravelsList() {
		return travelsList;
	}

	public void setTravelsList(List<TravelEntity> travelsList) {
		this.travelsList = travelsList;
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