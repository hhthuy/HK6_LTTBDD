package com.se.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Step 2: Develop a Controller to show the custom login form

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	private String showMyLoginPage() {
		return "plain-login";

	}
}
