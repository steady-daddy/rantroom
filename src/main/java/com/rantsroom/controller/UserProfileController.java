package com.rantsroom.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rantsroom.model.Post;
import com.rantsroom.model.User;
import com.rantsroom.service.PostServiceImpl;
import com.rantsroom.service.UserService;

@Controller
public class UserProfileController {
	
	@Value("${file.upload-dir}")
	private String uploadFolderPath;
	@Value("${server.address}")
	private String serverAddress;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private PostServiceImpl postServiceImpl;
    
  //Save the uploaded file to this folder
    //private static String UPLOADED_FOLDER = "./upload";
    
    @RequestMapping(value = "/users/profile", method = RequestMethod.GET)
    public String welcome(Model model, Principal principal) {
    	
    	System.out.println("UPLOAD_FOLDER_PATH: "+uploadFolderPath);
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
	
	@RequestMapping(value = "/users/editProfile/{id}", method = RequestMethod.GET)
    public String uploadFile(@PathVariable("id") Long id, Model model) {
		
		logger.info("User object based on id "+id+" : \n"+userService.findById(id).get().toString());
		model.addAttribute("editUser", userService.findById(id).get());
	   
		
		
		
		
		/*String currentUser = null;
    	try {
			currentUser = principal.getName();
			logger.info("CURRENT LOGGED-IN USER: ",currentUser);
    	} catch (NullPointerException e) {
			logger.info("No user logged in");
		}
    	User user = userService.findByUsername(currentUser);
    	model.addAttribute("user", user);		
		
		
		if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }*/
		
        return "users/editProfile";
    }
}
