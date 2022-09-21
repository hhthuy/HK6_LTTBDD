package com.se.springboot.demo.app.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
			public String sayHello() {
				return "Time on server is: " + LocalDateTime.now() + LocalDateTime.now() +"lan 2";
	}
}
