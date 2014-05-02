package com.springmvc.webservice.soap;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher
{

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		Endpoint ep = Endpoint.publish("http://localhost:1212/ws/HelloWorld", new HelloWorldImpl());
		HelloWorldClient client = new HelloWorldClient();
		client.callHelloWorldService();
		ep.stop();
	}

}
