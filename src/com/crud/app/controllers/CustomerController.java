package com.crud.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.app.entities.Customer;
import com.crud.app.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Customer service Injection
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list") // this method responds only to GET requests
	public String listCustomers(Model model) {
		//get the customers using the Customer Service
		List<Customer> customers= customerService.getCustomers();
		
		//add the customers list to the model (so we can use it in the jsp file)
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer= new Customer();
		//bind the data
		model.addAttribute("customer",customer);
		return "customer-add";
	}
	
	@PostMapping("/handleCustomer")
	public String processCustomer(@ModelAttribute("customer") Customer customer) {
		//save the customer
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer",customer);
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	
}
