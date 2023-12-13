package com.java.www.service;

import org.springframework.stereotype.Service;


public class PServiceImpl implements PService {

	@Override
	public void execute() {
		System.out.println("'service 버전1'을 호출할까요? 말까요? ");
	}

}
