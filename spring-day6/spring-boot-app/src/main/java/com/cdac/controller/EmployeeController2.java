package com.cdac.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Employee;

@RestController
@CrossOrigin
public class EmployeeController2 {

	@GetMapping("/emp2")
	public Employee fetch() {
		Employee emp = new Employee();
		emp.setEmpno(1002);
		emp.setName("John");
		emp.setSalary(2000);
		return emp;
	}
}
