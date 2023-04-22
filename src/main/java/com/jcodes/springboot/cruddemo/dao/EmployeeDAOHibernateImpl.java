package com.jcodes.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jcodes.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	//Define fields for Entity Manager
	private EntityManager entityManager;
	
	
	//Set up Constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		//Get the hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		//Create a query
		Query<Employee> theQuery=currentSession.createQuery("from Employee", Employee.class);
		
		//Execute query and get result list
		List<Employee> employees=theQuery.getResultList();
		
		//Return the results
		return employees;
	}

}
