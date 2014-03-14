package com.springmvc.services;

public interface MailService
{
	/**
	 * This method will send an email containing reset password link with token
	 * to the recipient passed in as input parameter
	 * 
	 * @param recipient
	 *            to whom mail to be sent
	 * @param token
	 *            system generated Token
	 */
	void sendForgotPasswordTokenMail(String recipient, String token);
}
