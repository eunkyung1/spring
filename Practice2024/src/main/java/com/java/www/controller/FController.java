package com.java.www.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.www.dto.YmemberDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index(@RequestParam(defaultValue = "5")int searchCount,@RequestParam(defaultValue = "1")int page, Model model) {
		System.out.println(searchCount);
		
		Map<String, Object> map = bService.selectAll(searchCount,page);
		model.addAttribute("map",map);
		
		return "index";
	}// index
	
	@GetMapping("login")
	public String login() {
		return "login";
	}//login
	
	@PostMapping("login")
	public String login(String id, String pw, Model model ) {
		int result = 0;
		YmemberDto ymemberdto = bService.loginCheck(id,pw);
		if(ymemberdto != null) {
			session.setAttribute("session_id", ymemberdto.getId() );
			session.setAttribute("session_name", ymemberdto.getName() );
			result = 1;
		}
		
		model.addAttribute("result", result);
		return "doLogin";
	}
	
	@GetMapping("logout")
	public String logout(Model model) {
		String result = "success";
		session.invalidate();
		model.addAttribute("result",result);
		return "doLogout";
	}

	
	@GetMapping("memInfo")
	public String memInfo() {
		return "memInfo";
	}//memInfo
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "mInsert";
	}
	@GetMapping("mailList")
	public String mailList() {
		return "mailList";
	}

}// FController(컨트롤러)
