package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;

	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	@GetMapping("idsearch")
	public String idsearch() {
		session.invalidate();
		return "member/idsearch";
	}
	
	//---로그인 확인부분---------
	//ajax 로그인 //데이터를 직접 보내는 방법
	@PostMapping("ajaxLogin")
	@ResponseBody
	public String ajaxLogin(MemberDto mdto) {
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		System.out.println("MController login session_id : "+ session.getAttribute("session_id") );
		
		int result = mService.login(mdto);
		
		System.out.println("MController login result : "+result);
		
		
		return result+"" ;
	}
	
	//jsp 형태 //데이터를 페이지에 태워서 보내는 방법
	@PostMapping("login")
	public String MController(MemberDto mdto, Model model) {
		
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		System.out.println("MController login session_id : "+ session.getAttribute("session_id") );
		
		int result = mService.login(mdto);
		
		model.addAttribute("result",result);
		return "member/doLogin";
	}
	//---로그인 확인부분 끝---------
	
	
	
	
}
