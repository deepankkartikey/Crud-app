package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") long empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.CREATED);

	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empId") long empId) {
		employeeService.deleteEmployeeById(empId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
