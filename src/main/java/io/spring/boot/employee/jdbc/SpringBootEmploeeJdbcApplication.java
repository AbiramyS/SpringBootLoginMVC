package io.spring.boot.employee.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringBootEmploeeJdbcApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(SpringBootEmploeeJdbcApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmploeeJdbcApplication.class, args);
		LOGGER.error("Message logged at error level");
		LOGGER.warn("Message logged at warn level");
		LOGGER.info("Message logged at info level");
		LOGGER.debug("Message logged at debug level");
		
	
	}

}
