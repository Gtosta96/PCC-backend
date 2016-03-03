package br.com.pcc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/** Users será responsável por mapear a tabela USERS no banco de dados e construir objetos com informações do Usuário.
 *  @version 1.0.0
 *  @since version 1.0.0
 *  @author Gabriel Tosta
 */

@Entity
@Table (name="USER_CREDENTIALS")
public class UserCredentialsEntity implements Serializable {

	private static final long serialVersionUID = 02032016114140L;

	//PARAMETROS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private Long id;
	
	@NotEmpty
	@Column (name = "FIRST_NAME")
	private String firstName;
	
	@NotEmpty
	@Column (name = "LAST_NAME")
	private String lastName;
	
	@NotEmpty
	@Column (name = "BORN_DATE")
	private String bornDate;
	
	@NotEmpty
	@Column (name = "GENDER")
	private String gender;
	
	
	// CONSTRUTORES
	public UserCredentialsEntity(){}

	//TODO: TERMINAR DE IMPLEMENTAR
}