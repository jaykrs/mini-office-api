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

import com.teqto.certifyme.entity.Sprint;
import com.teqto.certifyme.repository.SprintRepository;
import com.teqto.certifyme.utils.ObjectUtility;

@RestController
@RequestMapping("/api/sprint")
public class SprintController {

	@Autowired
	private SprintRepository repository;
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Sprint sprint) throws URISyntaxException {
			sprint = (Sprint)ObjectUtility.setDateUpdate(sprint);
			Sprint e = repository.save(sprint);
			return ResponseEntity.created(new URI("/api/sprint/create/" + sprint.getId())).body(e);
	}
	
	@GetMapping("/sprintid/{sprintid}")
	ResponseEntity<?> find(@PathVariable Long sprintid) {
		Optional<Sprint> sprint = repository.findById(sprintid);
		return sprint.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/assignment/{assignment}")
	ResponseEntity<?> findByAssignment(@PathVariable Integer assignment) {
		Optional<List<Sprint>> sprint = repository.findByAssignment(assignment);
		return sprint.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Sprint sprint) {
		sprint = (Sprint)ObjectUtility.setDateUpdate(sprint);
		sprint = repository.save(sprint);
		return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
	}
}
