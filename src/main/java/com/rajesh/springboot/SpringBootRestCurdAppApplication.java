package com.rajesh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRestCurdAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCurdAppApplication.class, args);
	}

}
