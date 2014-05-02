/**
 * 
 */
package com.springmvc.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author mpasha
 * 
 */

@WebService
public interface HelloWorld
{
	@WebMethod
	public String helloWorld(String string);
	
	@WebMethod
	public String printWelcomeMessage(String string);
}
