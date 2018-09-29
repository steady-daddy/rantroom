package com.webapp.rantsroom.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.rantsroom.model.User;
import com.webapp.rantsroom.service.EmailService;
import com.webapp.rantsroom.service.SecurityService;
import com.webapp.rantsroom.service.UserService;
import com.webapp.rantsroom.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;    
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
    	
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
        	// Disable user until they click on confirmation link in email
		    userForm.setActive(false);
		    userForm.setEmail_confirmed(false);
		    
		    // Generate random 36-character string token for confirmation link
		    userForm.setConfirmationToken(UUID.randomUUID().toString());
		    
		    userService.save(userForm);
		    
		    //Sending verification token via mail
		    sendConfirmationMail(request,userForm);
		    
		    return "redirect:/confirm";
        }
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String error, Model model, String logout) {
    	
    	//model.addAttribute("userLogin", new User());
    	if (error != null)
            model.addAttribute("error", "Your username/password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
//        if(!(userLogin.isEmail_confirmed())) {
//        	model.addAttribute("error", "Oops! Looks like you haven't verified your email yet.Please check your mail box.");

        return "login";
    }
    
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userLogin") User userLogin, String error, Model model) {
		
    	//System.out.println("LOGIN: POST");
		System.out.println("USER Object inside login:"+userLogin.toString());
		boolean loginFlag = true;
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            loginFlag = false;
        }
        
        else if(!(userLogin.isEmail_confirmed())) {
        	model.addAttribute("error", "Oops! Looks like you haven't verified your email yet.Please check your mail box.");
        	loginFlag = false;
        }        
        	
        if(loginFlag) {
        	model.addAttribute("firstname", userLogin.getFirstname());
        	//securityService.autologin(userLogin.getUsername(), userLogin.getPassword());
            return "redirect:/welcome";
        }        	
        else
        	return "login";
    }*/

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {	
        return "welcome";
    }
    
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
    
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm(Model model) {   	
    	
        return "confirm";
    }
    
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify(Model model, @RequestParam("token") String token) {   	
    	User user = userService.findByConfirmationToken(token);
    	
    	if (user == null) { // No token found in DB
    		model.addAttribute("verifyUser", "Oops!  This is an invalid confirmation link.");
    	} else { // Token found
    		model.addAttribute("verifyUser", "Success!  Your e-mail is now verified.");
    		user.setActive(true);
    		user.setEmail_confirmed(true);
    	}
        return "verify";
    }
    
    // Sending email for verification
    private void sendConfirmationMail(HttpServletRequest request, User userForm) {
		
    	String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
		
		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(userForm.getEmail());
		registrationEmail.setSubject("RantsRoom Registration Confirmation");
		registrationEmail.setText("Hi "+userForm.getFirstname()+",\n\nWelcome to RantsRoom! Your portal to rant about anything you like.\n\n"
				+ "To confirm your e-mail address, please click the link below:\n"
				+ appUrl + "/verify?token=" + userForm.getConfirmationToken());
		registrationEmail.setFrom("khan.ssaad@gmail.com");
		
		emailService.sendEmail(registrationEmail);
		
	}

}
