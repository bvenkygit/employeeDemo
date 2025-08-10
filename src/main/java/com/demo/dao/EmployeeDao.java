package com.demo.dao;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);
}
