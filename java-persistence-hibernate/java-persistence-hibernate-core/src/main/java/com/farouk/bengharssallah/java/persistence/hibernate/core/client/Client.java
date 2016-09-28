package com.farouk.bengharssallah.java.persistence.hibernate.core.client;

import java.util.ArrayList;

import com.farouk.bengharssallah.java.persistence.hibernate.core.entity.Employee;
import com.farouk.bengharssallah.java.persistence.hibernate.core.service.EmployeeService;

public class Client {
	      
	    public static void main(String[] args) {
			      
	    	            EmployeeService employeeService = new EmployeeService();
	    	            
	    	            
	    	                             // listing all employees
	    	            ArrayList<Employee> list = employeeService.getEmployeeList();
	    	            for(Employee employee : list){
	    	            	                   System.out.println("Employee : {name : " + employee.getName() + ", id : " + employee.getId() + "}" );
	    	                         }
	    	            System.out.println("                                          ");
	    	            System.out.println("---------------------------------------------------------------");
	    	            System.out.println("                                           ");
	    	            
	    	                              
	    	                           // adding an employee  
	    	            Employee employee = new Employee();employee.setId(20);employee.setName("temporary");
	    	            employeeService.addEmployee(employee);
	    	            Employee temporary = employeeService.getEmployeeByID(20);
	    	            if(temporary != null){
                                       System.out.println("Found Employee with name : '" + temporary.getName() + "'");
	                                    }
                        else {
            	                      System.out.println("Employee not found; not stored in data base !!");
                                        }
	    	            
	    	            System.out.println("                                          ");
	    	            System.out.println("*******************************************************");
	    	            System.out.println("                                           ");
	    	            
	    	                        // updating the employee 
	    	            employee.setName("updatedName"); 
	    	            employeeService.updateEmployee(employee);
	    	            temporary = employeeService.getEmployeeByID(20);
	    	            if(temporary != null){
                                      System.out.println("Found Employee with name : '" + temporary.getName() + "'");
	                                    }
                        else {
            	                      System.out.println("Employee not found; not stored in data base !!");
                                        }
	    	            
	    	            System.out.println("                                          ");
	    	            System.out.println("**********************************************************");
	    	            System.out.println("                                           ");
		    	            
	    	                       // removing the employee  
	    	            employeeService.deleteEmployee(employee);
	    	            temporary = employeeService.getEmployeeByID(20);
	    	            if(temporary != null){
	    	                            System.out.println("Found Employee with name : '" + temporary.getName() + "'");
		    	                                    }
	    	            else {
	    	            	            System.out.println("Employee not found; not stored in data base !!");
	    	                                        }
	    	           
	    	            	    	            
		            }
	    
       }