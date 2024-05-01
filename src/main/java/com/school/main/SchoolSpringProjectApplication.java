package com.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration
@EnableCaching
@ComponentScan({ "com.school" })
@EnableJpaRepositories(basePackages = "com.school")
@EntityScan(basePackages = "com.school")
@SpringBootApplication
public class SchoolSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSpringProjectApplication.class, args);
	}

}
