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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FACEBOOK_USER", catalog = "PCC")
public class FacebookUserEntity implements Serializable {

	private static final long serialVersionUID = 9052016210425L;
	
	@Id
	@Column(name = "FACEBOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "FACEBOOK_USER_ID", unique = true)
	private Long facebookId;
	
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
	
	@OneToMany(mappedBy = "facebookUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TravelEntity> travelsList;

	public FacebookUserEntity() {}

	public FacebookUserEntity(Long facebookId, String firstName, String lastName, Date bornDate, String gender) {
		super();
		this.facebookId = facebookId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bornDate = bornDate;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
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

	public List<TravelEntity> getTravelsList() {
		return travelsList;
	}

	public void setTravelsList(List<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}
}