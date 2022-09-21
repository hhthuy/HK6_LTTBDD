package iuh.fit.se.springmvc.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")//http://localhost:8080/spring-mvc-maven-student/student/showForm
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("The Student: " + theStudent.getFirstName()+" "+ theStudent.getLastName());	
		return "student-confirmation";
	}
	

}
