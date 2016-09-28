package com.farouk.bengharssallah.java.persistence.spring.data.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farouk.bengharssallah.java.persistence.spring.data.entity.Employee;
import com.farouk.bengharssallah.java.persistence.spring.data.repository.EmployeeRepository;
import com.farouk.bengharssallah.java.persistence.spring.data.service.IEmployeeService;

/***
 *  <p> {@link EmployeeService} class, using {@link EmployeeDAO} performs basic operations in {@link Employee} entity stored in database. </p>
 */

      // @Service means the current class is a service class
@Service("employeeService")
public class EmployeeServiceImplementation  implements IEmployeeService {

	  @Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public ArrayList<Employee> getEmployeeList() {
		            return (ArrayList<Employee>) employeeRepository.findAll();
	         }

	@Override
	public Employee getEmployeeByID(int id) {
		            return employeeRepository.findOne(id);
	        }

	@Override
	public void addEmployee(Employee employee) {
		            employeeRepository.save(employee);
	         }
	
	@Override
	public void updateEmployee(Employee employee) {
		           employeeRepository.save(employee);
	         }

	@Override
	public void deleteEmployee(Employee employee) {
		           employeeRepository.delete(employee);
	         }
	
	
	
	public void setEmployeeDAO(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

 }