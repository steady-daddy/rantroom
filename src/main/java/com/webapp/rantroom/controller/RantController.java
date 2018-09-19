package com.webapp.rantroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.rantroom.model.Rants;
import com.webapp.rantroom.repository.RantRepository;

@RestController
@RequestMapping("/api")
public class RantController {
	
	@Autowired
	RantRepository rantRepository;

	// Get All Rants
	@GetMapping("/rants")
	public List<Rants> getAllNotes() {
	    return rantRepository.findAll();
	}

    // Create a new Rant

    // Get a Single Rant

    // Update a Rant

    // Delete a Rant
}
