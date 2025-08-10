package com.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Employee emp = new Employee();
	        emp.setId(rs.getInt("id"));
	        emp.setName(rs.getString("name"));
	        emp.setEmail(rs.getString("email"));
	        emp.setDepartment(rs.getString("department"));
	        //emp.seADDr(rs.getString("name")+","+rs.getString("department"))
	        return emp;
	}

}
