package com.webapp.rantsroom.service;

import com.webapp.rantsroom.model.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}
