package com.estevez.system.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estevez.system.entities.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long>{

}
