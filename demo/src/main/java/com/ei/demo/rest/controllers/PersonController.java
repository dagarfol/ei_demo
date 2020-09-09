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

import com.ei.demo.core.model.Person;
import com.ei.demo.core.services.PersonService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> getAll(){
		return (List<Person>) personService.getAll();
	}
	
	@PostMapping
	public Person create(@RequestBody Person newPerson) {
		return personService.create(newPerson);
	}

	@GetMapping("/{id}")
	public Optional<Person> getById(@PathVariable("id") Long id){
		return personService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Person update(@PathVariable("id") Long id, @RequestBody Person newPerson){
		return personService.update(id, newPerson);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		personService.delete(id);
	}
		
}
