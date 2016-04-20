package br.com.pcc.util.enums;

public enum ExceptionEnums {
	
	INVALID_USER ("Usuário não encontrado", "O usuário não foi encontrado no banco de dados"),
	DAO_SAVE_ERROR ("Erro ao salvar", "Não foi possível salvar o registro do banco de dados"),
	DAO_UPDATE_ERROR ("Erro ao atualizar", "Não foi possível atualizar o registro do banco de dados"),
	DAO_DELETE_ERROR ("Erro ao deletar", "Não foi possível deletar o registro do banco de dados");
	
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