package com.rantsroom.validator;

import org.apache.commons.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rantsroom.model.User;
import com.rantsroom.model.UserProfile;
import com.rantsroom.service.UserService;

@Component
public class UserValidator implements Validator {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	
        User user = (User) o;
        logger.info("User data: ",user.getFirstname());
        //username validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.usernameEmpty");
        try {
			if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			    errors.rejectValue("username", "Size.userForm.username");
			}
			if (userService.findByUsername(user.getUsername()) != null) {
			    errors.rejectValue("username", "Duplicate.userForm.username");
			}
		} catch (NullPointerException npe) {
			logger.error("Username not found",user.getUsername());
		}
        
        //first name validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");        
        
        //email validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.emailEmpty");        
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }        
        EmailValidator validator = EmailValidator.getInstance();
    	if (!validator.isValid(user.getEmail())) {    	  
    		errors.rejectValue("email", "error.email.not.valid","The entered email address is not valid!");
    	}
    	
    	//password validation
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
    }
}
