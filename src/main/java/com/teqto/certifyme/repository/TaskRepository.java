package com.teqto.certifyme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqto.certifyme.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	Optional<List<Task>> findBySprint(Integer sprint);
	Optional<List<Task>> findByAssignment(Integer assignment);
}
