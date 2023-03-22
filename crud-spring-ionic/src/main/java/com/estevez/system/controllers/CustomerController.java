package com.estevez.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estevez.system.entities.Customer;
import com.estevez.system.services.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/api/customers")
	public List<Customer> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/api/customers/{id}")
	public Customer getById(@PathVariable String id) {
		return customerService.getById(Long.parseLong(id));
	}
	
	@DeleteMapping("/api/customers/{id}")
	public void deleteById(@PathVariable String id) {
		customerService.remove(Long.parseLong(id));
	}
	
	@PostMapping("/api/customers")
	public void save(@RequestBody Customer customer) {
		customerService.save(customer);
	}

}
