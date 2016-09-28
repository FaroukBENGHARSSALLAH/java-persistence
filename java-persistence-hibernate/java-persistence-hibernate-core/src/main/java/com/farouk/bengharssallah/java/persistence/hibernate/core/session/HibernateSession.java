package com.farouk.bengharssallah.java.persistence.hibernate.core.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.farouk.bengharssallah.java.persistence.hibernate.core.dao.EmployeeDAO;

		/***
		 *  <p> {@link HibernateSession} generate {@link SessionFactory } used by {@link EmployeeDAO} to build a {@link Session}. </p>
		 */

public class HibernateSession {

	  
        private static SessionFactory sessionFactory;

                static {

                            try {
                                       sessionFactory = new Configuration().configure("basic/hibernate.cfg.xml").buildSessionFactory();
                                                      }
                             catch (Throwable ex) {
                                          throw new ExceptionInInitializerError(ex); 
                                                      }
                                 }
                
                 public static SessionFactory getSessionFactory() {
                              return sessionFactory;
                                            }

                 public static void close() {
                              getSessionFactory().close();
                                            }
                 
      }