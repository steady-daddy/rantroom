package com.webapp.rantsroom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.webapp.rantsroom.exception.ResourceNotFoundException;
import com.webapp.rantsroom.model.Post;
import com.webapp.rantsroom.model.User;
import com.webapp.rantsroom.repository.PostRepository;
import com.webapp.rantsroom.service.PostService;
import com.webapp.rantsroom.validator.PostValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class PostController {

    @Autowired
    private PostService postService;
    
    @Autowired
    private PostValidator postValidator;
    
   
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String createPost(Model model) {
    	model.addAttribute("postForm", new Post());    	
        return "users/post";        		
    }
    
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("postForm") Post postform,BindingResult bindingResult, Model model, @AuthenticationPrincipal UserDetails currentUser) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	System.out.println("CURRENT USER: " + auth.getDetails());
//    	System.out.println("CURRENT PRINCIPAL: " + auth.getPrincipal());
//    	System.out.println("CURRENT AUTH: " + auth.getAuthorities());
//    	System.out.println("CURRENT CRED: " + auth.getPrincipal());
    	System.out.println("CURRENT CRED: " + currentUser.getUsername());
    	postValidator.validate(postform, bindingResult);
    	
    	if (bindingResult.hasErrors()) {
            return "users/post";
        }
    	else {
	    	postService.save(postform);
	        return "redirect:/users/postsuccess";
    	}
        		
    }
    @RequestMapping(value = "/postsuccess", method = RequestMethod.GET)
    public String success(Model model) {   	
    	model.addAttribute("verifyPost", "Success!  Your Rant is posted.");
        return "/users/postsuccess";
    }

    /*@RequestMapping(value = "/posts/{postId}", method = RequestMethod.PUT)
    public String updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
         postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setRant(postRequest.getRant());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
         //Mod
         return "post";
    }


    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }*/

}
