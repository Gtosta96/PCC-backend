package br.com.pcc.dto;

public class TravellerDto {

	private Long id;
	private Boolean isLoggedFromFacebook;
	
	public TravellerDto() {}
	
	public TravellerDto(Long id, Boolean isLoggedFromFacebook) {
		this.id = id;
		this.isLoggedFromFacebook = isLoggedFromFacebook;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsLoggedFromFacebook() {
		return isLoggedFromFacebook;
	}
}