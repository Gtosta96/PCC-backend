package br.com.pcc.dao.util;

import java.util.List;

public interface IGenericDao<T, PK> {

	public void beginTransaction();

	public void commit();

	public void close();

	public void rollBack();

	public void save(T entity) throws Exception;
	
	public void update(T entity) throws Exception;
	
	public void delete(T entity) throws Exception;
	
	public T findById(PK id) throws Exception;
	
	public T findByUsernameOrEmail(T entity) throws Exception;
	
	List<T> listAll() throws Exception;
}