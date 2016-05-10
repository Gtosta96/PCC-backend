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

@Entity
@Table(name = "TRAVELS", catalog = "PCC")
public class TravelEntity implements Serializable {

	private static final long serialVersionUID = 9052016210330L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CommentsEntity> comments;
	
	@OneToMany(mappedBy = "resource", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PhotosEntity> photos;
	
	@Column(name = "RANK")
	private Double rank;
	
	public TravelEntity() {}
}