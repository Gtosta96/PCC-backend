package br.com.pcc.util.exception.entity;

import br.com.pcc.util.enums.ExceptionEnums;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 8032016135725L;
	
	private String title;
	private String message;

	public GenericException() {}
	
	public GenericException(ExceptionEnums exceptionEnums) {
		this.title = exceptionEnums.getTitle();
		this.message = exceptionEnums.getMessage();
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