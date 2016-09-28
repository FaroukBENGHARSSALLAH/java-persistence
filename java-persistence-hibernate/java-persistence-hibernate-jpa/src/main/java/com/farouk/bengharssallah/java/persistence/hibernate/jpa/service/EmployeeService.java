package com.farouk.bengharssallah.java.persistence.hibernate.jpa.service;

import java.util.ArrayList;

import com.farouk.bengharssallah.java.persistence.hibernate.jpa.dao.EmployeeDAO;
import com.farouk.bengharssallah.java.persistence.hibernate.jpa.entity.Employee;


		/***
		 *  <p> {@link EmployeeService} class, using {@link EmployeeDAO} performs basic operations in {@link Employee} entity stored in database. </p>
		 */

public class EmployeeService {
	
	              

	       
	       private EmployeeDAO employeeDAO = new EmployeeDAO();
	       
	       
	                    	       	       
		public ArrayList<Employee> getEmployeeList(){
			                           ArrayList<Employee> list = new ArrayList<>();
						               list = employeeDAO.findAllEmployee();
						               return list;
                                }
		
		
	       
	       public Employee getEmployeeByID(int id){
	    	                           Employee employee = null;
						               employee = employeeDAO.findEmployee(id);
						               return employee;
                                 }
	       
	       
	       
	       public void addEmployee(Employee employee){
						               employeeDAO.persistEmployee(employee);
                               }
	       
	       
	       
	       
	       public void updateEmployee(Employee employee){
						               employeeDAO.persistEmployee(employee);
                                 }
	       
	       
	       
	       
	       
	       public void deleteEmployee(Employee employee){
						               employeeDAO.removeEmployee(employee);
					             }

             }