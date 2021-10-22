package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {
	
	Employee findByReference(String reference);
	
}