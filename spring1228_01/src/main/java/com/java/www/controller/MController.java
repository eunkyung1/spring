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

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	//-----로그인 확인부분
	//-------ajax형태
	
	
	@PostMapping("ajaxLogin")
	@ResponseBody
	public String ajaxLogin(MemberDto mdto) {
		System.out.println("MController ajaxLogin id : "+mdto.getId());
		
		//service연결
		int result = mService.login(mdto);
		
		return result+"";
	}
	@GetMapping("step03")
	public String step03() {
		return "member/step03";
	}
	
	@PostMapping("step03")
	public String step03(Model model) {
		return "member/step03";
	}
	
	

}
