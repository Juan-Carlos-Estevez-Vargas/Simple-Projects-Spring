package com.estevez.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estevez.system.entities.Customer;
import com.estevez.system.repositories.ICustomerRepository;
import com.estevez.system.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void remove(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	

}
