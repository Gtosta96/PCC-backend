package br.com.pcc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACEBOOK_USERS", catalog = "PCC")
public class FacebookUserEntity implements Serializable {

	private static final long serialVersionUID = 9052016210425L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_ID")
	private Long facebookId;
	
	
	private List<TravelEntity> travelsList;

	public FacebookUserEntity() {}

	public FacebookUserEntity(List<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}
	
	public Long getId() {
		return id;
	}

	public List<TravelEntity> getTravelsList() {
		return travelsList;
	}

	public void setTravelsList(List<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}

	
}	