package com.webapp.rantsroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.rantsroom.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
