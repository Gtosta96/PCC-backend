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

//@Entity
//@Table(name = "PHOTOS", catalog = "PCC")
public class PhotosEntity implements Serializable {

//	private static final long serialVersionUID = 5102016072010L;
//
//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(name = "TRAVEL_ID")
//	private Long travelId;
//	
//	@Column(name = "RESOURCE")
//	private String resource;
//
//	@Column(name = "PHOTO_COVER")
//	private boolean photoCover;
//	
//	@ManyToOne
//	@JoinColumn(name = "USER_ID")
//	@JsonIgnore
//	private TravelEntity travel;
}

