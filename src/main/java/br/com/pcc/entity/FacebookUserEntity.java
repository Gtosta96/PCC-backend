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
import javax.persistence.Table;

@Entity
@Table(name = "FACEBOOK_USER", catalog = "PCC")
public class FacebookUserEntity implements Serializable {

	private static final long serialVersionUID = 9052016210425L;
	
	@Id
	@Column(name = "FACEBOOK_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FACEBOOK_USER_ID")
	private Long facebookId;
	
	@OneToMany(mappedBy = "facebookUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TravelEntity> travelsList;

	public FacebookUserEntity() {}
	
	public FacebookUserEntity(Long facebookId, List<TravelEntity> travelsList) {
		this.facebookId = facebookId;
		this.travelsList = travelsList;
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

	public List<TravelEntity> getTravelsList() {
		return travelsList;
	}

	public void setTravelsList(List<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}
}	