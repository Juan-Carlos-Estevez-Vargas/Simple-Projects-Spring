package com.estevez.system.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estevez.system.entities.Supplier;

@Repository
public interface ISupplierRepository extends CrudRepository<Supplier, Long>{

}
