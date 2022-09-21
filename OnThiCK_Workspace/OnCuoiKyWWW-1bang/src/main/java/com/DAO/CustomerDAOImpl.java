package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer findCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String queryStr = "select * from Customer where id = " + id;
		Query<Customer> query = session.createNativeQuery(queryStr, Customer.class);
		Customer customer = query.getResultStream().findFirst().orElse(null);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
	}

}
