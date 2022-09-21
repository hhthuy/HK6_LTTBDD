package com.se.spring.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//1
@Configuration
@EnableWebMvc
@ComponentScan("com.se.spring")
public class DemoAppConfig implements WebMvcConfigurer{

}
