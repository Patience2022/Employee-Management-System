package com.employees.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employees.entity.Employee;
import com.employees.repository.EmployeeRepository;
import com.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
	}


	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional =repository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee = optional.get();
		}
		else
		{
			throw new RuntimeException("No employee with Id: "+id);
		}
		return employee;
	}


	@Override
	public void deleteById(long id) {
		this.repository.deleteById(id);
		
	}

}
