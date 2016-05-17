package br.com.pcc.dao.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.pcc.util.enums.ExceptionEnums;
import br.com.pcc.util.exception.entity.GenericExceptionEntity;

//@Repository
public class GenericDao<T, PK> implements IGenericDao<T, PK> {

	protected final EntityManager entityManager;
	protected final EntityManagerFactory factory;
	protected Class<T> persistentClass;

	// CONSTRUTORES
	public GenericDao() {
		this(DaoFactory.entityManagerFactoryInstance());
	}

	@SuppressWarnings("unchecked")
	public GenericDao(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void beginTransaction() {
		this.entityManager.getTransaction().begin();
	};

	@Override
	public void commit() {
		this.entityManager.getTransaction().commit();
	};

	@Override
	public void close() {
		this.entityManager.close();
		this.factory.close();
	};

	@Override
	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	};

	@Override
	public void save(T entity) throws GenericExceptionEntity {
		try {
			this.beginTransaction();
			this.entityManager.persist(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_SAVE_ERROR);
		}
	};

	@Override
	public void update(T entity) throws GenericExceptionEntity {
		try {
			this.beginTransaction();
			this.entityManager.merge(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_UPDATE_ERROR);
		}
	};
	
	@Override
	public void delete(T entity) throws GenericExceptionEntity {
		try {
			this.beginTransaction();
			this.entityManager.remove(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw new GenericExceptionEntity(ExceptionEnums.DAO_DELETE_ERROR);
		}
	};

	@Override
	public T findById(PK id) throws GenericExceptionEntity {
		return (T) this.entityManager.find(this.persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() throws GenericExceptionEntity {
		return this.entityManager.createQuery(("FROM " + this.persistentClass.getName())).getResultList();			
	}
}