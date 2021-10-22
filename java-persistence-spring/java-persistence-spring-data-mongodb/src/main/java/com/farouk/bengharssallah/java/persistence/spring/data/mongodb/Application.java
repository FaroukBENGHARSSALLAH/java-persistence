package com.farouk.bengharssallah.java.persistence.spring.data.mongodb;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.repository.EmployeeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner  {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
          }

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Employee e = new Employee();
		e.setId(1);
		e.setReference(UUID.randomUUID().toString());
		e.setName("admin");
		employeeRepository.save(e);
		
		e = new Employee();
		e.setId(2);
		e.setReference(UUID.randomUUID().toString());
		e.setName("user");
		employeeRepository.save(e);
		
	}
	
    }
	
	    
