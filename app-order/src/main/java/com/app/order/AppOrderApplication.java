package com.app.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.module.order", "com.app.order"})
@EnableCaching
public class AppOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppOrderApplication.class, args);
	}

}
