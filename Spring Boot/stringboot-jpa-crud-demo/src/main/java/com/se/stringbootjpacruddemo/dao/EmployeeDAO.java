package com.se.stringbootjpacruddemo.dao;

import java.util.List;

import com.se.stringbootjpacruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deteleById(int theId);

}
