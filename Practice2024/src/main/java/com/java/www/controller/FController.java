package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.service.BService;

@Controller
public class FController {
	@Autowired BService bService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}// index
	
	@GetMapping("login")
	public String login() {
		return "login";
	}//login
	@PostMapping("login")
	public String login(String id, String pw) {
		 int result = BService.logincheck(id,pw);
		
		return "/doLogin";
	}
	
	
	@GetMapping("memInfo")
	public String memInfo() {
		return "memInfo";
	}//memInfo
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "mInsert";
	}
	@GetMapping("mailList")
	public String mailList() {
		return "mailList";
	}

}// FController(컨트롤러)
