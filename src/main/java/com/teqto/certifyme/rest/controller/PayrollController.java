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

import com.teqto.certifyme.entity.Payroll;
import com.teqto.certifyme.repository.PayrollRepository;
import com.teqto.certifyme.utils.ObjectUtility;
import com.teqto.certifyme.constant.ServiceConstants;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

	@Autowired
	private PayrollRepository repository;
	
	@RequestMapping(value = "/hallo", method = RequestMethod.GET)
	public String sayhi() {
		return "Hallo <h2> " + "User" + "</h1>";
	}
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Payroll payroll) throws URISyntaxException {
		if (!repository.findByEmployeeid(payroll.getEmployeeid()).isPresent()) {
			payroll = (Payroll)ObjectUtility.setDateUpdate(payroll);
			Payroll e = repository.save(payroll);
			return ResponseEntity.created(new URI("/api/payroll/create/" + payroll.getEmployeeid())).body(e);
		}
		return ResponseEntity.unprocessableEntity().body(payroll.getEmployeeid() + ServiceConstants.PAYROLL_ERROR);
	}
	
	@GetMapping("/{payrollid}")
	ResponseEntity<?> find(@PathVariable Long payrollid) {
		Optional<Payroll> payroll = repository.findById(payrollid);
		return payroll.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/{employeeid}")
	ResponseEntity<?> findByEmployee(@PathVariable String employeeid) {
		Optional<Payroll> payroll = repository.findByEmployeeid(employeeid);
		return payroll.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Payroll payroll) {
		payroll = (Payroll)ObjectUtility.setDateUpdate(payroll);
		payroll = repository.save(payroll);
		return new ResponseEntity<Payroll>(payroll, HttpStatus.OK);
	}
}
