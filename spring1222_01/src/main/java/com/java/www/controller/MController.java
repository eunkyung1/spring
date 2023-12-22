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
		return
				"member/login";
	}
	//로그인 확인
	@PostMapping("login") 
	public String login(String id, String pw, Model model) {
		System.out.println("login id :"+id);
		
		int result= mService.loginCheck(id,pw);
		
		System.out.println("MController result : "+result);
		model.addAttribute("result",result);
		return "member/doLogin";
	}
	@GetMapping("join01")
	public String join01() {
		return "member/join01";
	}
	
	@GetMapping("join02")
	public String join02() {
		return "member/join02";
	}
	
	@PostMapping("join02")
	public String join02(Model model) {
		return "member/join02";
	}
	
	@PostMapping("mInsert")
	@ResponseBody
	public String mInsert(MemberDto mdto, String f_tell,String m_tell, String l_tell) {
		
		String phone = f_tell+"-"+m_tell+"-"+l_tell;
		mdto.setPhone(phone);
		
		String result = mService.mInsert(mdto);
		return result;
	}
	
	
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		System.out.println("MController idCheck id : "+id);
		String result = "사용가능";
		
		//db접근
		result = mService.idCheck(id);
		
		return result;
	}
	
	@GetMapping("join03")
	public String join03() {
		return "member/join03";
	}
	
	
	
}
