package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);
}
