package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PHOTOS", catalog = "PCC")
public class PhotosEntity implements Serializable {

	private static final long serialVersionUID = 5102016072010L;

	@Id
	@Column(name = "PHOTOS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long photosId;

	@Column(name = "RESOURCE")
	private String resource;

	@Column(name = "PHOTO_COVER")
	private boolean photoCover;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@JsonIgnore
	private TravelEntity travel;

	public PhotosEntity() {}
	
	public PhotosEntity(String resource, boolean photoCover) {
		this.resource = resource;
		this.photoCover = photoCover;
	}

	public Long getPhotosId() {
		return photosId;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public boolean isPhotoCover() {
		return photoCover;
	}

	public void setPhotoCover(boolean photoCover) {
		this.photoCover = photoCover;
	}

	public TravelEntity getTravel() {
		return travel;
	}

	public void setTravel(TravelEntity travel) {
		this.travel = travel;
	}
}