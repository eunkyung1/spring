package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")
public class MController {

	@Autowired
	MService mService;
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model,HttpServletRequest request) {
		int result=0;
		
		//db연결
		MemberDto memberDto = mService.loginSelect(mdto);
		if(memberDto !=null) {
			System.out.println("MController doLogin memberDto id: "+memberDto.getId());
			result = 1;
		}else {
			System.out.println("MController memberDto : null");
		}
		
		model.addAttribute("result",result);
	
		
		return "member/doLogin";
	}
	

}
