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

import com.teqto.certifyme.entity.Customer;
import com.teqto.certifyme.repository.CustomerRepository;
import com.teqto.certifyme.utils.ObjectUtility;
import com.teqto.certifyme.constant.ServiceConstants;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping(value = "/hallo", method = RequestMethod.GET)
	public String sayhi() {
		return "Hallo <h2> " + "User" + "</h1>";
	}
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Customer customer) throws URISyntaxException {
		if (!repository.findByCustomerid(customer.getCustomerid()).isPresent()) {
			customer = (Customer)ObjectUtility.setDateUpdate(customer);
			Customer e = repository.save(customer);
			return ResponseEntity.created(new URI("/api/customer/create/" + customer.getCustomerid())).body(e);
		}
		return ResponseEntity.unprocessableEntity().body(customer.getCustomerid() + ServiceConstants.CUSTOMER_ERROR);
	}
	
	@GetMapping("/customerid/{customerid}")
	ResponseEntity<?> find(@PathVariable String customerid) {
		Optional<Customer> customer = repository.findByCustomerid(customerid);
		return customer.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/email/{email}")
	ResponseEntity<?> findEmail(@PathVariable String email) {
		Optional<Customer> customer = repository.findByEmail(email);
		return customer.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Customer customer) {
		customer = (Customer)ObjectUtility.setDateUpdate(customer);
		customer = repository.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
