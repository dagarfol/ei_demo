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

import com.ei.demo.core.model.Care;
import com.ei.demo.core.services.CareService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CareController.class)
public class CareControllerTest {
	private static String BASE_SERVICE_URI= "/api/cares";

    @Autowired
    private MockMvc mvc;
    
    @MockBean
	private CareService careService;
    
    @Test
    public void whenNoCareExist_thenEmptyListShouldBeReturned() throws Exception {
    	mvc.perform(get(BASE_SERVICE_URI))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$", Matchers.empty()))
    	;
    }
    
	@Test
	void givenCares_whenGetAll_thenReturnJsonArray() throws Exception {
		List<Care> sampleData = Arrays.asList(new Care(),new Care());
		Mockito.when(careService.getAll()).thenReturn(sampleData);
		
		mvc.perform(get(BASE_SERVICE_URI))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(2)))
		.andReturn();
	}

	@Test
	void whenCreate_thenReturnJsonObject() throws Exception {
		Care sample = new Care();
		sample.setId(3L);
		Mockito.when(careService.create(Mockito.any())).thenReturn(sample);
		
		mvc.perform(post(BASE_SERVICE_URI).content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.is(sample.getId().intValue())))
		;
	}
	@Test
	void whenGetById_thenReturnJsonObject() throws Exception {
		Care sample = new Care();
		sample.setId(3L);
		Mockito.when(careService.getById(3L)).thenReturn(Optional.of(sample));
		
		mvc.perform(get(BASE_SERVICE_URI+"/3"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.is(sample.getId().intValue())))
		;
	}
	@Test
	void whenUpdate_thenReturnJsonObject() throws Exception {
		Care sample = new Care();
		sample.setId(3L);
		sample.setDescription("sample");
		Mockito.when(careService.update(Mockito.eq(3l), Mockito.any())).thenReturn(sample);
		
		mvc.perform(put(BASE_SERVICE_URI+"/3").content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.description", Matchers.is(sample.getDescription())))
		;
	}
	@Test
	void whenDelete_thenReturnJsonObject() throws Exception {
		mvc.perform(delete(BASE_SERVICE_URI+"/3").content("{}").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
		.andExpect(status().isOk())
		;

		Mockito.verify(careService, atLeastOnce()).delete(3L);
	}
	
}
