package com.ei.demo.rest.controllers;

import static org.mockito.Mockito.atLeastOnce;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ei.demo.core.model.Person;
import com.ei.demo.core.services.PersonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
class PersonControllerTest {
	private static String BASE_SERVICE_URI= "/api/persons";

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private PersonService personService;

	@Test
	void givenPersons_whenGetAll_thenReturnJsonArray() throws Exception {
		List<Person> sampleData = Arrays.asList(new Person("p1","p1@mail.com"),new Person("p2","p1@mail.com"));
		Mockito.when(personService.getAll()).thenReturn(sampleData);
		
		mvc.perform(get(BASE_SERVICE_URI))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(2)))
		.andReturn();
	}
	@Test
	void whenCreate_thenReturnJsonObject() throws Exception {
		Person sample = new Person("p3","p3@mail.com");
		Mockito.when(personService.create(Mockito.any())).thenReturn(sample);
		
		mvc.perform(post(BASE_SERVICE_URI).content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", Matchers.is(sample.getName())))
		;
	}
	@Test
	void whenGetById_thenReturnJsonObject() throws Exception {
		Person sample = new Person("p3","p3@mail.com");
		sample.setId(3L);
		Mockito.when(personService.getById(3L)).thenReturn(Optional.of(sample));
		
		mvc.perform(get(BASE_SERVICE_URI+"/3"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.is(sample.getId().intValue())))
		.andExpect(jsonPath("$.name", Matchers.is(sample.getName())))
		;
	}
	@Test
	void whenUpdate_thenReturnJsonObject() throws Exception {
		Person sample = new Person("p3","p3@mail.com");
		Mockito.when(personService.update(Mockito.eq(3l), Mockito.any())).thenReturn(sample);
		
		mvc.perform(put(BASE_SERVICE_URI+"/3").content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", Matchers.is(sample.getName())))
		;
	}
	@Test
	void whenDelete_thenReturnJsonObject() throws Exception {
		mvc.perform(delete(BASE_SERVICE_URI+"/3").content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		;

		Mockito.verify(personService, atLeastOnce()).delete(3L);
	}
}
