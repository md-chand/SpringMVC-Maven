package com.springmvc.entitymanager;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.model.UserLogin;

@Repository("userManager")
@SuppressWarnings("unchecked")
public class UserManager extends AbstractManager<UserDetailsEntity>
{
	public UserManager()
	{
		super(UserDetailsEntity.class);
	}

	public List<UserDetailsEntity> getUserByUserName(String userName)
	{
		String hql = "select e from " + type.getName() + " e where e.userName = :userName";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("userName", userName);
		return query.getResultList();
	}

	public List<UserDetailsEntity> getUserByEmail(String email)
	{
		String hql = "select e from " + type.getName() + " e where e.email = :email";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("email", email);
		return query.getResultList();
	}
}
