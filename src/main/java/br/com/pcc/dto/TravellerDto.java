package br.com.pcc.dto;

import java.util.Date;

public class TravellerDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Date bornDate;
	private Boolean isFacebookUser;
	
	public TravellerDto() {}

	public TravellerDto(Long id, String firstName, String lastName, String email, Date bornDate,
			Boolean isFacebookUser) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bornDate = bornDate;
		this.isFacebookUser = isFacebookUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Boolean getIsFacebookUser() {
		return isFacebookUser;
	}

	public void setIsFacebookUser(Boolean isFacebookUser) {
		this.isFacebookUser = isFacebookUser;
	}
}