package com.se.springbootcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.springbootcruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	private EntityManager entityManager;

	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currSession.createQuery("from Empolyee", Employee.class);
		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deteleById(int theId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
