package br.com.pcc.dto;

import java.util.Date;

public class TravelDto {

	private String destination;
	private Date[] days;
	private String[] comments;
	private String[] resources;
	private Boolean isFacebookUser;
	
	public TravelDto() {}
	
	public TravelDto(String destination, Date[] days, String[] comments, String[] resources, Boolean isFacebookUser) {
		super();
		this.destination = destination;
		this.days = days;
		this.comments = comments;
		this.resources = resources;
		this.isFacebookUser = isFacebookUser;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date[] getDays() {
		return days;
	}

	public void setDays(Date[] days) {
		this.days = days;
	}

	public String[] getComments() {
		return comments;
	}

	public void setComments(String[] comments) {
		this.comments = comments;
	}

	public String[] getResources() {
		return resources;
	}

	public void setResources(String[] resources) {
		this.resources = resources;
	}

	public Boolean getIsFacebookUser() {
		return isFacebookUser;
	}

	public void setIsFacebookUser(Boolean isFacebookUser) {
		this.isFacebookUser = isFacebookUser;
	}	
}