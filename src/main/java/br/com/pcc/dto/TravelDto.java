package br.com.pcc.dto;

import java.util.Date;

public class TravelDto {

	private String destination;
	private Date[] days;
	private String[] comments;
	private String[] resources;
	
	public TravelDto() {}

	public TravelDto(String destination, Date[] days, String[] comments, String[] resources) {
		super();
		this.destination = destination;
		this.days = days;
		this.comments = comments;
		this.resources = resources;
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
}