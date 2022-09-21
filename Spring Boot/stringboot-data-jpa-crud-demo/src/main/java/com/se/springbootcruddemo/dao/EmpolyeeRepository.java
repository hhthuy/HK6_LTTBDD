package com.se.springbootcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//@RepositoryRestResource(path="members")
import com.se.springbootcruddemo.entity.Employee;

public interface EmpolyeeRepository extends JpaRepository<Employee, Integer>{
	//Spring Data Rest: Employee ---> employees (co s)
}
