package com.se.springdatarestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource(path="members")
import com.se.springdatarestcrud.entity.Employee;

public interface EmpolyeeRepository extends JpaRepository<Employee, Integer>{
	//Spring Data Rest: Employee ---> employees (co s)
}
