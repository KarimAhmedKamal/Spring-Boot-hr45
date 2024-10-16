package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;

@Component
@Qualifier("employeeNamedParameterJDBCRepo")
public class EmployeeNamedParameterJDBCRepo implements EmployeeReps{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public int count() {
//		return 	namedParameterJdbcTemplate.queryForObject("select count(*) from employee", Integer.class);
		return 0;
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
//		return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id=?", new Object[] {id},
//				(resultSet, rowNum)-> new Employee(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("salary")));
		return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id = :id", new MapSqlParameterSource("id", id), new EmployeeMapper());
	}
	
	@Override
	public List<Employee> findByNameAndSalary(String name, Double salary) {
		// TODO Auto-generated method stub
//		return namedParameterJdbcTemplate.queryForObject("select id, name, salary from employee where id=?", new Object[] {id},
//				(resultSet, rowNum)-> new Employee(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("salary")));
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("name", name);
		mapSqlParameterSource.addValue("salary", salary);
		
		return namedParameterJdbcTemplate.query("select id, name, salary from employee where name = :name and salary = :salary", mapSqlParameterSource, new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
//		return namedParameterJdbcTemplate.query("select id, name, salary from employee", new EmployeeMapper());
		return null;
	}

	@Override
	public int insert(Employee employee) {
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.update("insert into employee (id, name, salary) values (:id, :name, :salary)", new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.update("update employee set name = :name, salary = :salary", new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		//return namedParameterJdbcTemplate.update("delete from employee where id = ?", new Object[] {id});
		return 0;
	}
	
	
	
}
