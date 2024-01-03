package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Mcontroller {
	
	@Autowired EmailService emailService;
	@Autowired HttpSession session;
	
	@RequestMapping("/")
	public String index() {
		return"index";
	}
	
	@PostMapping("email")
	@ResponseBody
	public String email(String name, String email) {
		System.out.println("Mcontroller name :"+name);
		System.out.println("Mcontroller email :"+email);
		
		//service 연결 - text 이메일 발송
		//String result = emailService.emailSend(name,email);
		
		//service 연결 - html 이메일 발송
		String result = emailService.emailSend2(name,email);
		
		return "success : "+result;
	}
	
	@PostMapping("emailCheck")
	@ResponseBody
	public String ememailCheckail(String check) {
		System.out.println("Mcontroller check :"+check);

		//service 연결 - 인증번호 확인 : db연결해서 확인, session
		String result = "fail";
		String pwcode = (String)session.getAttribute("email_pwcode");
		if(check.equals(pwcode)) {
			result="success";
		}
		session.invalidate();
		return result;
	}
}
