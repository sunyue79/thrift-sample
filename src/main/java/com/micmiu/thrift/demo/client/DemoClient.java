package com.micmiu.thrift.demo.client;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import com.micmiu.thrift.demo.client.JerseyConfig;

/**
 *
 */
@Configuration
//@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.micmiu.thrift.demo.client", "com.micmiu.thrift.demo.common" })
//@EnableLoadTimeWeaving
public class DemoClient {

	private static final Logger LOG = LoggerFactory.getLogger(DemoClient.class);

	private static int port = 8080;

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(DemoClient.class, args);
		LOG.info("INFO: App application launched at " + port);
		LOG.debug("DEBUG: App application launched at " + port);
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();
		container.setPort(port);
		container.setContextPath("/app");
		return container;
	}
	
	/*@Bean
    public EmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        JettyEmbeddedServletContainerFactory container = new JettyEmbeddedServletContainerFactory();
		container.setPort(port);
		container.setContextPath("/app");
        return container;
    }*/

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
		return registration;
	}
}
