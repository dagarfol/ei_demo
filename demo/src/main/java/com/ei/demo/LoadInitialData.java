package com.ei.demo;

import java.time.Duration;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ei.demo.core.db.CareRepository;
import com.ei.demo.core.db.PersonRepository;
import com.ei.demo.core.model.Care;
import com.ei.demo.core.model.Person;

@Configuration
public class LoadInitialData {
	
	private static final Logger log = LoggerFactory.getLogger(LoadInitialData.class);
	
	@Bean
	CommandLineRunner initDatabase(PersonRepository personRepo, CareRepository careRepo) {
		Person p1 = new Person("p1","e@mail.com" );p1.setCareBalance(Duration.ofMinutes(-90));
		Person p2 = new Person("p2","e@mail.com" );p2.setCareBalance(Duration.ofMinutes(-60));
		Person p3 = new Person("p3","e@mail.com" );p3.setCareBalance(Duration.ofMinutes(180));
		Person p4 = new Person("p4","e@mail.com" );p4.setCareBalance(Duration.ofMinutes(-30));
		return args -> {
			log.info("Preloading " + personRepo.save(p1));
			log.info("Preloading " + personRepo.save(p2));
			log.info("Preloading " + personRepo.save(p3));
			log.info("Preloading " + personRepo.save(p4));
			
			log.info("Preloading " + careRepo.save(new Care(p1,p2,"care1", LocalDateTime.of(2020, 1, 1, 10, 0), Duration.ofMinutes(90))));
			log.info("Preloading " + careRepo.save(new Care(p2,p3,"care2", LocalDateTime.of(2020, 1, 1, 10, 0), Duration.ofMinutes(150))));
			log.info("Preloading " + careRepo.save(new Care(p3,p4,"care3", LocalDateTime.of(2020, 1, 1, 10, 0), Duration.ofMinutes(90))));
			log.info("Preloading " + careRepo.save(new Care(p4,p3,"care4", LocalDateTime.of(2020, 1, 1, 10, 0), Duration.ofMinutes(120))));
		};
	}
}
