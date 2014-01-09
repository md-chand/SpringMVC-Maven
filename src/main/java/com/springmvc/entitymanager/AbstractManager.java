package com.springmvc.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractManager<T> 
{
	private final Class<T> type;

	@PersistenceContext
	private EntityManager entityManager;

	public AbstractManager(Class<T> type) 
	{
		this.type = type;
	}

	public T findById(long Id) 
	{
		return entityManager.find(type, Id);
	}

	public T persist(T t) 
	{
		entityManager.persist(t);
		return t;
	}

	public T mergr(T t) 
	{
		entityManager.merge(t);
		return t;
	}

}
