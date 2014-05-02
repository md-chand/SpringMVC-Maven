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
@WebService(endpointInterface = "com.springmvc.webservice.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld
{

	@Override
	public String helloWorld(String name)
	{
		return "Hello world form " + name;
	}

	@Override
	public String printWelcomeMessage(String name)
	{
		return "Welcome Mr/Mrs/Ms. " + name;
	}

}
