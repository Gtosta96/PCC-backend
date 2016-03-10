package br.com.pcc.exception.model;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 8032016135725L;
	
	private String errorTitle;
	private String errorMsg;
	
	public GenericException() {}

	public GenericException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}	
	public String getErrorTitle() {
		return errorTitle;
	}
	public void setErrorTitle(String errorTitle) {
		this.errorTitle = errorTitle;
	}
}