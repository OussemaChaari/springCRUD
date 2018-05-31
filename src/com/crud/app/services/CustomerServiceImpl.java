package com.crud.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.app.dao.CustomerDAO;
import com.crud.app.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired // We can use this since we have only 1 implementation
	private CustomerDAO customerDAO;
	
	@Override 
	@Transactional //avoid explicitly the statements sessionFactory.beginTransaction /commit() etc...
	public List<Customer> getCustomers(){
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return	customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
	
	
}
