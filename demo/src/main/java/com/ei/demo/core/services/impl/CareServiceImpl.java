package com.ei.demo.core.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ei.demo.core.db.CareRepository;
import com.ei.demo.core.model.Care;
import com.ei.demo.core.model.Person;
import com.ei.demo.core.services.CareService;
import com.ei.demo.core.services.PersonService;

@Service
public class CareServiceImpl implements CareService {

	@Autowired
	private CareRepository careRepository;

	@Autowired
	private PersonService personService;

	@Override
	public List<Care> getAll(){
		return (List<Care>) careRepository.findAll();
	}
	
	@Override
	@Transactional
	public Care create(Care newCare) {
		Person parent = personService.getById(newCare.getParent().getId()).get();
		Person sitter = personService.getById(newCare.getBabysitter().getId()).get();
		parent.setCareBalance(parent.getCareBalance().minus(newCare.getDuration()));
		sitter.setCareBalance(sitter.getCareBalance().plus(newCare.getDuration()));
		
		newCare.setParent(parent);
		newCare.setBabysitter(sitter);
		newCare.setId(null);
		return careRepository.save(newCare);
	}
	
	@Override
	public Optional<Care> getById(Long id){
		return careRepository.findById(id);
	}
	
	@Override
	public Care update(Long id, Care newCare){
		newCare.setId(id);
		return careRepository.save(newCare);
	}
	
	@Override
	public void delete(Long id){
		careRepository.deleteById(id);
	}
		
}
