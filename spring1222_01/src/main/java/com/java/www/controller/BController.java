package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class BController {

	@GetMapping("notice")
	public String notice() {
		
		
		
		return "customer/notice";
	}
}
