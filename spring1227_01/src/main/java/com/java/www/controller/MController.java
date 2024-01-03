package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.dto.MemberDto2;
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
	
	@PostMapping("pwsearch")
	@ResponseBody
	public String pwsearch(String id, String email) {
		
		System.out.println("MController pwsearch id :"+id);
		System.out.println("MController pwsearch email :"+email);
		
		//service 연결 - 아이디와 이메일로 비밀번호 찾기
		String result = mService.pwsearch(id,email);
		
		
		return result;
	}
	//----------------------------
	
	
	//----회원가입----
	@GetMapping("step01")
	public String step01() {
		return "member/step01";
	}
	@GetMapping("step02")
	public String step02() {
		return "member/step02";
	}
	@GetMapping("step03")
	public String step03() {
		return "member/step03";
	}
	@PostMapping("step04")
	public String step04(MemberDto2 mdto2) {
		System.out.println("MController step04 phone : "+mdto2.getPhone());
		return "member/step04";
	}

	//step01 인증
	@PostMapping("email")
	@ResponseBody
	public String email(String email) {
		System.out.println("MController email : "+email);
		
		//service연결-이메일주소 보냄.
		String result = emailService.mailSend(email);
		System.out.println("MController email result : "+result);
		
		
		return result;
	}
	
	@PostMapping("PWsearch")
	@ResponseBody
	public String PWsearch(String cert_pw) {
		System.out.println("MController PWsearch cert_pw : "+cert_pw);
		String pwcode = (String)session.getAttribute("email_pwcode");
		String result = "fail";
		if(cert_pw.equals(pwcode)) result="success";
		System.out.println("PWsearch pwcode : "+pwcode);
		return result;
	}
	
	//--------
	
	
	
	
	//-----login부분
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		System.out.println("MController idCheck id : "+id);
		String result = mService.idCheck(id);
		
		
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
	public String ajaxLogin(MemberDto2 mdto2) {
		System.out.println("MController login id : "+mdto2.getId());
		System.out.println("MController login pw : "+mdto2.getPw());
		System.out.println("MController login session_id : "+ session.getAttribute("session_id") );
		
		int result = mService.login(mdto2);
		
		System.out.println("MController login result : "+result);
		
		
		return result+"" ;
	}
	
	//jsp 형태 //데이터를 페이지에 태워서 보내는 방법
	@PostMapping("login")
	public String MController(MemberDto2 mdto2, Model model) {
		
		System.out.println("MController login id : "+mdto2.getId());
		System.out.println("MController login pw : "+mdto2.getPw());
		System.out.println("MController login session_id : "+ session.getAttribute("session_id") );
		
		int result = mService.login(mdto2);
		
		model.addAttribute("result",result);
		return "member/doLogin";
	}
	//---로그인 확인부분 끝---------
	
	
	
	
	
	
	
}
