package com.teqto.certifyme.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.certifyme.entity.Employee;
import com.teqto.certifyme.repository.EmployeeRepository;
import com.teqto.certifyme.utils.ObjectUtility;
import com.teqto.certifyme.constant.ServiceConstants;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@RequestMapping(value = "/hallo", method = RequestMethod.GET)
	public String sayhi() {
		return "Hallo <h2> " + "User" + "</h1>";
	}
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Employee employee) throws URISyntaxException {
		if (!repository.findByEmployeeid(employee.getEmployeeid()).isPresent()) {
			employee = (Employee)ObjectUtility.setDateUpdate(employee);
			Employee e = repository.save(employee);
			return ResponseEntity.created(new URI("/api/employee/create/" + employee.getEmployeeid())).body(e);
		}
		return ResponseEntity.unprocessableEntity().body(employee.getEmployeeid() + ServiceConstants.EMPLOYEE_ERROR);
	}
	
	@GetMapping("/{employeeid}")
	ResponseEntity<?> find(@PathVariable String employeeid) {
		Optional<Employee> employee = repository.findByEmployeeid(employeeid);
		return employee.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Employee employee) {
		employee = (Employee)ObjectUtility.setDateUpdate(employee);
		employee = repository.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
