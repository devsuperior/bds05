package com.devsuperior.movieflix.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTests {

	@Test
	public void movieShouldHaveCorrectStructure() {
	
		Movie entity = new Movie();
		entity.setId(1L);
		entity.setTitle("Title");
		entity.setSubTitle("Subtitle");
		entity.setSynopsis("Synopsis");
		entity.setYear(2021);
		entity.setImgUrl("https://imgurl.com/img.png");
		entity.setGenre(new Genre());
	
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getTitle());
		Assertions.assertNotNull(entity.getSubTitle());
		Assertions.assertNotNull(entity.getSynopsis());
		Assertions.assertNotNull(entity.getYear());
		Assertions.assertNotNull(entity.getImgUrl());
		Assertions.assertNotNull(entity.getGenre());
		Assertions.assertEquals(0, entity.getReviews().size());
	}
}
