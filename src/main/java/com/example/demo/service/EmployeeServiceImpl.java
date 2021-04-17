package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeCrudRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeCrudRepo employeeCrudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeCrudRepo.save(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeCrudRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long empId) {
		return employeeCrudRepo.findById(empId).get();
	}


}
