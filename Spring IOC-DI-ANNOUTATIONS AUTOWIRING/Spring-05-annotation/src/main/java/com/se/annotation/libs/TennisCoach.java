package com.se.annotation.libs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.se.interfaces.Coach;
import com.se.interfaces.FortuneService;
@Component
public class TennisCoach implements Coach{
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService ;
	public TennisCoach() {
		System.out.println(">> tennisCoach: inside default construtor");
	}
	
	public String getDailyWorkout() {
		return "Practice your backhand volley ";
	}
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	@PostConstruct
	private void doMyStartupStuff() {
		System.out.println("tennisCoach: inside method doMyStartupStuf");
	}
	@PreDestroy
	private void doMyCleanupStuff() {
		System.out.println("tennisCoach: inside method doMyCleanupStuff");
	}
	
}
