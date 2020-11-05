package com.app.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.module.common")
@EnableJpaRepositories("com.module.common")
@EntityScan("com.module.common")
public class AppCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCommonApplication.class, args);
	}

}
