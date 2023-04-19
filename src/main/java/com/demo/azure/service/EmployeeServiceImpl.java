package com.demo.azure.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.demo.azure.modle.Employee;

@Service
public class EmployeeServiceImpl {
	
	
	public static Map<Long, Employee> employeeList = new HashMap<>();
	
	public String saveEmployee(Employee emp) {
		if (emp.getId() == null) {
			emp.setId(new Random().nextLong());
		}
		employeeList.put(emp.getId(), emp);
		return "Employee added successfully!";
	}
	
	
	public Collection<Employee> getEmployee(){
		return employeeList.values();
	}

}
