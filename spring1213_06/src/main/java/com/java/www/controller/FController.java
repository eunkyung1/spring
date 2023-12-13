package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.service.PService;

@Controller
public class FController {
	
	@Autowired
	PService pService;
	
	@RequestMapping("/")
	public String index() {
		pService.execute();
		return "index";
	}
	
	
	

}
