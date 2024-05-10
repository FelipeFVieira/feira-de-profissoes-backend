package com.senaisuico.presence.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.senaisuico.presence.model.Presence;
import com.senaisuico.presence.repository.SpringDataRepository;


@RestController
@RequestMapping(path="/presence")
public class PresenceController {
	
	@Autowired
	private SpringDataRepository SpringDataRepository;
	
	
	@GetMapping(path="/all")
	public @ResponseBody ResponseEntity<Iterable<Presence>> getAllPresences() {
		   try {
		        Iterable<Presence> allPresences = SpringDataRepository.findAll();
		        return ResponseEntity.ok(allPresences);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ResponseEntity<Presence> addNewPresence (@Validated @RequestBody Presence presence) {
		try {
			Presence savedPresence = SpringDataRepository.save(presence);
	        return ResponseEntity.ok(savedPresence);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	@DeleteMapping(path="/del/{id}")
	public @ResponseBody ResponseEntity<Presence> deletePresence (@PathVariable int id) {
		Presence presence;
		Optional<Presence> optionalUser = SpringDataRepository.findById(id);
		if (!optionalUser.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		
		presence = optionalUser.get();
	    SpringDataRepository.delete(presence);
		return ResponseEntity.ok(presence);
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody ResponseEntity<Presence> updatePresence(@PathVariable int id, @RequestBody Presence updatedPresence) {
		Optional<Presence> optionalUser = SpringDataRepository.findById(id);
	    if (!optionalUser.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    Presence presence = optionalUser.get();
	    presence.setName(updatedPresence.getName());
	    presence.setDate_birth(updatedPresence.getDate_birth());
	    presence.setEmail(updatedPresence.getEmail());
	    presence.setProfessional_goal(updatedPresence.getProfessional_goal());
	    presence.setNeighborhood(updatedPresence.getNeighborhood());

	    Presence savedPresence = SpringDataRepository.save(presence);
	    return ResponseEntity.ok(savedPresence);
		
	}
	
}
