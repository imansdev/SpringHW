package com.digi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.digi.app.sources.dao")
@EntityScan("com.digi.app.sources.model")
public class DigiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DigiApplication.class, args);
	}

}
