package com.demo.azure.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.azure.modle.Employee;
import com.demo.azure.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	@GetMapping("/")
	public ResponseEntity<String> greeting(){
		return new ResponseEntity<String>("Welcome to the first time azure deployement!", HttpStatus.OK);
	}
	
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee added succussfully!", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<Collection<Employee>> getEmployee(){
		return new ResponseEntity<Collection<Employee>>(employeeService.getEmployee(), HttpStatus.OK);
	}

}
