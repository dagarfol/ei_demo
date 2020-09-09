package com.ei.demo.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.demo.core.db.PersonRepository;
import com.ei.demo.core.model.Person;
import com.ei.demo.core.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAll(){
		return (List<Person>) personRepository.findAll();
	}
	
	@Override
	public Person create(Person newPerson) {
		newPerson.setId(null);
		return personRepository.save(newPerson);
	}

	@Override
	public Optional<Person> getById(Long id){
		return personRepository.findById(id);
	}
	
	@Override
	public Person update(Long id, Person newPerson){
		newPerson.setId(id);
		return personRepository.save(newPerson);
	}
	
	@Override
	public void delete(Long id){
		personRepository.deleteById(id);
	}

}
