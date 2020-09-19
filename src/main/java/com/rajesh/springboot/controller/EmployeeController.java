/**
 * 
 */
package com.rajesh.springboot.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.springboot.model.Employee;
import com.rajesh.springboot.service.EmployeeService;

/**
 * @author : Rajesh Thokala
 *
 * Date    : Sep 18, 2020 12:56:27 PM
 */
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	  public Iterable<Employee> getAllEmployees() {
	    return empService.findEmployees();
	  }
	@GetMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	  public Employee getById(@PathVariable(value = "id") Long empId) {
	    return empService.findById(empId);
	  }
	@PostMapping("/employee")
	 @ResponseStatus(HttpStatus.CREATED)
	  public Employee createUser( @RequestBody Employee emp) {
	    return empService.save(emp);
	  }
	@PutMapping("/employee/{id}")
	 @ResponseStatus(HttpStatus.OK)
	public Employee updateUser( @PathVariable(value = "id") Long empId,
              @Valid @RequestBody Employee employeeDetails) {
	    return empService.updateEmployee(empId, employeeDetails);
	  }
	@DeleteMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	  public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long empId) {
	     empService.deleteEmployee(empId);
	     return ResponseEntity.ok().build();
	  }
	
	

}
