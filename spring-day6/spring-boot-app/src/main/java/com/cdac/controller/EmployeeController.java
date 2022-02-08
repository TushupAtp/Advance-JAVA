package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdac.entity.Employee;

@Controller
public class EmployeeController {

	//@RequestMapping("/emp")
	@RequestMapping(path = "/emp", method = RequestMethod.GET)
	public @ResponseBody Employee fetch() {
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Majrul");
		emp.setSalary(1000);
		return emp;
	}
}
