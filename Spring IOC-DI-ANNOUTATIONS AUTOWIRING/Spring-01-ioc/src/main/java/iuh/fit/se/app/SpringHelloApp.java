package iuh.fit.se.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;
//--> RUN AS: JAVA APPLICATION
public class SpringHelloApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}
}
