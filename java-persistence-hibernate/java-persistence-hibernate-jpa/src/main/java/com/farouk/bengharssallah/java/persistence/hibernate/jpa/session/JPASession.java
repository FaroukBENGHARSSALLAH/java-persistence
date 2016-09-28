package com.farouk.bengharssallah.java.persistence.hibernate.jpa.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


		/***
		 *  <p> {@link JPASession} generate {@link EntityManager } used by {@link EmployeeDAO}. </p>
		 */
public class JPASession {

	     /**  persistence unit name described in persistence.xml **/
	 private static final String PERSISTENCE_UNIT = "EMPLOYEE_PERSISTANCE_UNIT";
	 
	        /**  EntityManagerFactory instance used to generate an {@link EntityManager}  **/
     private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	 
           /**  EntityManager instance  **/
     private static EntityManager entityManager = null;

     
             /**  this method generate a single {@link EntityManager} 
              * @return {@link EntityManager}
              *  
              ***/
     public static EntityManager getEntityManager(){
    	                  if(entityManager == null){
    	                                 entityManager = entityManagerFactory.createEntityManager();
    	                                }
			              return entityManager;
                       }
     
         }