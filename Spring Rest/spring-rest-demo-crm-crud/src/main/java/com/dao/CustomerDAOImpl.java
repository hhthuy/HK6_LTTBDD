package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Session currenSession = sessionFactory.getCurrentSession();
		

		Query<Customer> theQuery = currenSession.createQuery("from Customer order by lastName", 
				Customer.class);
		customers = theQuery.getResultList();
		return customers;
	}

	@Transactional
	@Override
	public Customer getCustomers(int id) {
		Session currenSession = sessionFactory.getCurrentSession();
		currenSession.find(Customer.class, id);
		return currenSession.find(Customer.class, id);
	}

	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		Session currenSession = sessionFactory.getCurrentSession();
		currenSession.save(customer);
		return customer;
	}
	@Transactional
	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Session currenSession = sessionFactory.getCurrentSession();
		Customer customerFound = getCustomers(id);
		customerFound.setEmail(customer.getEmail());
		customerFound.setFirstName(customer.getFirstName());
		customerFound.setLastName(customer.getLastName());
		currenSession.saveOrUpdate(customer);
		return customerFound;
	}
	@Transactional
	@Override
	public void deleteCustomer(int id) {
		Session currenSession = sessionFactory.getCurrentSession();
		Customer customerDelete = getCustomers(id);
		currenSession.delete(customerDelete);

	}

}
