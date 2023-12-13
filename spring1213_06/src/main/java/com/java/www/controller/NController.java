package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NController {
	
	@RequestMapping("notice/noticelist")
	public String noticelist() {
		
		return "notice/noticelist";
	}
	@RequestMapping("notice/noticeview")
	public String noticeview() {
		
		return "notice/noticeview";
	}
	@RequestMapping("notice/noticewrite")
	public String noticewrite() {
		
		return "notice/noticewrite";
	}
	

}
