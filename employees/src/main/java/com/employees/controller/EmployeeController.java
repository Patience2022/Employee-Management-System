package com.employees.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employees.entity.Employee;
import com.employees.service.EmployeeService;

@Controller

public class EmployeeController {
	
	private final EmployeeService service;
	
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}


	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("list", service.getAllEmployees());
		
		return"index";
	}
	
	@GetMapping("/newEmployeeForm")
	public String showNewEmployeeForm(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee)
	{
		service.saveEmployee(employee);
		return"redirect:/";
	}
	
	@GetMapping("/showUpdateForm/{id}")
	
	public String showUpdateForm(@PathVariable(value="id")long id, Model model)
	{
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return"update_employee";
	}
	
	@GetMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id")long id)
	{
		service.deleteById(id);
		return "redirect:/";
	}
	
}
