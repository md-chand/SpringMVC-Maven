package com.springmvc.services;

public interface MailService
{
	/**
	 * This method will send an e-mail containing reset password link with token
	 * to the recipient passed in as input parameter
	 * 
	 * @param recipient
	 *            to whom mail to be sent
	 * @param token
	 *            system generated Token
	 */
	void sendForgotPasswordTokenMail(String recipient, String token);

	/**
	 * This method will send an e-mail to the newly created user which contains
	 * user name and password
	 * 
	 * @param recipient
	 *            to whom e-mail has to be sent
	 * @param userName
	 *            login user name
	 * @param password
	 *            login password
	 */
	void sendLoginCredentialsToUser(String recipient, String userName, String password);
}
