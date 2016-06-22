package br.com.pcc.dao.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import br.com.pcc.util.exception.entity.GenericExceptionEntity;

public interface IGenericDao<T, PK extends Serializable> extends Repository<T, PK> {

	public void beginTransaction();

	public void commit();

	public void close();

	public void rollBack();

	public void save(T entity) throws GenericExceptionEntity;
	
	public void update(T entity) throws GenericExceptionEntity;
	
	public void delete(T entity) throws GenericExceptionEntity;
	
	public T findById(PK id) throws GenericExceptionEntity;
	
	public Page<T> findAll(Pageable pageable);
	
	public List<T> listAll() throws GenericExceptionEntity;
}