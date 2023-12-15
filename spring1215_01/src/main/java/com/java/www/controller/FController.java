package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FController {

	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("mLogin")
	public String mLogin(
			String id,
			String pw,
			Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		System.out.println("controller id "+id);
		System.out.println("controller pw "+pw);
		return "/mLogin";
	}
	
	
	
	//--------------Board관련
	
	//@ResponseBody // -> String 타입으로 리턴
	@RequestMapping("bInsert")
	public String bInsert() {
		return "bInsert"; 
	}
	
	@RequestMapping("bView")
	public String bView(BoardDto bdto, MemberDto mdto, Model model) {
		System.out.println("controller bView bdto. id : "+bdto.getId());
		System.out.println("controller bView mdto. id : "+mdto.getId());
		model.addAttribute("bdto",bdto);
		return "bView";
	}
	
	@RequestMapping("bUpdate")
	public String bUpdate(BoardDto bdto, Model model ) {
		model.addAttribute("bdto",bdto);
		return "bUpdate";
	}
	
	
	
	
}
