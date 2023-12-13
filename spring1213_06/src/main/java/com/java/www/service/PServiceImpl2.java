package com.java.www.service;

import org.springframework.stereotype.Service;

@Service
public class PServiceImpl2 implements PService{

	@Override
	public void execute() {
		System.out.println("나는 PService version 2입니다. ");
		
	}

}
