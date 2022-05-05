package com.bootcamp.bootcoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.logging.Logger;

@EnableEurekaClient
@SpringBootApplication
public class BootcoinApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(BootcoinApplication.class.toString());

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	@Autowired
	private Environment env;


	@Override
	public void run(String... args) throws Exception {

		mongoTemplate.dropCollection("enterpriseactiveloan").subscribe();

		//logger.log(Level.INFO, env.getProperty("spring.application.name"));
		logger.info("Java version: " + env.getProperty("java.version"));
		logger.info("Application name: " + env.getProperty("spring.application.name"));
		logger.info("Properties file upload status: " + env.getProperty("my-own-app.properties.status"));
		logger.info("Swagger: http://localhost:" + env.getProperty("server.port") +"/" + env.getProperty("springdoc.swagger-ui.path"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BootcoinApplication.class, args);
	}

}
