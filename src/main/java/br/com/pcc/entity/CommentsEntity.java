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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "COMMENTS", catalog = "PCC")
public class CommentsEntity {

	@Id
	@Column(name = "COMMENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentsId;

	@Column(name = "COMMENT")
	private String comment;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "TRAVEL_ID")
	@JsonIgnore
	private TravelEntity travel;

	public CommentsEntity() {}
	
	public CommentsEntity(String comment, Date date) {
		this.comment = comment;
		this.date = date;
	}

	public Long getCommentsId() {
		return commentsId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TravelEntity getTravel() {
		return travel;
	}

	public void setTravel(TravelEntity travel) {
		this.travel = travel;
	}
}