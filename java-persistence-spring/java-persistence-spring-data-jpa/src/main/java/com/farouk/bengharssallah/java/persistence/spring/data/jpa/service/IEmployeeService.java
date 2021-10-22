package com.farouk.bengharssallah.java.persistence.spring.data.jpa.service;

import java.util.ArrayList;

import com.farouk.bengharssallah.java.persistence.spring.data.entity.Employee;

public interface IEmployeeService {
	
			public ArrayList<Employee> getEmployeeList();
			
		    public Employee getEmployeeByID(int id);
		    
		    public void addEmployee(Employee employee);
		    
		    public void updateEmployee(Employee employee);
		    
		    public void deleteEmployee(Employee employee); 

   }