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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRAVELS", catalog = "PCC")
public class TravelEntity implements Serializable {

	private static final long serialVersionUID = 9052016210330L;

	@Id
	@Column(name = "TRAVEL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long travelId;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "RANK")
	private Double rank;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "FACEBOOK_ID")
	@JsonIgnore
	private FacebookUserEntity facebookUser;
	
	@OneToMany(mappedBy = "travel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommentsEntity> comments;
	
	@OneToMany(mappedBy = "travel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PhotosEntity> photos;

	public TravelEntity() {}
	
	public TravelEntity(String destination, Date startDate, Date endDate, Double rank) {
		super();
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rank = rank;
	}

	public Long getTravelId() {
		return travelId;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public FacebookUserEntity getFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(FacebookUserEntity facebookUser) {
		this.facebookUser = facebookUser;
	}

	public List<CommentsEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentsEntity> comments) {
		this.comments = comments;
	}

	public List<PhotosEntity> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PhotosEntity> photos) {
		this.photos = photos;
	}	
}