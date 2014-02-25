package com.springmvc.services.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.callable.CreateUser;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.services.CallableFutureService;

@Service
public class CallableFutureServiceImpl implements CallableFutureService
{
	@Autowired
	public UserManager userRepository;

	@Override
	@Transactional
	public void createUserExecutor()
	{
		ExecutorService executor = Executors.newFixedThreadPool(1);
		for (int i = 1; i <= 3; i++)
		{
			CreateUser oneSecond = new CreateUser();
			executor.submit(oneSecond);
		}
		executor.shutdown();
	}
}
