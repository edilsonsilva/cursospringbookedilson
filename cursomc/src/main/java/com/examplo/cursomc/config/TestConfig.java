package com.examplo.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.examplo.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws Exception{
		dbService.instatiateTestDatabase();
		return true;
	}
}
