package com.ei.demo.core.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ei.demo.core.db.PersonRepository;
import com.ei.demo.core.model.Person;
import com.ei.demo.core.services.impl.PersonServiceImpl;

@ExtendWith(SpringExtension.class)
//@DataJpaTest
class PersonServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
 
        @Bean
        public PersonService employeeService() {
            return new PersonServiceImpl();
        }
    }

	
	@Autowired
	PersonService personService;
	@MockBean
//	@Autowired
	PersonRepository personRepository;
	
	@Test
	public void givenPersons_whenGetAll_shouldReturnList(){
		Person p1 = new Person("p1","p1@mail.com");
		Person p2 = new Person("p2","p1@mail.com");
		List<Person> sampleData = Arrays.asList(p1,p2);
		Mockito.when(personRepository.findAll()).thenReturn(sampleData);
	
		assertThat(personService.getAll(), contains(p1,p2));
	}
	
	@Test
	public void givenIdExists_whenGetById_shouldReturnOne(){
		Person p1 = new Person("p1","p1@mail.com");
		Mockito.when(personRepository.findById(Mockito.eq(1L))).thenReturn(Optional.of(p1));
	
		assertThat(personService.getById(1L).get(), is(p1));
		
	}
	
	@Test
	public void givenIdNotExists_whenGetById_shouldNotThrowException(){
		Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		assertThat(personService.getById(1L), is(Optional.empty()));
	}
	
	@Test
	public void givenNewPersonWithoutId_whenCreate_shouldReturnOneWithNewId(){
		Person p1 = new Person("p1","p1@mail.com");
		p1.setId(1L);

		Mockito.when(personRepository.save(Mockito.any())).thenReturn(p1);
		
		assertThat(personService.create(new Person()), is(p1));
	}
	
	@Test
	public void givenNewPersonWithId_whenCreate_shouldReturnOneWithNewId(){
		Person p1 = new Person("p1","p1@mail.com");
		p1.setId(1L);

		Mockito.when(personRepository.save(Mockito.any())).thenReturn(p1);
		
		assertThat(personService.create(new Person()), is(p1));
	}
//	
//	@Test
//	public void givenExistingPerson_whenUpdate_shouldReturnOneWithNewData(){
//		
//	}
//	
//	@Test
//	public void givenNonExistingPerson_whenUpdate_shouldReturnException(){
//		
//	}
//	
//	@Test
//	public void givenExistingPerson_whenDelete_shouldRemoveIt(){
//		
//	}
//	
//	@Test
//	public void givenNonExistingPerson_whenDelete_shouldReturnException(){
//		
//	}
	
/**
 * test cases
 * get all return list
 * get one existing
 * get one non existing
 * create one return one with id
 * create one with id - assign different id
 * update one existing
 * update one nonexisting
 * delete one existing
 * delete one nonexisting
 * 
 */
	
}
