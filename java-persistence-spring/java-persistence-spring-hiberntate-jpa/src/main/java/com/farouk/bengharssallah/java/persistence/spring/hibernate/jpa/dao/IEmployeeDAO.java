package com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.dao;

import java.util.ArrayList;

import com.farouk.bengharssallah.java.persistence.spring.hiberntate.jpa.entity.Employee;

public interface IEmployeeDAO {
	
	       public ArrayList<Employee> findAllEmployee();
		
	       public Employee findEmployee(int id);
	       
	       public void persistEmployee(Employee employee);
	       
	       public void updateEmployee(Employee employee);
	       
	       public void removeEmployee(int idEmployee);

      }