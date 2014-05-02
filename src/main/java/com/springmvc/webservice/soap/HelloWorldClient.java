package com.springmvc.webservice.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloWorldClient
{

	/**
	 * @throws MalformedURLException 
	 */
	public void callHelloWorldService() throws MalformedURLException
	{
		URL url = new URL("http://localhost:1212/ws/HelloWorld?wsdl");
		QName qname = new QName("http://soap.webservice.springmvc.com/", "HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloWorld helloWorld = service.getPort(HelloWorld.class);
		System.out.println(helloWorld.helloWorld("Mohammed"));
		System.out.println(helloWorld.printWelcomeMessage("Mohammed"));
	}

}
