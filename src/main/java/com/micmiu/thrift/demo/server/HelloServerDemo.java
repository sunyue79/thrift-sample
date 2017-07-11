package com.micmiu.thrift.demo.server;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.springframework.stereotype.Component;

/**
 * blog http://www.micmiu.com
 *
 * @author Michael
 *
 */
@Component
public class HelloServerDemo {
	
	public static final int SERVER_PORT = 8090;

	@Resource
	HelloWorldService.Iface impl;
	
	@PostConstruct
	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");

			TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(impl);
			// HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;
			// tprocessor =
			// new HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;(
			// new HelloWorldImpl());

			// 简单的单线程服务模型，一般用于测试
			TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// tArgs.protocolFactory(new TCompactProtocol.Factory());
			// tArgs.protocolFactory(new TJSONProtocol.Factory());
			TServer server = new TSimpleServer(tArgs);
			server.serve();

		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		HelloServerDemo server = new HelloServerDemo();
		server.startServer();
	}*/

}