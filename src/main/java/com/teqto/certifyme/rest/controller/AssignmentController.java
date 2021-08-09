package com.teqto.certifyme.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.teqto.certifyme.entity.Assignment;
import com.teqto.certifyme.repository.AssignmentRepository;
import com.teqto.certifyme.utils.ObjectUtility;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

	@Autowired
	private AssignmentRepository repository;
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Assignment assignment) throws URISyntaxException {
			assignment = (Assignment)ObjectUtility.setDateUpdate(assignment);
			Assignment e = repository.save(assignment);
			return ResponseEntity.created(new URI("/api/assignment/create/" + assignment.getId())).body(e);
	}
	
	@GetMapping("/assignmentid/{assignmentid}")
	ResponseEntity<?> find(@PathVariable Long assignmentid) {
		Optional<Assignment> assignment = repository.findById(assignmentid);
		return assignment.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/customer/{customerid}")
	ResponseEntity<?> findByCustomerid(@PathVariable String customerid) {
		Optional<List<Assignment>> assignment = repository.findByCustomerid(customerid);
		return assignment.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Assignment assignment) {
		assignment = (Assignment)ObjectUtility.setDateUpdate(assignment);
		assignment = repository.save(assignment);
		return new ResponseEntity<Assignment>(assignment, HttpStatus.OK);
	}
}
