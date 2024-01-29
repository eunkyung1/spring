package com.java.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.UsedDto;
import com.java.www.service.UsedService;

@Controller
@RequestMapping("used")
public class UController {
	
	@Autowired UsedService uService;
	
	
	//중고거래 및 양도
	@GetMapping("used")
	public String used(Model model) {
	List<UsedDto> list =  uService.selectAll();
	
	model.addAttribute("list",list);
	System.out.println("list 갯수 :"+list.size());
		
		return "/used/used";
	}// used()
	
	
	
	//중고거래 및 양도 - 뷰
	@PostMapping("used_transfer")
	@ResponseBody
	public List<UsedDto> used_transfer(String u_btype) throws Exception {
		System.out.println("UController used_transfer :"+u_btype);
		
		List<UsedDto> list2 =  uService.selectAll2();
		
		
		
		return list2;
	}// used_transfer()
	
	//중고거래 및 양도 - 뷰
	@GetMapping("usedcontent")
	public String usedcontent() {
		return "/used/usedcontent";
	}// usedcontent()
	
	//중고거래 및 양도 - 글쓰기
	@GetMapping("usedWrite")
	public String usedWrite() {
		return "/used/usedWrite";
	}// usedWrite()

}
