package com.se.stringboothibernatecruddemo.dao;

import java.util.List;

import com.se.stringboothibernatecruddemo.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deteleById(int theId);

}
