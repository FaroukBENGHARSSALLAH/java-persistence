package com.farouk.bengharssallah.java.persistence.hibernate.core.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.farouk.bengharssallah.java.persistence.hibernate.core.entity.Employee;
import com.farouk.bengharssallah.java.persistence.hibernate.core.session.HibernateSession;



		/***
		 *  <p> {@link EmployeeDAO} class contains database basic APIs to add, update and remove {@link Employee} entity in database. </p>
		 */

public class EmployeeDAO {
	

	       
	       private Session session;

	       
		public ArrayList<Employee> findAllEmployee(){
			                           ArrayList<Employee> list = new ArrayList<>();
						               try{  
						            	               session = HibernateSession.getSessionFactory().openSession();
						            	               list = (ArrayList<Employee>) session.createCriteria(Employee.class).list();
						            	               session.close();
						            	                                      }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						           	  
						               return list;
                                  }
		
		
	       
	       
	       
	       public Employee findEmployee(int id){
	    	                           Employee employee = null;
						               try{  
						            	        session = HibernateSession.getSessionFactory().openSession();
						            	        employee = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("id", new Integer(id))).uniqueResult();
						            	        session.close();
						                                        }
						               catch(Exception e){
						              	       e.printStackTrace();
						                                        }
						               return employee;
                                 }
	       
	       
	       
	       
	       
	       
	       public void persistEmployee(Employee employee){
							    	    try{  
							    	    	        session = HibernateSession.getSessionFactory().openSession();
									    	    	Transaction transaction = session.beginTransaction();
									    	    	session.saveOrUpdate(employee);
									    	    	transaction.commit();
									    	    	session.close();
						                                    }
						           catch(Exception e){
						          	               e.printStackTrace();
						                                    }
                               }
	       
	  
	       
	       public void removeEmployee(Employee employee){
					               try{  
					            	                session = HibernateSession.getSessionFactory().openSession();
						    	    	            Transaction transaction = session.beginTransaction();
								            	    session.delete(employee);
									    	    	transaction.commit();
									    	    	session.close();
					                                        }
					               catch(Exception e){
					              	       e.printStackTrace();
					                                        }
					             }

             }