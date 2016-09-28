package com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.dao.IEmployeeDAO;
import com.farouk.bengharssallah.java.persistence.spring.hibernate.jpa.service.IEmployeeService;
import com.farouk.bengharssallah.java.persistence.spring.hiberntate.jpa.entity.Employee;

/***
 *  <p> {@link EmployeeService} class, using {@link EmployeeDAO} performs basic operations in {@link Employee} entity stored in database. </p>
 */

      // @Service means the current class is a service class
@Service("employeeService")
public class EmployeeServiceImplementation  implements IEmployeeService {

	  @Autowired
	private IEmployeeDAO employeeDAO;
	
	

	@Override
	public ArrayList<Employee> getEmployeeList() {
		            return employeeDAO.findAllEmployee();
	         }

	@Override
	public Employee getEmployeeByID(int id) {
		            return employeeDAO.findEmployee(id);
	        }

	@Override
	public void addEmployee(Employee employee) {
		            employeeDAO.persistEmployee(employee);
	         }
	
	@Override
	public void updateEmployee(Employee employee) {
		            employeeDAO.updateEmployee(employee);
	         }

	@Override
	public void deleteEmployee(int idEmployee) {
		             employeeDAO.removeEmployee(idEmployee);
	        }
	
	
	
	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

 }