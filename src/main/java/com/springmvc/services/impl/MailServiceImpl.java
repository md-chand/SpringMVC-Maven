package com.springmvc.services.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.springmvc.services.MailService;

@Service
public class MailServiceImpl implements MailService
{

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	private String RESET_PWD_TOKEN_AUTH_URL = "http://localhost:8080/springmvc/services/application/validateResetPasswordToken?token=";

	@Override
	public void sendMail(final String recipient, final String token)
	{
		MimeMessagePreparator preparator = new MimeMessagePreparator()
		{
			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(recipient);
				message.setSubject("Recovering your Spring MVC application log-in password");
				
				Map<String, String> model = new HashMap<String, String>();				
				String url = RESET_PWD_TOKEN_AUTH_URL + token;				
				model.put("resetPasswordTokenUrl", url);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"/emailtemplates/resetPasswordTokenEmailTemplate.vm", model);
				message.setText(text, true);
			}
		};
		this.mailSender.send(preparator);
	}
}
