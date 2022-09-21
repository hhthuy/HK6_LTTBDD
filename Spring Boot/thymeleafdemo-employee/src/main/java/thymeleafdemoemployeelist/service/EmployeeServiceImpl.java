package thymeleafdemoemployeelist.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import thymeleafdemoemployeelist.dao.EmployeeRepository;
import thymeleafdemoemployeelist.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmpolyeeRepository) {
		employeeRepository = theEmpolyeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		
	}

	@Override
	public void deteleById(int theId) {
		
	}

}