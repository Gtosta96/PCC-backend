package br.com.pcc.entity;

import java.util.Date;

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
//@Table(name = "COMMENTS", catalog = "PCC")
public class CommentsEntity {

//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(name = "TRAVEL_ID")
//	private Long travelId;
//	
//	@Column(name = "COMMENT")
//	private String comment;
//	
//	@Column(name = "DATE")
//	private Date date;
//	
//	@ManyToOne
//	@JoinColumn(name = "USER_ID")
//	@JsonIgnore
//	private TravelEntity travel;
}