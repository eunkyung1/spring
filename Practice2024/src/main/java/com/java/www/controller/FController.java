package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		return "index";
	}// index
	
	@GetMapping("login")
	public String login() {
		return "login";
	}//login
	
	@GetMapping("memInfo")
	public String memInfo() {
		return "memInfo";
	}//memInfo
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "mInsert";
	}

}// FController(컨트롤러)
