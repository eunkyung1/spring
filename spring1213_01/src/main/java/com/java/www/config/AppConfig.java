package com.java.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.www.service.PService;
import com.java.www.service.PServiceImpl;
import com.java.www.service.PServiceImpl2;

@Configuration
//Configuation - 객체선언 기능.
public class AppConfig {

	@Bean
	public PService pconfig(){
		return new PServiceImpl2();
	}
	
}
