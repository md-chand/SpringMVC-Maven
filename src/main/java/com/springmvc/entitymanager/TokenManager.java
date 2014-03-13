package com.springmvc.entitymanager;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.TokenAuthenticationEntity;
import com.springmvc.entity.UserDetailsEntity;

@Repository("tokenManager")
@SuppressWarnings("unchecked")
public class TokenManager extends AbstractManager<TokenAuthenticationEntity>
{
	public TokenManager()
	{
		super(TokenAuthenticationEntity.class);
	}

	public List<TokenAuthenticationEntity> getTokenEntityByToken(String token)
	{
		String hql = "select e from " + type.getName() + " e where e.token = :token";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("token", token);
		return query.getResultList();
	}

	public TokenAuthenticationEntity storeAuthenticationToken(UserDetailsEntity userDetailsEntity, String token)
	{
		String hql = "select e from " + type.getName() + " e where e.userDetailsEntity.userId = :userId";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("userId", userDetailsEntity.getUserId());

		List<TokenAuthenticationEntity> entityList = query.getResultList();
		TokenAuthenticationEntity tokenAuthEntity = null;
		if (entityList.size() > 0)
		{
			tokenAuthEntity = entityList.get(0);
		}
		else
		{
			tokenAuthEntity = new TokenAuthenticationEntity();
			tokenAuthEntity.setUserDetailsEntity(userDetailsEntity);
		}
		tokenAuthEntity.setTokenCreationDate(new Date());
		tokenAuthEntity.setToken(token);
		tokenAuthEntity = merge(tokenAuthEntity);
		return tokenAuthEntity;
	}
}
