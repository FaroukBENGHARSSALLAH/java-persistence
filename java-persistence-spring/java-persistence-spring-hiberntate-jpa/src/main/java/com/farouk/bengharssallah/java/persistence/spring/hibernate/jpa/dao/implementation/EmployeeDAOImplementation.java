package com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.dao.implementation;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.dao.IEmployeeDAO;
import com.farouk.bengharssallah.java.persistence.spring.hiberntate.jpa.entity.Employee;

/***
 *  <p> {@link employeeDAO} class contains database basic APIs to add, update and remove {@link Employee} entity in database. </p>
 */

        // @Repository means the current class is a DAO Class
@Repository("employeeDAO")
public class EmployeeDAOImplementation implements  IEmployeeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public ArrayList<Employee> findAllEmployee() {
		     Query query = entityManager.createQuery("select e from Employee e");
		     return (ArrayList<Employee>) query.getResultList();
	}
	
	// @Transactional means the method is associated to a transaction database feature
	@Transactional
	@Override
	public Employee findEmployee(int id) {
		               return entityManager.find(Employee.class, id);
	         }
	@Transactional
	@Override
	public void persistEmployee(Employee employee) {
		                  entityManager.persist(employee);
	        }
	
	@Transactional
	@Override
	public void updateEmployee(Employee employee) {
		                  entityManager.merge(employee);
	        }
	
	@Transactional
	@Override
	public void removeEmployee(int idEmployee) {
		                Employee employee = findEmployee(idEmployee);
		                entityManager.remove(employee);
	          }
	
     }