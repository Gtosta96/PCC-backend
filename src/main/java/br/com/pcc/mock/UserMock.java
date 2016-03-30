package br.com.pcc.mock;

import br.com.pcc.entity.UserDetailsEntity;
import br.com.pcc.entity.UserEntity;

/**
 * Classe Utilizada para retornar dados quando não há banco de dados disponivel.
 * @author glhu
 *
 */
public class UserMock {

	public UserDetailsEntity getMockLoginCredentialsEntity(){
		UserEntity userData = new UserEntity("Gabriel", "Tosta", "FIX it", "Masculino");
		UserDetailsEntity loginUserData = new UserDetailsEntity("Gtosta96", "Gtosta96", "Mesma coisa que o usuário", "gabrieltosta3@gmail.com", true);
		
		userData.setUserDetails(loginUserData);
		loginUserData.setUser(userData);
		
		return loginUserData;
	}
}
