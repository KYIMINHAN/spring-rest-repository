package com.kyiminhan.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.kyiminhan.spring")
@SpringBootApplication
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
