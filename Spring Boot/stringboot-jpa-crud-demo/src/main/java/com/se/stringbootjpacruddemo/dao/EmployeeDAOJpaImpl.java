package com.se.stringbootjpacruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.stringbootjpacruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	private EntityManager entityManager;

	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Query theQuery = (Query) entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	@Transactional
	public void deteleById(int theId) {
		
		Query<Employee> theQuery = (Query<Employee>) entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theQuery);
		theQuery.executeUpdate();
		
	}
	
	
}
