package com.estevez.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estevez.system.entities.Supplier;
import com.estevez.system.repositories.ISupplierRepository;
import com.estevez.system.services.ISupplierService;

@Service
public class SupplierServiceImpl implements ISupplierService{
	
	@Autowired
	private ISupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAll() {
		return (List<Supplier>) supplierRepository.findAll();
	}

	@Override
	public Supplier getById(Long id) {
		return supplierRepository.findById(id).get();
	}

	@Override
	public void remove(Long id) {
		supplierRepository.deleteById(id);
	}

	@Override
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	

}
