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
	
	//로그인페이지 이동
	@GetMapping("login")
	public String login() {
		
		return "member/login";
		
	}
	
	//회원가입 페이지이동
	@GetMapping("mInsert")
	public String mInsert() {
		return "member/mInsert";
		
	}
	
	//회원가입 저장
	@PostMapping("mInsert")
	@ResponseBody
	public String mInsert(MemberDto mdto) {
		System.out.println("MController idCheck mdto id : "+mdto.getId());
		System.out.println("MController idCheck mdto gender : "+mdto.getGender());
		
		//db전송
		String result = mService.mInsert(mdto);
		
		return result;
		
	}
	
	//ajax 로그인 아이디 체크
	@PostMapping("idCheck")
	@ResponseBody          //리턴을 jsp페이지가 아닌 data로 넘겨줌.
	public String idCheck(String id) {
		
		//db전송
		String result= mService.idCheck(id);
		System.out.println("MController idCheck mdto id : "+id);
		
		return result; //result는 ajax에 data로 넘겨짐.
		
	}
	
	//로그아웃 페이지
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
		
	}
	
	@PostMapping("login")
	public String login(String id, String pw, Model model) {
		
		int result = mService.login(id,pw);
		
		model.addAttribute("result",result);
		System.out.println("MController login result"+result);
		
		return "member/doLogin";
		
	}

}
