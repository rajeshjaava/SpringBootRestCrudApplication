/**
 * 
 */
package com.rajesh.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import com.rajesh.springboot.dao.EmployeeDao;
import com.rajesh.springboot.exception.ResourceNotFoundException;
import com.rajesh.springboot.model.Employee;

/**
 * @author : Rajesh Thokala
 *
 * Date    : Sep 18, 2020 12:57:54 PM
 */
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	public Employee save(Employee e) {
		return empDao.save(e);
	}
	
	public Iterable<Employee> findEmployees(){
		return empDao.findAll();
	}
	public Employee findById(Long id) {
		 return empDao.findById(id)  
				 .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}
	
	public Employee updateEmployee(Long id,Employee emp) {
		
		Employee updEmp = empDao.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		updEmp.setName(emp.getName());
		updEmp.setSalary(emp.getSalary());
		updEmp.setAddress(emp.getAddress());

		    Employee updatedEmp = empDao.save(updEmp);
		    return updatedEmp;
	}
public void deleteEmployee(Long id) {
		
		 empDao.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		     empDao.deleteById(id);
		     
	}
		  
	
}
