package com.webapp.rantsroom.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webapp.rantsroom.model.Post;

@Component
public class PostValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Post.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Post post = (Post) target;
		
		//Post title validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.titleEmpty");
        if (post.getTitle().length() > 99) {
            errors.rejectValue("title", "Size.postForm.title");
        }
        
      //Post description validation
  		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rant", "error.rantEmpty");
          if (post.getRant().length() > 999) {
              errors.rejectValue("rant", "Size.rant.title");
          }                		  
	}

}
