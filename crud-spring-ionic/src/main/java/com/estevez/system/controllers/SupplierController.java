package com.estevez.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estevez.system.entities.Supplier;
import com.estevez.system.services.ISupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	private ISupplierService supplierService;
	
	@GetMapping("/api/suppliers")
	public List<Supplier> getAll() {
		return supplierService.getAll();
	}
	
	@GetMapping("/api/suppliers/{id}")
	public Supplier getById(@PathVariable String id) {
		return supplierService.getById(Long.parseLong(id));
	}
	
	@DeleteMapping("/api/suppliers/{id}")
	public void deleteById(@PathVariable String id) {
		supplierService.remove(Long.parseLong(id));
	}
	
	@PostMapping("/api/suppliers")
	public void save(@RequestBody Supplier supplier) {
		supplierService.save(supplier);
	}

}
