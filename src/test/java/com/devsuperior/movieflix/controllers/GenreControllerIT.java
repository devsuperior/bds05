package com.devsuperior.movieflix.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.tests.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GenreControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TokenUtil tokenUtil;
	
	private String visitorUsername;
	private String visitorPassword;
	private String memberUsername;
	private String memberPassword;
	
	@BeforeEach
	void setUp() throws Exception {
		
		visitorUsername = "bob@gmail.com";
		visitorPassword = "123456";
		memberUsername = "ana@gmail.com";
		memberPassword = "123456";
	}

	@Test
	public void findAllShouldReturnUnauthorizedWhenNotValidToken() throws Exception {

		ResultActions result =
				mockMvc.perform(get("/genres")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void findAllShouldReturnAllGenresWhenVisitorAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, visitorUsername, visitorPassword);
		
		ResultActions result =
				mockMvc.perform(get("/genres")
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$[0].id").value(1L));
		result.andExpect(jsonPath("$[0].name").value("Comédia"));
		result.andExpect(jsonPath("$[1].id").value(2L));
		result.andExpect(jsonPath("$[1].name").value("Terror"));
		result.andExpect(jsonPath("$[2].id").value(3L));
		result.andExpect(jsonPath("$[2].name").value("Drama"));
	}
	
	@Test
	public void findAllShouldReturnAllGenresWhenMemberAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, memberUsername, memberPassword);

		ResultActions result =
				mockMvc.perform(get("/genres")
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$[0].id").value(1L));
		result.andExpect(jsonPath("$[0].name").value("Comédia"));
		result.andExpect(jsonPath("$[1].id").value(2L));
		result.andExpect(jsonPath("$[1].name").value("Terror"));
		result.andExpect(jsonPath("$[2].id").value(3L));
		result.andExpect(jsonPath("$[2].name").value("Drama"));		
	}
}
