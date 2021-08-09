package com.teqto.certifyme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqto.certifyme.entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long>{

	Optional<Payroll> findByEmployeeid(String employeeid);
}
