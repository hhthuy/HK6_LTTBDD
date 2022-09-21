package com.se.springbootcruddemo.dao;

import java.util.List;

import com.se.springbootcruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deteleById(int theId);

}
