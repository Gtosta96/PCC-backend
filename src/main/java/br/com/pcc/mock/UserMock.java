package br.com.pcc.mock;

import br.com.pcc.entity.LoginCredentialsEntity;
import br.com.pcc.entity.UserCredentialsEntity;

/**
 * Classe Utilizada para retornar dados quando não há banco de dados disponivel.
 * @author glhu
 *
 */
public class UserMock {

	public LoginCredentialsEntity getMockLoginCredentialsEntity(){
		UserCredentialsEntity userData = new UserCredentialsEntity("Gabriel", "Tosta", "FIX it", "Masculino");
		LoginCredentialsEntity loginUserData = new LoginCredentialsEntity("Gtosta96", "Gtosta96", "Mesma coisa que o usuário", "gabrieltosta3@gmail.com", true);
		
		userData.setLoginCredentials(loginUserData);
		loginUserData.setUserCredentials(userData);
		
		return loginUserData;
	}
}
