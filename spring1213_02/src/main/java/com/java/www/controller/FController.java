package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.service.PService;

@Controller
public class FController {
	
	@Autowired
	PService pService;
	
	
	@GetMapping("/")  //GetMapping(보여줌/get으로 들어오는 것만 받음), PostMapping(숨김/post으로 들어오는 것만 받음), RequestMapping(둘다) 3종류가 있음. 
	public String index() {
		pService.execute();
		return "index";
	}
	
	@GetMapping("list")
	public String list() {
		return "list";
	}
	
	@GetMapping("mwrite")
	public String mwrite() {
		return "mwrite";
	}
	
}
