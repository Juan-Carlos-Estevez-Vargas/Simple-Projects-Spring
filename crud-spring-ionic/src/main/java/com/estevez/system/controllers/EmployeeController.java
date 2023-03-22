package com.estevez.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estevez.system.entities.Employee;
import com.estevez.system.services.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/api/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/api/employees/{id}")
	public Employee getById(@PathVariable String id) {
		return employeeService.getById(Long.parseLong(id));
	}
	
	@DeleteMapping("/api/employees/{id}")
	public void deleteById(@PathVariable String id) {
		employeeService.remove(Long.parseLong(id));
	}
	
	@PostMapping("/api/employees")
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
	}

}
