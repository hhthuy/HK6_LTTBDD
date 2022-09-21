package com.se.springdatarestcrud;

import org.springframework.boot.SpringApplication;
//http://localhost:8080/magic-api/employees?page=0
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/employees
//http://localhost:8080/magic-api/employees?page=0
@SpringBootApplication
public class SpringDataRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestCrudApplication.class, args);
	}
}
