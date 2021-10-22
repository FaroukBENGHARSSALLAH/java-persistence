package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.Application;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.repository.EmployeeRepository;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.service.EmployeeService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class EmployeeServiceTest {
	
	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	
	@Test
	public void shouldReturnByReference() {
		  {
		Employee employee = new Employee();
		employee.setId(0);
		employee.setName("name");
		employee.setReference("reference");
		
		Mockito.when(employeeRepository.findByReference("reference")).thenReturn(employee);
	  	  }

		Employee employee  = employeeService.findByReference("reference");
		assertNotNull("Employee shouldn't be null", employee);
		assertThat(employee.getName(), equalTo("name"));
		assertThat(employee.getReference(), equalTo("reference"));
		assertThat(employee.getId(), equalTo(0));
	}
	
	

	
	
	@Test
	public void shouldReturnAll() {
		  {
		Employee employee = new Employee();
		employee.setId(0);
		employee.setName("name");
		employee.setReference("reference");
		Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
	  	  }

		List<Employee> employees  = employeeService.employeeList();
		assertNotNull("Employee List shouldn't be null", employees);
		assertThat(employees.size(), equalTo(1));
		assertThat(employees.get(0).getName(), equalTo("name"));
		assertThat(employees.get(0).getReference(), equalTo("reference"));
		assertThat(employees.get(0).getId(), equalTo(0));
	}
	
	
	
	
	@Test
	public void shouldReturnAddedEmployee() {
		  
		Employee nemployee = new Employee();
		nemployee.setName("name");
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("name");
		employee.setReference("reference");
		
		Mockito.when(employeeRepository.save(nemployee)).thenReturn(employee);
	  	  

		 
		Employee aemployee  = employeeService.addEmployee(nemployee);
		assertNotNull("Employee shouldn't be null", aemployee);
		assertThat(aemployee.getName(), equalTo("name"));
		assertThat(aemployee.getReference(), equalTo("reference"));
		assertThat(aemployee.getId(), equalTo(1));
	}
	
	
	
	@Test
	public void shoulReturnEditeEmployee() {
		  
	    Employee eemployee = new Employee();
	    eemployee.setId(1);
		eemployee.setName("nameY");
		eemployee.setReference("reference");
		
		Mockito.when(employeeRepository.findByReference("reference")).thenReturn(eemployee);
		Mockito.when(employeeRepository.save(eemployee)).thenReturn(eemployee);
	  	  
		Employee employee  = employeeService.editEmployee(eemployee);
		assertNotNull("Employee shouldn't be null", employee);
		assertThat(employee.getName(), equalTo("nameY"));
		assertThat(employee.getReference(), equalTo("reference"));
		assertThat(employee.getId(), equalTo(1));
	}
	
	
	
	
	
	@Test
	public void shouldRemoveEmployee() {
		 
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("name");
		employee.setReference("reference");
		Mockito.when(employeeRepository.findByReference("reference")).thenReturn(employee);
		  
        employeeService.removeEmployee("reference");
        Mockito.verify(employeeRepository, Mockito.times(1)).delete(Mockito.eq(employee));
	}
	
	
	
	@Test
	public void shouldReturnNullForNotExistingEmployee() {
		Employee employee = employeeService.findByReference("reference");
		assertNull(employee);
	}
}
