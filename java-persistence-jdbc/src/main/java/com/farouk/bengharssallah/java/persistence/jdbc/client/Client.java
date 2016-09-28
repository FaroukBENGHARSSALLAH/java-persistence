package com.farouk.bengharssallah.java.persistence.jdbc.client;

import java.util.LinkedList;

import com.farouk.bengharssallah.java.persistence.jdbc.administrator.DBAdministrator;
import com.farouk.bengharssallah.java.persistence.jdbc.entity.Employee;

public class Client {
	      
	    public static void main(String[] args) {
			      
	    	            DBAdministrator administrator = new DBAdministrator();
	    	            
	    	                            // starting the connection
	    	            administrator.startConnection();
	    	            
	    	                             // listing all employees
	    	            LinkedList<Employee> list = administrator.getEmployeeList();
	    	            for(Employee employee : list){
	    	            	                   System.out.println("Employee : {name : " + employee.getName() + ", id : " + employee.getId() + "}" );
	    	                         }
	    	            System.out.println("                                          ");
	    	            System.out.println("---------------------------------------------------------------");
	    	            System.out.println("                                           ");
	    	            
	    	                              
	    	                           // adding an employee  
	    	            Employee employee = new Employee();employee.setId(20);employee.setName("temporary");
	    	            administrator.addEmployee(employee);
	    	            Employee temporary = administrator.getEmployeeByID(20);
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
	    	            administrator.updateEmployee(employee);
	    	            temporary = administrator.getEmployeeByID(20);
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
	    	            administrator.deleteEmployee(employee);
	    	            temporary = administrator.getEmployeeByID(20);
	    	            if(temporary != null){
	    	                            System.out.println("Found Employee with name : '" + temporary.getName() + "'");
		    	                                    }
	    	            else {
	    	            	            System.out.println("Employee not found; not stored in data base !!");
	    	                                        }
	    	            
	    	                    // closing the connection
	    	            administrator.closeConnection();
	    	            
		            }
	    
       }