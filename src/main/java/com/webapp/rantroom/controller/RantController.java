package com.webapp.rantroom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.rantroom.exception.ResourceNotFoundException;
import com.webapp.rantroom.model.Rants;
import com.webapp.rantroom.repository.RantRepository;

@RestController
@RequestMapping("/api")
public class RantController {
	
	@Autowired
	RantRepository rantRepository;

	// Get All Rants
	@GetMapping("/rants")
	public List<Rants> getAllRants() {
	    return rantRepository.findAll();
	}

    // Create a new Rant
	@PostMapping("/rants")
	public Rants createRant(@Valid @RequestBody Rants rant) {
	    return rantRepository.save(rant);
	}

    // Get a Single Rant
	@GetMapping("/rants/{id}")
	public Rants getRantById(@PathVariable(value = "id") Long rantId) {
	    return rantRepository.findById(rantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rant", "id", rantId));
	}
    // Update a Rant
	@PutMapping("/rants/{id}")
	public Rants updateRant(@PathVariable(value = "id") Long rantId,
	                                        @Valid @RequestBody Rants rantDetails) {

		Rants rant = rantRepository.findById(rantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rant", "id", rantId));

		rant.setTitle(rantDetails.getTitle());
		rant.setContent(rantDetails.getContent());

		Rants updatedRant = rantRepository.save(rant);
	    return updatedRant;
	}
    // Delete a Rant
	@DeleteMapping("/rants/{id}")
	public ResponseEntity<?> deleteRant(@PathVariable(value = "id") Long rantId) {
		Rants rant = rantRepository.findById(rantId)
	            .orElseThrow(() -> new ResourceNotFoundException("Rant", "id", rantId));

	    rantRepository.delete(rant);

	    return ResponseEntity.ok().build();
	}
}
