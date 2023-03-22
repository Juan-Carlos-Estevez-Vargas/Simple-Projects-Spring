package com.estevez.system.services;

import java.util.List;

import com.estevez.system.entities.Employee;

public interface IEmployeeService {
	
	List<Employee> getAll();
	
	Employee getById(Long id);
	
	void remove(Long id);
	
	void save(Employee employee);
	
}
