package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customException.BusinessException;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeCrudRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeCrudRepo employeeCrudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			if (employee.getName().isEmpty() || employee.getName().length() == 0) {
				throw new BusinessException("601", "Name field is not valid");
			}
			Employee savedEmployee = employeeCrudRepo.save(employee);
			return savedEmployee;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given Employee is Null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something wrong in Service layer while savings records." + e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> employees = employeeCrudRepo.findAll();
			if (employees.isEmpty()) {
				throw new BusinessException("604", "No employee records in the database.");

			}
			return employees;
		} catch (Exception e) {
			throw new BusinessException("605", "Something wrong happened in Service layer while fetching records.");
		}
	}

	@Override
	public Employee getEmployeeById(long empId) {
		return employeeCrudRepo.findById(empId).get();
	}

	@Override
	public void deleteEmployeeById(long empId) {
		employeeCrudRepo.deleteById(empId);

	}

}
