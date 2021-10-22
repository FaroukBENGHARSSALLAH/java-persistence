package com.farouk.bengharssallah.java.persistence.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farouk.bengharssallah.java.persistence.spring.data.entity.Employee;

	/***
	 *  <p> {@link EmployeeRepository} interface contains database basic APIs to add, update and remove {@link Employee} entity in database. </p>
	 */

    //JpaRepository contains predefined generic DAO APIs to connect to the database
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

             }
