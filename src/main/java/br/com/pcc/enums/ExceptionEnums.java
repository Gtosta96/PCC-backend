package br.com.pcc.enums;

public enum ExceptionEnums {
	
	INVALID_USER ("Usu�rio n�o encontrado", "O usu�rio n�o foi encontrado no banco de dados");
	
	private String title;
	private String message;
	
	private ExceptionEnums(String title, String message) {
		this.title = title;
		this.message = message;
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