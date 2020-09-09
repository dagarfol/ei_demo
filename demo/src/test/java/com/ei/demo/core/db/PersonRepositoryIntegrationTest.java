package com.ei.demo.core.db;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ei.demo.core.db.PersonRepository;
import com.ei.demo.core.model.Person;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void testRepoWorks() {
    	//given
    	Person p1 = new Person();
    	p1.setEmail("e@mail.com");
    	p1.setName("p1");
    	entityManager.persistAndFlush(p1);

    	Person p2 = new Person();
    	p2.setEmail("p2@mail.com");
    	p2.setName("p2");
    	entityManager.persistAndFlush(p2);
    	
    	//when
    	Iterable<Person> result = personRepository.findAll();
    	result.forEach(System.out::println);
    	
    	//then
    	assertThat(result).containsExactlyInAnyOrder(p1,p2);
    }
    
}
