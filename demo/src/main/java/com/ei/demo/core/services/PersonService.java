package com.ei.demo.core.services;

import java.util.List;
import java.util.Optional;

import com.ei.demo.core.model.Person;

public interface PersonService {

	List<Person> getAll();

	Person create(Person newPerson);

	Optional<Person> getById(Long id);

	Person update(Long id, Person newPerson);

	void delete(Long id);
}