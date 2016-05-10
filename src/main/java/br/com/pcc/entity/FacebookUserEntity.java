package br.com.pcc.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class FacebookUserEntity implements Serializable {

	private static final long serialVersionUID = 9052016210425L;
	
	private Long id;
	private ArrayList<TravelEntity> travelsList;

	public FacebookUserEntity() {}

	public FacebookUserEntity(ArrayList<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}
	
	public Long getId() {
		return id;
	}

	public ArrayList<TravelEntity> getTravelsList() {
		return travelsList;
	}

	public void setTravelsList(ArrayList<TravelEntity> travelsList) {
		this.travelsList = travelsList;
	}

	
}	