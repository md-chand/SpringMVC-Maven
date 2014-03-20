package com.springmvc.entitymanager;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.model.UserLogin;

@Repository("authManager")
@SuppressWarnings("unchecked")
public class AuthManager extends AbstractManager<UserDetailsEntity>
{
	public AuthManager()
	{
		super(UserDetailsEntity.class);
	}

	public List<UserDetailsEntity> validateUser(String userName, String password)
	{
		String hql = "select e from " + type.getName() + " e where e.userName = :userName and password = :password";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return query.getResultList();
	}
}
