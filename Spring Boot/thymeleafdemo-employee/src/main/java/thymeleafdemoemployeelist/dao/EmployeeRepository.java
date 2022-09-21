package thymeleafdemoemployeelist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import thymeleafdemoemployeelist.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
