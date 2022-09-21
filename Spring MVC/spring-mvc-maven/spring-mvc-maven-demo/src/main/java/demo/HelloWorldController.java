package demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	@RequestMapping("/process-form")
	public String processForm() {
		return "process-form";
	}
	@RequestMapping("processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		String  result = "Yo! "+theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
}
