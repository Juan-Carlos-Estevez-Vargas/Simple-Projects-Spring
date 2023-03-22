package com.estevez.system.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estevez.system.entities.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

}
