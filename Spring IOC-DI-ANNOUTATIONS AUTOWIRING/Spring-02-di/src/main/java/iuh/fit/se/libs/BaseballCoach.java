package iuh.fit.se.libs;

public class BaseballCoach implements Coach{
	private FortuneService fortuneService;
	
	
	public BaseballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";	
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
