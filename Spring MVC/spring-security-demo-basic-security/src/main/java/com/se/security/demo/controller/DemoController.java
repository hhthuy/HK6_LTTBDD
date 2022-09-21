package com.se.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//5.mapping khi chuong trinh chay se goi toi phuong thuc showHome() tra ve form home.jsp
@Controller
public class DemoController {
	@GetMapping("/")
	public String showHome() {
		return "home";

	}
}
