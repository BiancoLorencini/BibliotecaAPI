package br.org.serratec.biblioteca.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
	
	@Bean
	ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
}
