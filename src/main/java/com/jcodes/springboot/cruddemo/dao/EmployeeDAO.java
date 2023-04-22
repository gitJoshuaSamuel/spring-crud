package com.jcodes.springboot.cruddemo.dao;

import java.util.List;

import com.jcodes.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
