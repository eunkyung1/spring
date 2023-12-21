package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	@PostMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model,HttpServletRequest request) {
		int result = 0;
		MemberDto memberDto = mService.loginCheck(mdto);
		
		if(memberDto!=null) {
			session.setAttribute("session_id",memberDto.getId());
			session.setAttribute("session_nicName", memberDto.getName());
			System.out.println("MController memberDto loginCheck : "+memberDto.getId());
			result=1;
		}
		
		model.addAttribute("result",result);
		
		return "member/doLogin";
	}

}
