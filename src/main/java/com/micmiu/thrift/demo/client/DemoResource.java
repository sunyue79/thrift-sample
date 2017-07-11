package com.micmiu.thrift.demo.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lesports.jersey.AlternateMediaType;
import com.lesports.jersey.annotation.LJSONP;
import com.micmiu.thrift.demo.server.HelloWorldService;
import com.micmiu.thrift.demo.server.Person;

/**
 * trunk.
 *
 * @author sunyue7
 * 
 */
@Component
@Path("/demo")
public class DemoResource {

	private static final Logger LOG = LoggerFactory.getLogger(DemoResource.class);

	//public static final String SERVER_IP = "10.185.30.244";
	public static final String SERVER_IP = "localhost";
	public static final int SERVER_PORT = 8090;
	public static final int TIMEOUT = 30000;

	/**
	 *
	 * @param userName
	 */
	public String startClient(String userName) {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			// TProtocol protocol = new TCompactProtocol(transport);
			// TProtocol protocol = new TJSONProtocol(transport);
			HelloWorldService.Client client = new HelloWorldService.Client(protocol);
			transport.open();
			Person p = new Person();
			p.setId(123L);
			p.setAge(30);
			String result = client.sayHello(userName, p);
			System.out.println("Thrify client result =: " + result);
			return result;
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
		return "";
	}

	@GET
	@LJSONP
	@Produces({ AlternateMediaType.UTF_8_APPLICATION_JSON })
	@Path("/thrift/")
	public String add(@QueryParam("name") String name) {
		return dorpc(name);
	}
	
	public String dorpc(String name) {
		return startClient(name);
	}

}
