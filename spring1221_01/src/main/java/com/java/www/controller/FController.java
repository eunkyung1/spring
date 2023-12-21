package com.java.www.controller;

import java.util.ArrayList;

import javax.swing.SwingContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.EmpDepDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.service.EService;

@Controller
public class FController {
	
	@Autowired
	EService eService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		
		ArrayList<EmpDto> list = eService.selectAll();
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@GetMapping("list2")
	public String list2(Model model) {
		
		ArrayList<EmpDepDto> list = eService.selectAll2();
		
		model.addAttribute("list",list);
		
		return "list2";
	}
	
	@GetMapping("list3")
	public String list3(Model model) {
		
		ArrayList<MemBoardDto> list = eService.selectAll3();
		
		model.addAttribute("list",list);
		
		return "list3";
	}
}
