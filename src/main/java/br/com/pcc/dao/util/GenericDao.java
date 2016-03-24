package br.com.pcc.dao.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T, PK> implements IGenericDao<T, PK> {

	private final EntityManager entityManager;
	private final EntityManagerFactory factory;
	private Class<T> persistentClass;

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
	public void save(T entity) throws Exception{
		try {
			this.beginTransaction();
			this.entityManager.persist(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	};

	@Override
	public void update(T entity) throws Exception {
		try {
			this.beginTransaction();
			this.entityManager.merge(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	};
	
	@Override
	public void delete(T entity) throws Exception {
		try {
			this.beginTransaction();
			this.entityManager.remove(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	};

	@Override
	public T findById(PK id) throws Exception {
		try {
			return (T) this.entityManager.find(this.persistentClass, id);
		} catch (Exception e){
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() throws Exception {
		try {
			return this.entityManager.createQuery(("FROM " + this.persistentClass.getName())).getResultList();			
		} catch (Exception e){
			throw e;
		}
	};
}