package com.se.annotation.libs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.se.interfaces.Coach;
import com.se.interfaces.FortuneService;
@Component
public class SwimCoach implements Coach{

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService ;
	public SwimCoach() {
		System.out.println(">> SwimCoach: inside default construtor");
	}
	public String getDailyWorkout() {
		return "Swim 100 meters as a warm up";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@PostConstruct
	private void doMyStartupStuff() {
		System.out.println("Swimcoach: inside method doMyStartupStuf");
	}
	@PreDestroy
	private void doMyCleanupStuff() {
		System.out.println("Swimcoach: inside method doMyCleanupStuff");
	}
	
}
