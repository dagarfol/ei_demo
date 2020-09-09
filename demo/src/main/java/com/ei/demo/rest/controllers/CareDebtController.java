package com.ei.demo.rest.controllers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ei.demo.core.db.PersonRepository;
import com.ei.demo.core.model.Care;
import com.ei.demo.core.model.Person;

@RestController
@RequestMapping("/api/caredebts")
@CrossOrigin
public class CareDebtController {

	@Autowired
    PersonRepository personRepository;
	
	@GetMapping
	public List<Care> getAll() {
		List<Care> payments = new ArrayList<>();
		TreeSet<Person> debitors = new TreeSet<>(Comparator.comparing(Person::getCareBalance));
		TreeSet<Person> creditors = new TreeSet<>(Comparator.comparing(Person::getCareBalance).reversed());
		Duration totalDebit = Duration.ZERO;
		Duration totalCredit = Duration.ZERO;
		
		for(Person person : personRepository.findAll()){
			if(person.getCareBalance().isNegative()) {
				debitors.add(person);
				totalDebit = totalDebit.plus(person.getCareBalance());
			}else if(!person.getCareBalance().isZero()) {
				creditors.add(person);
				totalCredit = totalCredit.plus(person.getCareBalance());
			}
		};
		
		if(!totalCredit.plus(totalDebit).isZero()) {
			throw new RuntimeException("Total debit is different than total credit");
		}
		
		while(!debitors.isEmpty()) {
			Person debitor = debitors.pollFirst();
			Person creditor = creditors.pollFirst();
			Duration remaining = creditor.getCareBalance().plus(debitor.getCareBalance());
			if(remaining.isNegative()) {
				storePayment(debitor,creditor,creditor.getCareBalance(), payments);
				
				debitor.setCareBalance(remaining);
				debitors.add(debitor);
			}else {
				storePayment(debitor,creditor,debitor.getCareBalance(), payments);
				if(!remaining.isZero()) {
					creditor.setCareBalance(remaining);
					creditors.add(creditor);
				}
			}
		}
		
		return payments;
	}
	
	private void storePayment(Person who, Person toWhom, Duration howMuch, List<Care> payments) {
		payments.add(new Care(toWhom, who, "debt payment", null, howMuch.abs()));
	}
}
