package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.test;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeRestControllerTest extends AbstractRestControllerTest {

	
	@Test
	public void shouldReturnFoundALLEmployees() throws Exception {
		   // given
	     Employee employee1 = getEmployee("reference");
	     Employee employee2 = getEmployee("reference");
		  // when
		when(employeeService.employeeList()).thenReturn(Arrays.asList(employee1, employee2));
		// then
		mockMvc.perform(get("/employees").accept(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$",  hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("name")))
				.andExpect(jsonPath("$[0].reference", is("reference")));

	}
	
		
	@Test
	public void shouldReturnFoundEmployee() throws Exception {
		// given
		  Employee employee = getEmployee("reference");
		// when
		  when(employeeService.findByReference("reference")).thenReturn(employee);
		// then
		mockMvc.perform(get("/employee/reference").accept(APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.name", is("name")))
				.andExpect(jsonPath("$.reference", is("reference")));
	}
	
	
	
	
	@Test
	public void shouldReturnAddedEmployee() throws Exception {
		    // given
		   Employee aemployee  = new Employee();
		   aemployee.setName("name");
		   Employee ademployee  = getEmployee();
		   String jsonGivenEmployee = "{\"name\":\"name\"}" ;
		    // when
		  when(employeeService.addEmployee(aemployee)).thenReturn(ademployee);
		   // then
		  mockMvc.perform( MockMvcRequestBuilders
			      .post("/employee")
			      .content(jsonGivenEmployee)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated())
			      .andExpect(jsonPath("$.name", is("name")))
			      .andExpect(jsonPath("$.reference").exists());
	  }
	
	
	
	@Test
	public void shouldReturnEditedEmployee() throws Exception {
		    // given
		  Employee eemployee = getEditedEmployee();
		  String jsonGivenEmployee = "{\"name\":\"nameY\", \"reference\":\"reference\"}" ;
		    // when
		 when(employeeService.editEmployee(eemployee)).thenReturn(eemployee);
		   // then
		 mockMvc.perform( MockMvcRequestBuilders
			      .put("/employee")
			      .content(jsonGivenEmployee)
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.name").value("nameY"));
		
		
	}
	
	
	
	@Test
	public void shouldDeleteEmployee() throws Exception {
		// when
		Mockito.doNothing().when(employeeService).removeEmployee("reference");
		 // then
		mockMvc.perform(MockMvcRequestBuilders.delete("/employee/reference")
		       .contentType(MediaType.APPLICATION_JSON))
		       .andExpect(status().isAccepted());
	  }
	
	
	
	private Employee getEmployee(String reference) {
		Employee employee  = new Employee();
		employee.setId(0);
		employee.setName("name");
		employee.setReference(reference);
		return employee;
	       }
	
	
	private Employee getEmployee() {
		Employee employee  = new Employee();
		employee.setId(0);
		employee.setName("name");
		employee.setReference("reference");
		return employee;
	       }
	
	
	private Employee getEditedEmployee() {
		Employee employee  = new Employee();
		employee.setId(0);
		employee.setName("nameY");
		employee.setReference("reference");
		return employee;
	       }
	
	   
}