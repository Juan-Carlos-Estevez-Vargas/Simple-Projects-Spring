package com.estevez.system.services;

import java.util.List;

import com.estevez.system.entities.Supplier;

public interface ISupplierService {
	
	List<Supplier> getAll();
	
	Supplier getById(Long id);
	
	void remove(Long id);
	
	void save(Supplier supplier);
	
}
