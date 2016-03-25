package br.com.pcc.mock;

import br.com.pcc.entity.LoginCredentialsEntity;

/**
 * Classe Utilizada para retornar dados quando não há banco de dados disponivel.
 * @author glhu
 *
 */
public class UserMock {

	public LoginCredentialsEntity getMockLoginCredentialsEntity(){
		return new LoginCredentialsEntity("USER-MOCK", "PASSWORD-MOCK", "PASSWORD-HINT-MOCK", "EMAIL@MOCK.COM", null, true);
	}
}
