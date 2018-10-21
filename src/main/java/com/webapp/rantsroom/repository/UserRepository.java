package com.webapp.rantsroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.rantsroom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}
