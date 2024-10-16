package com.global.hr.repository;

import java.util.List;

import com.global.hr.model.Employee;

public interface EmployeeReps {
	int count ();
	Employee findById (Long id);
	
	List<Employee> findAll ();
	
	int insert(Employee employee);

	int update(Employee employee);

	int delete(Long id);
	
	public List<Employee> findByNameAndSalary(String name, Double salary);
}
