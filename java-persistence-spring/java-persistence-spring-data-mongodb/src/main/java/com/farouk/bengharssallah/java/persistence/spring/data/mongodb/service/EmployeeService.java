package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.repository.EmployeeRepository;

@Service
public class EmployeeService  {

	   private EmployeeRepository employeeRepository;
	   
	   public EmployeeService(final EmployeeRepository employeeRepository) {
		   this.employeeRepository  = employeeRepository;
	        }
	   
	   
	   public List<Employee> employeeList() {
		   return employeeRepository.findAll();
	   }
	   
	   public Employee findByReference(String reference) {
		   return employeeRepository.findByReference(reference);
	   }
	   
	   public Employee addEmployee(Employee e) {
		   e.setReference(UUID.randomUUID().toString());
		   return employeeRepository.save(e);
	   }
	   
	   public Employee editEmployee(Employee employee) {
		   Employee e = employeeRepository.findByReference(employee.getReference());
		   e.setName(employee.getName());
		   return employeeRepository.save(e);
	   }
	   
	   public void removeEmployee(String reference) {
		   Employee e = employeeRepository.findByReference(reference);
		   employeeRepository.delete(e);
	   }
	   
	 
}

