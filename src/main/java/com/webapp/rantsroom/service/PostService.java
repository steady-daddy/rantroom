package com.webapp.rantsroom.service;

import com.webapp.rantsroom.model.Post;
import com.webapp.rantsroom.model.User;

public interface PostService {
	
	void save (Post post);
	Post findByTitle(String title);
	Post findByUser(User user);
}
