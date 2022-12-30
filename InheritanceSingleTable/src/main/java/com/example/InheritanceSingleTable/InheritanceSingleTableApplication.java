package com.example.InheritanceSingleTable;

import com.example.InheritanceSingleTable.controller.ProductController;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.net.URI;

@SpringBootApplication
public class InheritanceSingleTableApplication {

	public static void main(String[] args) throws IOException {

		//SpringApplication.run(InheritanceSingleTableApplication.class, args);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("tryingSingleTable");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		ResourceConfig resourceConfig=new ResourceConfig();
		resourceConfig.register(new ProductController(entityManager));
		resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);
		Application application=resourceConfig;
		String baseUri = "http://localhost:8080/";
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUri), resourceConfig);
		server.start();
	}

}
