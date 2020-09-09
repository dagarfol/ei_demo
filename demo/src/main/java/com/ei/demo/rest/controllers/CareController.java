package com.ei.demo.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ei.demo.core.model.Care;
import com.ei.demo.core.services.CareService;

@RestController
@RequestMapping("/api/cares")
@CrossOrigin
public class CareController {

	@Autowired
	private CareService careService;

	@GetMapping
	public List<Care> getAll(){
		return careService.getAll();
	}
	
	@PostMapping
	public Care create(@RequestBody Care newCare) {
		return careService.create(newCare);
	}

	@GetMapping("/{id}")
	public Optional<Care> getById(@PathVariable("id") Long id){
		return careService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Care update(@PathVariable("id") Long id, @RequestBody Care newCare){
		return careService.update(id, newCare);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		careService.delete(id);
	}
		
}
