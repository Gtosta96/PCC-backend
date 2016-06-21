package br.com.pcc.util.enums;

public enum ExceptionEnums {
	
	//https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP
	INVALID_USER (400, "Usuário não encontrado", "O usuário não foi encontrado no banco de dados"),
	DAO_GET_ERROR (500, "Erro ao buscar dados", "Não foi possível encontrar dados no banco de dados"),
	DAO_SAVE_ERROR (500, "Erro ao salvar", "Não foi possível salvar o registro do banco de dados"),
	DAO_UPDATE_ERROR (500, "Erro ao atualizar", "Não foi possível atualizar o registro do banco de dados"),
	DAO_DELETE_ERROR (500, "Erro ao deletar", "Não foi possível deletar o registro do banco de dados");
	
	private int httpStatus;
	private String title;
	private String message;
	
	private ExceptionEnums(int httpStatus, String title, String message) {
		this.httpStatus = httpStatus;
		this.title = title;
		this.message = message;
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