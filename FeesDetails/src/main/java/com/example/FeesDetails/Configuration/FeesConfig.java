package com.example.FeesDetails.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeesConfig {

	 @Bean
	    public ModelMapper modelMapperBean() {
	        return new ModelMapper();
	    }
}
