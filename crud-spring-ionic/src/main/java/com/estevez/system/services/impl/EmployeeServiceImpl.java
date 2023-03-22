package com.estevez.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estevez.system.entities.Employee;
import com.estevez.system.repositories.IEmployeeRepository;
import com.estevez.system.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void remove(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	

}
