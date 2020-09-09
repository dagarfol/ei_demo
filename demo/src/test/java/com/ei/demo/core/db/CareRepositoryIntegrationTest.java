package com.ei.demo.core.db;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ei.demo.core.db.CareRepository;
import com.ei.demo.core.model.Care;
import com.ei.demo.core.model.Person;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CareRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CareRepository careRepository;

	@Test
	void testRepoWorks() {
    	//given
    	Person p1 = new Person();
    	p1.setEmail("e@mail.com");
    	p1.setName("p1");
    	entityManager.persistAndFlush(p1);

    	Person p2 = new Person();
    	p2.setEmail("p2@mail.com");
    	p2.setName("p2");
    	entityManager.persistAndFlush(p2);
    	
    	Care c1 = new Care();
    	c1.setDateTime(LocalDateTime.of(2020, 1, 1, 10, 0));
    	c1.setDuration(Duration.ofHours(2));
    	c1.setParent(p1);
    	c1.setBabysitter(p2);
    	entityManager.persistAndFlush(c1);

    	Care c2 = new Care();
    	c2.setDateTime(LocalDateTime.of(2020, 1, 2, 10, 0));
    	c2.setDuration(Duration.ofHours(2));
    	c2.setParent(p2);
    	c2.setBabysitter(p1);
    	entityManager.persistAndFlush(c2);
    	
    	//when
    	//when
    	Iterable<Care> result = careRepository.findAll();
    	result.forEach(System.out::println);
    	
    	//then
    	assertThat(result).containsExactlyInAnyOrder(c1,c2);

	}

}
