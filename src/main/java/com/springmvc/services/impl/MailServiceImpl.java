package com.springmvc.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.springmvc.common.Constants;
import com.springmvc.services.MailService;

@Service
public class MailServiceImpl implements MailService
{
	
	public MailServiceImpl()
	{
		
	}
	
	public MailServiceImpl(JavaMailSenderImpl mailSender)
	{
		System.out.println("Inside MailServiceImpl Constructor!");
		configMailingDetails(mailSender);
		this.mailSender = mailSender;
	}
	
	private JavaMailSenderImpl mailSender;

	@Autowired
	private VelocityEngine velocityEngine;
	
	private String APP_URL;
	
	public String getAPP_URL()
	{
		return APP_URL;
	}

	public void setAPP_URL(String aPP_URL)
	{
		APP_URL = aPP_URL;
	}

	@Override
	public void sendForgotPasswordTokenMail(final String recipient, final String token)
	{	
		MimeMessagePreparator preparator = new MimeMessagePreparator()
		{
			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(recipient);
				message.setSubject("Recovering your Spring MVC application log-in password");
				
				Map<String, String> model = new HashMap<String, String>();				
				String url = APP_URL + Constants.RESET_PWD_TOKEN_AUTH_URL + token;				
				model.put("resetPasswordTokenUrl", url);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"/emailtemplates/resetPasswordTokenEmailTemplate.vm", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	@Override
	public void sendLoginCredentialsToUser(final String recipient, final String userName, final String password)
	{
		MimeMessagePreparator preparator = new MimeMessagePreparator()
		{
			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(recipient);
				message.setSubject("Recovering your Spring MVC application log-in password");
				
				Map<String, String> model = new HashMap<String, String>();				
				String url = APP_URL + Constants.LOGIN_URL;
				model.put("appURL", url);
				model.put("userName", userName);
				model.put("password", password);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"/emailtemplates/newUserInfoEmailTemplate.vm", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
	
	private void configMailingDetails(JavaMailSenderImpl mailSender)
	{
		//One can read the following details from DAO/property files
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("springmavc@gmail.com");
		mailSender.setPassword("springmvc.123");
		Properties javaMailProperties = new Properties();
			javaMailProperties.setProperty("mail.transport.protocol", "smtp");
			javaMailProperties.setProperty("mail.smtp.auth", "true");
			javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
			javaMailProperties.setProperty("mail.debug", "true");
		mailSender.setJavaMailProperties(javaMailProperties);
	}
}

