package br.com.pcc.dto;

import java.util.Date;

public class TravelDto {

	private String[] comments;
	private Date[] days;
	private String destination;
	private String[] photoResource;
	
	public TravelDto() {}

	public TravelDto(String[] comments, Date[] days, String destination, String[] photoResource) {
		super();
		this.comments = comments;
		this.days = days;
		this.destination = destination;
		this.photoResource = photoResource;
	}

	public String[] getComments() {
		return comments;
	}

	public Date[] getDays() {
		return days;
	}

	public String getDestination() {
		return destination;
	}

	public String[] getPhotoResource() {
		return photoResource;
	}
}