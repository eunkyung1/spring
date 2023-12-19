package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;

	@GetMapping("login")
	public String login() {

		return "member/login";
	}
	
	@PostMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result = 0;
		MemberDto memberDto = mService.loginCheck(mdto);
		System.out.println("Mcontroller id : "+mdto.getId());
		System.out.println("Mcontroller pw : "+mdto.getPw());
		
		if(memberDto!=null) {
			request.setAttribute("session_id", memberDto.getId());
			request.setAttribute("session_nicName", memberDto.getName());
			result = 1;
		}
		model.addAttribute("result",result);
		return "member/doLogin";
		
	}
}
