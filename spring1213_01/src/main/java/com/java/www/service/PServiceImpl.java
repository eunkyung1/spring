package com.java.www.service;

import org.springframework.stereotype.Component;

@Component 
//@Component -자동으로 객체선언
public class PServiceImpl implements PService{

	@Override
	public void execute() {
		System.out.println("1B 연필로 그림을 그립니다.");
		
	}

}
