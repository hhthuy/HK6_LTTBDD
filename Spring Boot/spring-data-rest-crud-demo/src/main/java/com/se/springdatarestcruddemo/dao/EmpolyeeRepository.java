package com.se.springdatarestcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.springdatarestcruddemo.entity.Employee;

public interface EmpolyeeRepository extends JpaRepository<Employee, Integer>{
//JpaRepository<Employee, Integer>:Entity:Employee, Primary key:Integer 
}
