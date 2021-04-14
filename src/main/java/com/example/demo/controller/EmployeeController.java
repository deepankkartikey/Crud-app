package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeCrudRepo;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeCrudRepo employeeCrudRepo;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		System.out.println("Getting all employees...");
		return employeeCrudRepo.findAll();
	}
}
