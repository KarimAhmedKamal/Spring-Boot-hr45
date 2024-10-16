package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;

@Component
@Qualifier("employeeJDBCRepo")
public class EmployeeJDBCRepo implements EmployeeReps{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return 	jdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
//		return jdbcTemplate.queryForObject("select id, name, salary from employee where id=?", new Object[] {id},
//				(resultSet, rowNum)-> new Employee(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("salary")));
		return jdbcTemplate.queryForObject("select id, name, salary from employee where id=?", new Object[] {id}, new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select id, name, salary from employee", new EmployeeMapper());
	}

	@Override
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into employee (name, salary) values (?, ?)", new Object[] {employee.getName(), employee.getSalary()});
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update employee set name = ?, salary = ?", new Object[] {employee.getName(), employee.getSalary()});
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from employee where id = ?", new Object[] {id});
	}

	@Override
	public List<Employee> findByNameAndSalary(String name, Double salary) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
