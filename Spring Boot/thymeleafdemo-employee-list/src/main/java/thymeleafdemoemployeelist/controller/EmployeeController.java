package thymeleafdemoemployeelist.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thymeleafdemoemployeelist.entity.Employee;
import thymeleafdemoemployeelist.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

//	private List<Employee> theEmployees;
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

//	
//	@PostConstruct
//	private void loadData() {
//		Employee emp1 = new Employee(1, "Thuy", "Ho", "hohongthuy001@gmail.com");
//		Employee emp2 = new Employee(2, "Thanh", "Ho", "hohuyenthanh002@gmail.com");
//		Employee emp3 = new Employee(3, "Chung", "Ho", "hominhchung003@gmail.com");
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//	}
//	@GetMapping("/list")
//	public String listEmployees(Model theModel) {
//		theModel.addAttribute("employees", theEmployees);
//		return "list-employees";
//	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deteleById(theId);
		return null;
	}
}
