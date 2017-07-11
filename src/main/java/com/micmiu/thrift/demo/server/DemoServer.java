package com.micmiu.thrift.demo.server;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 *
 */
@Configuration
//@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.lesports", "com.micmiu.thrift.demo.server", "com.micmiu.thrift.demo.common" })
//@EnableLoadTimeWeaving
public class DemoServer {

	private static final Logger LOG = LoggerFactory.getLogger(DemoServer.class);
	
	public static int port = 8081;

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(DemoServer.class, args);
		LOG.info("INFO: App application launched: " + port);
		LOG.debug("DEBUG: App application launched: " + port);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();
		container.setPort(port);
		//container.setContextPath("/s");
		return container;
	}

	/*@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}*/
}
