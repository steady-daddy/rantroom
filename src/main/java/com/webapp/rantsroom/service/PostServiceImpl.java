package com.webapp.rantsroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.rantsroom.model.Post;
import com.webapp.rantsroom.model.User;
import com.webapp.rantsroom.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void save(Post post) {
		
		postRepository.save(post);

	}

	@Override
	public Post findByTitle(String title) {
		
		return postRepository.findByTitle(title);
	}

	@Override
	public Post findByUser(User user) {
		// TODO Auto-generated method stub
		return postRepository.findByUser(user);
	}

}
