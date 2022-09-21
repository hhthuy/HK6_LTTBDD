package com.se.annotation.libs;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.se.interfaces.FortuneService;
@Component
public class RandomFortuneService implements FortuneService{
	private String[] data = {"Beware","Diligence","The journey"};

	private Random myRandom = new Random();
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}
	
}
