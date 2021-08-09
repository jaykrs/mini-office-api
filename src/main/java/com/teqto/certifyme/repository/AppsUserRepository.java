package com.teqto.certifyme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teqto.certifyme.entity.AppsUser;

public interface AppsUserRepository extends JpaRepository<AppsUser, Long>{

	AppsUser findByUsername(String username);
}
