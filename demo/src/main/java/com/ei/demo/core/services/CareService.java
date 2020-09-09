package com.ei.demo.core.services;

import java.util.List;
import java.util.Optional;

import com.ei.demo.core.model.Care;

public interface CareService {

	List<Care> getAll();

	Care create(Care newCare);

	Optional<Care> getById(Long id);

	Care update(Long id, Care newCare);

	void delete(Long id);

}