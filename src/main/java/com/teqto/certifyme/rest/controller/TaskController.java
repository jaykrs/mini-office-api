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

import com.teqto.certifyme.entity.Task;
import com.teqto.certifyme.repository.TaskRepository;
import com.teqto.certifyme.utils.ObjectUtility;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskRepository repository;
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Task task) throws URISyntaxException {
			task = (Task)ObjectUtility.setDateUpdate(task);
			Task e = repository.save(task);
			return ResponseEntity.created(new URI("/api/task/create/" + task.getId())).body(e);
	}
	
	@GetMapping("/taskid/{taskid}")
	ResponseEntity<?> find(@PathVariable Long taskid) {
		Optional<Task> task = repository.findById(taskid);
		return task.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/assignment/{assignment}")
	ResponseEntity<?> findByAssignment(@PathVariable Integer assignment) {
		Optional<List<Task>> task = repository.findByAssignment(assignment);
		return task.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/sprint/{sprint}")
	ResponseEntity<?> findBySprint(@PathVariable Integer sprint) {
		Optional<List<Task>> task = repository.findBySprint(sprint);
		return task.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Task task) {
		task = (Task)ObjectUtility.setDateUpdate(task);
		task = repository.save(task);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
}
