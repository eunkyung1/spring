package com.java.www.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration 
public class UploadConfig {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/"); // /upload/로 들어오는 파일은 file///c:/upload를 통해서 파일을 찾으라는 명령어.
		
	}

}
