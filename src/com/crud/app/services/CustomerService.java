package com.crud.app.services;

import java.util.List;

import com.crud.app.entities.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
