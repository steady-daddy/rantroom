package com.webapp.rantsroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.rantsroom.model.Post;
import com.webapp.rantsroom.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Post findByTitle(String title);
	Post findByUser(User user);
	List<Post> findAll();
}
