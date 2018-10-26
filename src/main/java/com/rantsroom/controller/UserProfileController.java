package com.rantsroom.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rantsroom.model.Post;
import com.rantsroom.model.User;
import com.rantsroom.model.UserProfile;
import com.rantsroom.service.PostServiceImpl;
import com.rantsroom.service.UserService;

@Controller
public class UserProfileController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private PostServiceImpl postServiceImpl;
//    @Autowired
//    private FileStorageService fileStorageService;
    
    @RequestMapping(value = "/users/profile", method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
    	
		String currentUser = null;
    	try {
			currentUser = principal.getName();
			logger.info("CURRENT LOGGED-IN USER: ",currentUser);
    	} catch (NullPointerException e) {
			logger.info("No user logged in");
		}
    	User user = userService.findByUsername(currentUser);
    	model.addAttribute("user", user);
    	List<Post> posts = postServiceImpl.findAllById(user.getId());
    	if(posts.isEmpty())
    		logger.info("No posts found");
    	model.addAttribute("posts", posts);
        
        return "users/profile";
    }
	@RequestMapping(value = "/users/profile/edit", method = RequestMethod.GET)
    public String editProfile(Model model,Principal principal) {
		

		String currentUser = null;
    	try {
			currentUser = principal.getName();
			logger.info("CURRENT LOGGED-IN USER: ",currentUser);
    	} catch (NullPointerException e) {
			logger.info("No user logged in");
		}
    	User user = userService.findByUsername(currentUser);
    	model.addAttribute("user", user);
		model.addAttribute("info", "This part is under construction. Please check back later.");
    	/*
    	User user = userService.findByUsername(currentUser.getUsername());
    	model.addAttribute("user", user);
    	List<Post> posts = postServiceImpl.findAllById(user.getId());
    	model.addAttribute("posts", posts);*/
        
        return "users/profile";
    }
	@RequestMapping(value = "/users/profile/settings", method = RequestMethod.GET)
    public String profileSettings(Model model,Principal principal) {
		
		String currentUser = null;
    	try {
			currentUser = principal.getName();
			logger.info("CURRENT LOGGED-IN USER: ",currentUser);
    	} catch (NullPointerException e) {
			logger.info("No user logged in");
		}
    	User user = userService.findByUsername(currentUser);
    	model.addAttribute("user", user);
		model.addAttribute("info", "This part is under construction. Please check back later.");    	
        
        return "users/profile";
    }
	
		/*@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
	        String filePath = fileStorageService.storeFile(file);
	        model.addAttribute("filePath", filePath);
	        return "";
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        
	        return new UserProfile(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }
*/
}
