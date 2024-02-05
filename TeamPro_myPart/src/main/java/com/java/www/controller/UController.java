package com.java.www.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.UsedDto;
import com.java.www.service.UsedService;

@Controller
@RequestMapping("used")
public class UController {
	
	@Autowired UsedService uService;
	
	
	//중고거래 및 양도 - 중고거래
	@GetMapping("used")
	public String used(@RequestParam(defaultValue = "1")int page ,Model model) {
		Map<String, Object> map =  uService.selectAll(page);
		model.addAttribute("map",map);
		
		return "/used/used";
	}// used()
	

	
	
	
	//중고거래 및 양도 - 양도
	@PostMapping("used_transfer")
	@ResponseBody
	public Map<String, Object> used_transfer(String u_btype,@RequestParam(defaultValue = "1")int page){
		System.out.println("UController used_transfer :"+u_btype);
		
		Map<String, Object> map =  uService.selectAll2(page);
		
		
		
		return map;
	}// used_transfer()
	
	
	//중고거래 거래가능 checked-true일때
	@PostMapping("possible_t")
	@ResponseBody
	public ArrayList<UsedDto> possible_t(String u_bstatus){
		System.out.println("UController used_transfer :"+u_bstatus);
		
		ArrayList<UsedDto> list = uService.selectPossible(u_bstatus);
		return list;
	}
	
	
	//중고거래 거래가능 checked- false일때
	@PostMapping("used_trade1")
	@ResponseBody
	public Map<String, Object> used_trade1(@RequestParam(defaultValue = "1")int page ,Model model) {
		Map<String, Object> map =  uService.selectAll(page);
		
		model.addAttribute("map",map);
		
		return map;
	}// used_trade1()
	
	//중고양도 거래가능 checked-true일때
	@PostMapping("possible_t2")
	@ResponseBody
	public ArrayList<UsedDto> possible_t2(String u_bstatus){
		System.out.println("UController used_transfer :"+u_bstatus);
		
		ArrayList<UsedDto> list2 = uService.selectPossible2(u_bstatus);
		return list2;
	}
	
	//중고양도 거래가능 checked- false일때
	@PostMapping("used_transfer2")
	@ResponseBody
	public Map<String, Object> used_transfer2(Model model,@RequestParam(defaultValue = "1")int page) {
		Map<String, Object> map =  uService.selectAll2(page);
		
		model.addAttribute("map",map);
		
		return map;
	}// used_trade1()
	
	
	
	//중고거래 및 양도 - 뷰
	@GetMapping("usedcontent")
	public String usedcontent(@RequestParam(defaultValue = "1")int u_bno, Model model ) {
		
		UsedDto udto = uService.selectOne(u_bno);
		model.addAttribute("udto",udto);
		
		return "/used/usedcontent";
	}// usedcontent()
	
	//중고거래 및 양도 - 글쓰기
	@GetMapping("usedWrite")
	public String usedWrite() {
		return "/used/usedWrite";
	}// usedWrite()

}
