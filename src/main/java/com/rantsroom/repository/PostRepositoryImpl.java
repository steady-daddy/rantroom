package com.rantsroom.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.rantsroom.model.Post;
import com.rantsroom.model.User;

public class PostRepositoryImpl{
	
	@Autowired
	EntityManager em;
	
	public List<Post> findAllById(Long Id){
		User user = em.find(User.class, Id);
		List<Post> posts = user.getPosts();		
		return posts;		
	}
	

}
