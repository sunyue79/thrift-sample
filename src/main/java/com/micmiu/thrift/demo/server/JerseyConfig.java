/**
 * 
 */
package com.micmiu.thrift.demo.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author sunyue7
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("com.micmiu.thrift.demo");
	}

}
