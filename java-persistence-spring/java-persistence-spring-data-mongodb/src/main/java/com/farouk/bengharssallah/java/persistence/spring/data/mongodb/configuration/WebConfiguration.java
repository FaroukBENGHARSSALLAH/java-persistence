package com.farouk.bengharssallah.java.persistence.spring.data.mongodb.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfiguration {

	 @Bean
	   public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	 
	 
	 
	
	 
	 
	 
	
	 
	 
	 
	 
}
