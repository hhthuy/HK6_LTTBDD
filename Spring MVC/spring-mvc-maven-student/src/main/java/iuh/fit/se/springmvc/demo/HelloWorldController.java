package iuh.fit.se.springmvc.demo;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("hello") //localhost:8080/spring-mvc-maven-student/hello/showForm
public class HelloWorldController {
	//Read HTML Form data
	/**Create controller method to: Show HTML form **/
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";//helloworld-form.jsp
	}
	
	/**C1: Create controller method to: Process HTML form**/
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";//helloworld.jsp
	}
	
	/**C2: Passing Model to Controller**/
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request,Model model) {
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String result = "Yo! "+ theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	/**C3: Read HTML Form data with @RequestParam**/
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Hey My Friend from! "+ theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
}
