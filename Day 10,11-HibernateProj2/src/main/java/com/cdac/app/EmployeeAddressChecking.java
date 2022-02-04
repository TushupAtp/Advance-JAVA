package com.cdac.app;

import java.time.LocalDate;

import com.cdac.dao.EmployeeAddressDao;
import com.cdac.entity.Address;
import com.cdac.entity.Employee;

public class EmployeeAddressChecking {

	public static void main(String[] args) {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		
		/**** Scenario 1: Adding Employee, Adding Address and Then Linking Employee with Address *****/
		/*Employee emp = new Employee();
		emp.setName("Majrul Ansari");
		emp.setSalary(5000);
		emp.setDateOfJoining(LocalDate.of(2010, 10, 10));
		dao.add(emp);*/
		
		/*Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400001);
		addr.setState("MH");
		dao.add(addr);*/
		
		/*Employee emp = dao.fetchEmployee(7);
		Address addr = dao.fetchAddress(8);
		emp.setAddress(addr);
		dao.update(emp);*/
		
		/**** Scenario 2: Adding Employee and Then Adding Address for that Employee *****/
		/*Employee emp = new Employee();
		emp.setName("Shailes Dubey");
		emp.setSalary(5000);
		emp.setDateOfJoining(LocalDate.of(2020, 10, 10));
		dao.add(emp);*/
		
		/*Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400011);
		addr.setState("MH");
		dao.add(addr);
		
		Employee emp = dao.fetchEmployee(9);
		emp.setAddress(addr);
		dao.update(emp);*/
		
		/**** Scenario 3: Adding Employee and Address together *****/
		// In this scenario, if i add an employee, the address should get added automatically
		Employee emp = new Employee();
		emp.setName("Suraj Gawade");
		emp.setSalary(5000);
		emp.setDateOfJoining(LocalDate.of(2022, 1, 1));

		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400033);
		addr.setState("MH");
		
		emp.setAddress(addr);
		
		dao.add(emp);
		
	}
}
