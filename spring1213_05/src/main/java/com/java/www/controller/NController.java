package com.java.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notice")
public class NController {
	
	@RequestMapping("noticeList") //폴더명이 들어가도, 안들어가도 무방
	public String noticeList() {
		return "notice/noticeList"; //무조건 폴더명을 기입해야함.
	}

	
	@RequestMapping("noticeInsert")
	public String noticeInsert() {
		return "notice/noticeInsert";
	}
	
	@RequestMapping("noticeView")
	public String noticeView() {
		return "notice/noticeView";
	}

}
