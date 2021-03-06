package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(long empId);

	void deleteEmployeeById(long empId);

}
