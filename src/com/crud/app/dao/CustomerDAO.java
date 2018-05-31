package com.crud.app.dao;

import java.util.List;

import com.crud.app.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
	
}
