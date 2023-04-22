package com.jcodes.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcodes.springboot.cruddemo.dao.EmployeeDAO;
import com.jcodes.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeDAO employeeDAO;
	
	
	//Doing constructor injection because EmployeeDAO was not annnotated wiht @Service
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO=theEmployeeDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
	
	
	
}
