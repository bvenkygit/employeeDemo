package com.demo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;
import com.demo.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM employee WHERE id = ?";
		return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(), id);
	}
    
	
	@Override
	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO employee (name, email, department) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getDepartment());  
		jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getDepartment());  
	
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE employee SET name = ?, email = ?, department = ? WHERE id = ?";
		jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getDepartment(), employee.getId());
	}

	@Override
	public void deleteEmployee(int id) {
		String sql = "DELETE FROM employee WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
