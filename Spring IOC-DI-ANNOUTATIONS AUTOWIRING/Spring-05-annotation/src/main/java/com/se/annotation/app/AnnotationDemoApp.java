package com.se.annotation.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.se.interfaces.Coach;

public class AnnotationDemoApp {
	public static void main(String[] args) {
	    //read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String coach ="swimCoach";
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();
	
	}
}
