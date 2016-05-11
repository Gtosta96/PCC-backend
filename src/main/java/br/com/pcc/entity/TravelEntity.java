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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRAVEL", catalog = "PCC")
public class TravelEntity implements Serializable {

	private static final long serialVersionUID = 9052016210330L;

	@Id
	@Column(name = "TRAVEL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long travelId;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "START_DATE")
	private String startDate;
	
	@Column(name = "END_DATE")
	private String endDate;
	
	@Column(name = "RANK")
	private Double rank;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	private UserEntity user;
	
	@OneToMany(mappedBy = "travel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommentsEntity> comments;
	
	@OneToMany(mappedBy = "travel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PhotosEntity> photos;

	public TravelEntity() {}
	
	public TravelEntity(String destination, String startDate, String endDate, Double rank) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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