package com.farouk.bengharssallah.java.persistence.jdbc.administrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.farouk.bengharssallah.java.persistence.jdbc.entity.Employee;

public class DBAdministrator {
	
	              /***
	               *    JDBC; Java DataBase Connectivity is a native API used to access
	               *     to relational data base, widely used by JPA implementation, ORM Framework
	               *     like Hibernate.
	               */
	
	
	                // MySQL data base URL  --  jdbc:mysql://[host1][:port1][,/[database]]
	       private final static String dbURL = "jdbc:mysql://[host1][:port1][,/[database]]";
	                      // MySQL data base username
	       private final static String dbUser = "";
	                     // MySQL data base password
	       private final static String dbPassword = "";
	                     // MySQL data base driver used as a JAVA API to connect the data base
	       private final static String dbDriver = "com.mysql.jdbc.Driver";
	       
	       private Connection connection;
	       
	       
	                      
	       public void startConnection(){
	    	                 try{  
	    	                	        // associating the driver class to the JDBC API
	    		                     Class.forName(dbDriver); 
	    		                           // starting a connection object used to create SQL queries
	    		                     connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);  
	                                                  }
	    	                 catch(Exception e){
	    	                	       e.printStackTrace();
	    	                                          }
	    	                  }
	       
	       
	       
	       public LinkedList<Employee> getEmployeeList(){
	    	                           LinkedList<Employee> list = new LinkedList<>();
						               try{  
						            	    
						            	        Statement statement = connection.createStatement(); 
						            	                    // executing a SQL query
						            	        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE"); 
						            	        while(resultSet.next()){
						            	        	            Employee employee = new Employee();
						            	        	            employee.setId(resultSet.getInt(1));
						            	        	            employee.setName(resultSet.getString(2));
						            	        	            list.add(employee);
						            	                                      }
						                                        }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						               return list;
                                }
	       
	       
	       
	       public Employee getEmployeeByID(int id){
	    	                           Employee employee = null;
						               try{  
						            	    
						            	        Statement statement = connection.createStatement();  
						            	        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE ID = '" + id + "'"); 
						            	        while(resultSet.next()){
						            	        	            employee = new Employee();
						            	        	            employee.setId(resultSet.getInt(1));
						            	        	            employee.setName(resultSet.getString(2));
						            	                                      }
						                                        }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						               return employee;
                                 }
	       
	       
	       
	       
	       public void addEmployee(Employee employee){
							    	    try{  
						        	        Statement statement = connection.createStatement();  
						        	        statement.executeUpdate("INSERT INTO EMPLOYEE(`ID`, `NAME`) VALUES ('" + employee.getId() + "', '" + employee.getName() + "')");
						        	        statement.executeUpdate("COMMIT");
						                                    }
						           catch(Exception e){
						          	       e.printStackTrace();
						                                    }
                               }
	       
	       
	       public void updateEmployee(Employee employee){
						               try{  
						            	        Statement statement = connection.createStatement();  
						            	        statement.executeUpdate("UPDATE EMPLOYEE SET `NAME`='" + employee.getName() + "' WHERE `ID`='" + employee.getId() + "'");
						            	        statement.executeUpdate("COMMIT");
						                                        }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
                                 }
	       
	       
	       public void deleteEmployee(Employee employee){
					               try{  
					            	        Statement statement = connection.createStatement();  
					            	        statement.executeUpdate("DELETE FROM EMPLOYEE WHERE `ID`='" + employee.getId() + "'");
					            	        statement.executeUpdate("COMMIT");
					                                        }
					               catch(Exception e){
					              	       e.printStackTrace();
					                                        }
					             }
	       
	       
	       public void closeConnection(){
					    	   try{  
					    		               // closing the data base connection 
						                   connection.close();
				                                    }
				              catch(Exception e){
				          	               e.printStackTrace();
				                                    }
                               }

             }
