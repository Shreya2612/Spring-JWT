package com.example.springjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})//bypasses the Spring default basic authentication.

@SpringBootApplication
public class SpringJwtApplication {


	public static void main(String[] args) { SpringApplication.run(SpringJwtApplication.class, args);
	}

}
