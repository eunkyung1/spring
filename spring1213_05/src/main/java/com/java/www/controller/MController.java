package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;


@Controller
public class MController {
	
	@RequestMapping("member/memberInsert")
	public String memberInsert(Model model ) {
		//id를 전달
		String id = "admin";
		
		//1.이전버전
		//HttpServletRequest request;
		//request.setAttribute("id", id)
		
		
		//2.spring
		//현재날짜와 시간을 Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		MemberDto mdto 
		= new MemberDto("aaa", "1111", "홍씨", "010-1111-1111", "Male", "golf, game", mdate);
		
		model.addAttribute("mdto",mdto);
		//model.addAttribute("id",id);
		
		System.out.println("MemberDto id : "+mdto.getId()); //lombok이 필요함.
		return "member/memberInsert";
	}
	

}
