package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;

@Controller
public class MController {
	
	@RequestMapping("member/memberwrite")
	public String memberwrite(Model model) {
		
		
	
	Timestamp mdate = new Timestamp(System.currentTimeMillis());
	MemberDto mdto = 
			new MemberDto("aaa", "1111", "홍씨", "010-1111-1111", "Male", "golf, game", mdate);
	
	model.addAttribute("mdto",mdto);

	return "member/memberwrite";
	}
}
