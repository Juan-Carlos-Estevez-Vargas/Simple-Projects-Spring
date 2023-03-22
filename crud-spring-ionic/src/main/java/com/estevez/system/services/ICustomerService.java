package com.estevez.system.services;

import java.util.List;

import com.estevez.system.entities.Customer;

public interface ICustomerService {
	
	List<Customer> getAll();
	
	Customer getById(Long id);
	
	void remove(Long id);
	
	void save(Customer customer);
	
}
