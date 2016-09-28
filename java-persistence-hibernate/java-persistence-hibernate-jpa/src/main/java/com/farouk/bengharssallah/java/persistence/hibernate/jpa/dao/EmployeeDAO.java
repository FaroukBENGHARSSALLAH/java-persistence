package com.farouk.bengharssallah.java.persistence.hibernate.jpa.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.farouk.bengharssallah.java.persistence.hibernate.jpa.entity.Employee;
import com.farouk.bengharssallah.java.persistence.hibernate.jpa.session.JPASession;

		/***
		 *  <p> {@link EmployeeDAO} class contains database basic APIs to add, update and remove {@link Employee} entity in database. </p>
		 */

public class EmployeeDAO {
	
	

	       private EntityManager entityManager = JPASession.getEntityManager();

	       
		public ArrayList<Employee> findAllEmployee(){
			                           ArrayList<Employee> list = new ArrayList<>();
						               try{  
						            	               
						            	                Query query = entityManager.createQuery("select e from Employee e");
						      		                    list = (ArrayList<Employee>) query.getResultList();
						            	                                      }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						               return list;
                                }
		
	       
	       
	       public Employee findEmployee(int id){
	    	                           Employee employee = null;
						               try{  
						            	        employee = (Employee) entityManager.find(Employee.class, id);
						                                        }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						               return employee;
                                 }
	       
	       
	       
	       
	       public void persistEmployee(Employee employee){
							    	    try{  
							    	    	        if(!entityManager.getTransaction().isActive()){
							    	    	                            entityManager.getTransaction().begin();
							    	    	                          }
									    	    	entityManager.persist(employee);
									    	    	entityManager.getTransaction().commit();
						                                    }
						           catch(Exception e){
						          	                e.printStackTrace();
						                                    }
                               }
	       
	  
	       
	       public void removeEmployee(Employee employee){
					               try{  
								            	   if(!entityManager.getTransaction().isActive()){
			   	    	                                                entityManager.getTransaction().begin();
			   	    	                                               }
								            	   entityManager.remove(employee);
								            	   entityManager.getTransaction().commit();
					                                        }
					               catch(Exception e){
					              	       e.printStackTrace();
					                                        }
					             }
	       
	 
             }