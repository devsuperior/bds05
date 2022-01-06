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
public class MovieControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TokenUtil tokenUtil;

	private long existingId;
	private long nonExistingId;
	
	private String visitorUsername;
	private String visitorPassword;
	private String memberUsername;
	private String memberPassword;
	
	@BeforeEach
	void setUp() throws Exception {

		existingId = 1L;
		nonExistingId = 100000L;
		
		visitorUsername = "bob@gmail.com";
		visitorPassword = "123456";
		memberUsername = "ana@gmail.com";
		memberPassword = "123456";
	}

	@Test
	public void findByIdShouldReturnUnauthorizedWhenNoTokenGiven() throws Exception {

		ResultActions result =
				mockMvc.perform(get("/movies/{id}", existingId)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnauthorized());
	}	

	@Test
	public void findByIdShouldReturnMovieWhenUserVisitorAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, visitorUsername, visitorPassword);
		
		ResultActions result =
				mockMvc.perform(get("/movies/{id}", existingId)
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.title").isNotEmpty());
		result.andExpect(jsonPath("$.subTitle").isNotEmpty());
		result.andExpect(jsonPath("$.year").isNotEmpty());
		result.andExpect(jsonPath("$.imgUrl").isNotEmpty());
		result.andExpect(jsonPath("$.synopsis").isNotEmpty());
		result.andExpect(jsonPath("$.genre").isNotEmpty());
		result.andExpect(jsonPath("$.genre.id").isNotEmpty());
		result.andExpect(jsonPath("$.genre.name").isNotEmpty());
	}

	@Test
	public void findByIdShouldReturnMovieWhenMemberAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, memberUsername, memberPassword);
		
		ResultActions result =
				mockMvc.perform(get("/movies/{id}", existingId)
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.id").value(existingId));
		result.andExpect(jsonPath("$.title").isNotEmpty());
		result.andExpect(jsonPath("$.subTitle").isNotEmpty());
		result.andExpect(jsonPath("$.year").isNotEmpty());
		result.andExpect(jsonPath("$.imgUrl").isNotEmpty());
		result.andExpect(jsonPath("$.synopsis").isNotEmpty());
		result.andExpect(jsonPath("$.genre").isNotEmpty());
		result.andExpect(jsonPath("$.genre.id").isNotEmpty());
		result.andExpect(jsonPath("$.genre.name").isNotEmpty());
	}

	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, visitorUsername, visitorPassword);
		
		ResultActions result =
				mockMvc.perform(get("/movies/{id}", nonExistingId)
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isNotFound());
	}
	
	@Test
	public void findByGenreShouldReturnUnauthorizedWhenNoTokenGiven() throws Exception {

		ResultActions result =
				mockMvc.perform(get("/movies")
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isUnauthorized());
	}

	@Test
	public void findByGenreShouldReturnOrderedPageWhenVisitorAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, visitorUsername, visitorPassword);

		ResultActions result =
				mockMvc.perform(get("/movies")
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		
		result.andExpect(jsonPath("$.content[0].id").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].title").value("A Voz do Silêncio"));
		result.andExpect(jsonPath("$.content[0].subTitle").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].year").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].imgUrl").isNotEmpty());

		result.andExpect(jsonPath("$.content[1].title").value("Bob Esponja"));
		result.andExpect(jsonPath("$.content[2].title").value("Código de Conduta"));
		result.andExpect(jsonPath("$.content[3].title").value("Kingsman"));
		result.andExpect(jsonPath("$.content[4].title").value("O Labirinto do Fauno"));
	}

	@Test
	public void findByGenreShouldReturnOrderedPageWhenMemberAuthenticated() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, memberUsername, memberPassword);
		
		ResultActions result =
				mockMvc.perform(get("/movies")
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		
		result.andExpect(jsonPath("$.content[0].id").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].title").value("A Voz do Silêncio"));
		result.andExpect(jsonPath("$.content[0].subTitle").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].year").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].imgUrl").isNotEmpty());

		result.andExpect(jsonPath("$.content[1].title").value("Bob Esponja"));
		result.andExpect(jsonPath("$.content[2].title").value("Código de Conduta"));
		result.andExpect(jsonPath("$.content[3].title").value("Kingsman"));
		result.andExpect(jsonPath("$.content[4].title").value("O Labirinto do Fauno"));
	}

	@Test
	public void findByGenreShouldReturnFilteredMoviesWhenGenreIsInformed() throws Exception {

		String accessToken = tokenUtil.obtainAccessToken(mockMvc, visitorUsername, visitorPassword);

		long genreId = 1L;
		
		ResultActions result =
				mockMvc.perform(get("/movies?genreId=" + genreId)
					.header("Authorization", "Bearer " + accessToken)
					.contentType(MediaType.APPLICATION_JSON));

		result.andExpect(status().isOk());
		
		result.andExpect(jsonPath("$.content[0].id").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].title").value("Bob Esponja"));
		result.andExpect(jsonPath("$.content[0].subTitle").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].year").isNotEmpty());
		result.andExpect(jsonPath("$.content[0].imgUrl").isNotEmpty());

		result.andExpect(jsonPath("$.content[1].title").value("Kingsman"));
		result.andExpect(jsonPath("$.content[2].title").value("Sonic"));
	}
}
