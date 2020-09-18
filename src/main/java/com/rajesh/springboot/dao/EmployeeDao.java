/**
 * 
 */
package com.rajesh.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.springboot.model.Employee;

/**
 * @author : Rajesh Thokala
 *
 * Date    : Sep 18, 2020 1:00:13 PM
 */
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
