package com.employees.service;

import java.util.List;

import com.employees.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteById(long id);

}
