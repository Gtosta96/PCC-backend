package br.com.pcc.util.exception.entity;

import br.com.pcc.util.enums.ExceptionEnums;

public class GenericExceptionEntity extends RuntimeException {

	private static final long serialVersionUID = 8032016135725L;
	
	private int httpStatus;
	private String title;
	private String message;

	public GenericExceptionEntity() {}
	
	public GenericExceptionEntity(ExceptionEnums exceptionEnums) {
		this.httpStatus = exceptionEnums.getHttpStatus();
		this.title = exceptionEnums.getTitle();
		this.message = exceptionEnums.getMessage();
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}