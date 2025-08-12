package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.EmployeeDao;
import com.demo.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeDao employeeDao;

	// 🔍 Get all employees
	@GetMapping("/allEemployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("allEemployees method Starting");
		logger.info("allEemployees method Starting");
		List<Employee> employees= employeeDao.getAllEmployees();
		logger.info("ending allEemployees method Starting");
		if (employees.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employees);
	    } else {
	        return ResponseEntity.ok(employees);
	    }
	}

	// 🔍 Get employee by ID
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee emp = employeeDao.getEmployeeById(id);
		return emp;
		//return emp != null ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
	}

	// ➕ Add new employee
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {

		employeeDao.addEmployee(emp);
		return ResponseEntity.ok("Employee added successfully");
	}

	// 🔄 Update employee
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		emp.setId(id);
		employeeDao.updateEmployee(emp);
		return ResponseEntity.ok("Employee updated successfully");
	}

	// ❌ Delete employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeDao.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully");
	}
}
