package br.com.pcc.dao.util;

import java.util.List;

import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public interface IGenericDao<T, PK> {

	public void beginTransaction();

	public void commit();

	public void close();

	public void rollBack();

	public void save(T entity) throws GenericExceptionEntity;
	
	public void update(T entity) throws GenericExceptionEntity;
	
	public void delete(T entity) throws GenericExceptionEntity;
	
	public T findById(PK id) throws GenericExceptionEntity;
	
	List<T> listAll() throws GenericExceptionEntity;
}