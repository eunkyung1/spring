package com.java.www.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration // @Component, @Configuration, @Service, @controller, @Repository
public class UploadConfig implements WebMvcConfigurer{
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/upload/");	 // /upload/로 들어오는 파일은 file///c:/upload를 통해서 파일을 찾으라는 명령어.
		
		//파일 더 추가할 경우 위에 내용 복사하면 됨.
		
		//registry.addResourceHandler("/movie/**").addResourceLocations("file:///c:/movie/"); // /upload/로 들어오는 파일은 file///c:/upload를 통해서 파일을 찾으라는 명령어.
	
		// 위의 내용을 제외한 모든 url 링크는 views에서 찾고, css/image/js는 static에서 찾음.
	
	}

}
