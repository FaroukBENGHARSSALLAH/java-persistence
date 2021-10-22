package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.restcontroller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.domain.Employee;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.model.EmployeeDTO;
import com.farouk.bengharssallah.java.persistence.spring.data.mongodb.service.EmployeeService;

@CrossOrigin("*")
@RestController("")
public class RESTController {
	private EmployeeService employeeService;
	private ModelMapper modelMapper;
	
	public RESTController(final EmployeeService employeeService, final ModelMapper modelMapper) {
		       this.employeeService = employeeService;
		       this.modelMapper = modelMapper;
	      }

	@GetMapping(value = "/employees")
	public ResponseEntity<List<EmployeeDTO>> employees() {
		      List<Employee> employees = employeeService.employeeList();
		      if(employees != null && employees.size() > 0) 
		    	  return new ResponseEntity<>(mapAll(employees, EmployeeDTO.class), 
		    		   HttpStatus.OK);
		      else return new ResponseEntity<>(new ArrayList<EmployeeDTO>(),HttpStatus.NOT_FOUND);
	   }
	
	
	@GetMapping(value = "/employee/{reference}")
	public ResponseEntity<EmployeeDTO> employee(@PathVariable String reference) {
		       Employee employee = employeeService.findByReference(reference);
		      if(employee != null) return new ResponseEntity<>(map(employee, EmployeeDTO.class), 
		    		   HttpStatus.OK);
		      else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	
	
	
	@PostMapping(value = "/employee")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
		      Employee aemployee = employeeService.addEmployee(map(employee, Employee.class));
		      if(aemployee != null) return new ResponseEntity<>(map(aemployee, EmployeeDTO.class), 
		    		   HttpStatus.CREATED);
		      else return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	
	
	
	@PutMapping(value = "/employee")
	public ResponseEntity<EmployeeDTO> editEmployee(@RequestBody EmployeeDTO employee) {
		      Employee eemployee = employeeService.editEmployee(map(employee, Employee.class));
		      if(eemployee != null) return new ResponseEntity<>(map(eemployee, EmployeeDTO.class), 
		    		   HttpStatus.OK);
		      else return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	
	
	
	@DeleteMapping(value = "/employee/{reference}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String reference) {
		      employeeService.removeEmployee(reference);
		      return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	    }
	
	
	
	
	   private  <D, T> D map(final T entity, Class<D> outClass) {
	        return modelMapper.map(entity, outClass);
	    }
	
	   private  <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
	        return entityList.stream().map(entity -> map(entity, outCLass))
	                .collect(Collectors.toList());
	    }
	
 }
