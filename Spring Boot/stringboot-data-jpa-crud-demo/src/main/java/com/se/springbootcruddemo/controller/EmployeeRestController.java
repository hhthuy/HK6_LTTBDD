package com.se.springbootcruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.springbootcruddemo.dao.EmployeeDAO;
import com.se.springbootcruddemo.entity.Employee;

// http://localhost:8080/api/employees
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	};

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	// add mapping for GET/employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeDAO.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return theEmployee;
	}

	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeDAO.save(theEmployee);
		return theEmployee;
	}
	
	//add mapping for PUT /employee - update existing empolyess
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeDAO.save(theEmployee);
		return theEmployee;
	}
	
	
	//add mapping for DELETE /employee/{employeeId} - delete empolyess
		@DeleteMapping("/employees/{employeeId}")
		public String dateleEmployee(@PathVariable int employeeId) {
			Employee tempEmployee = employeeDAO.findById(employeeId);
			if (tempEmployee == null) {
				throw new RuntimeException("Employee id not found - " + employeeId);
			}
			employeeDAO.deteleById(employeeId);
			return "Delete employee id: " + employeeId;
		}
		
}
