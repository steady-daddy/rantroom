package com.webapp.rantsroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.rantsroom.model.Post;
import com.webapp.rantsroom.model.User;
import com.webapp.rantsroom.repository.PostRepository;
import com.webapp.rantsroom.repository.PostRepositoryImpl;

@Service
public class PostServiceImpl extends PostRepositoryImpl implements PostService {

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

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public List<Post> findAllById(Long Id) {
		// TODO Auto-generated method stub
		return super.findAllById(Id);
	}
	
}
