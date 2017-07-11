package com.micmiu.thrift.demo.server;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * blog http://www.micmiu.com
 *
 * @author Michael
 *
 */
@Component
public class HelloWorldImpl implements HelloWorldService.Iface {

	public HelloWorldImpl() {
	}

	@Override
	public String sayHello(String username, Person person) throws TException {
		System.out.println("Thrify server =: " + username);
		return "Hi," + username + " welcome to my blog www.micmiu.com";
	}

}