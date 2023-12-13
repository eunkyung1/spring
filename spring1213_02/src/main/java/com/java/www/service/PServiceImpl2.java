package com.java.www.service;

import org.springframework.stereotype.Service;

@Service
public class PServiceImpl2 implements PService {

	@Override
	public void execute() {
		System.out.println("'신규 service 버전2'을 호출할까요? 말까요? ");
	}

}
