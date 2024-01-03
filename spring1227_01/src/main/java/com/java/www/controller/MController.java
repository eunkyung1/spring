package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.service.EmailService;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired MService mService;
	
	@Autowired HttpSession session;
	
	@Autowired EmailService emailService;

	//--------아이디 찾기
	@GetMapping("id")
	public String id() {
		return "member/id";
	}
	
	@GetMapping("idsearch")
	public String idsearch() {
		return "member/idsearch";
	}
	
	@PostMapping("memberSearch")
	@ResponseBody
	public String memberSearch(String name, String email) {
		
		System.out.println("MController memberSearch name :"+name);
		System.out.println("MController memberSearch email :"+email);
		String result = mService.memberSearch(name,email);
		session.setAttribute("result", result);
		
		
		return result;
	}
	//----------------------------
	
	
	
	@GetMapping("step01")
	public String step01() {
		return "member/step01";
	}
	@GetMapping("step03")
	public String step03() {
		return "member/step03";
	}

	
	@PostMapping("email")
	@ResponseBody
	public String email(String email) {
		System.out.println("MController email : "+email);
		
		//service연결-이메일주소 보냄.
		String result = emailService.mailSend(email);
		
		
		return result;
	}
	
	
	
	
	//-----login부분
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		String result = mService.idCheck(id);
		if(result!="1") {
			
			
			
		}
	
		
		
		
		return result;
	}
	
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
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
