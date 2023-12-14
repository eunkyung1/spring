package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.www.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("notice") //상위폴더
public class NController {
	
	@RequestMapping("noticeList") //폴더명이 들어가도, 안들어가도 무방 //파일명
	public String noticeList() {
		return "notice/noticeList"; //무조건 폴더명을 기입해야함.
	}
	
	//@RequestMapping(method=RequestMethod.GET, value="noticeList") // 정식임. 하지만 적지 않음.
	//public String noticeList() {
	//	return "notice/noticeList"; //무조건 폴더명을 기입해야함.
	//}

	
	@GetMapping("noticeInsert")
	public String noticeInsert() {
		
		return "notice/noticeInsert";
	}
	
	@PostMapping("doNoticeInsert")
	public String noticeInsert(HttpServletRequest request, Model model) {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bfile = request.getParameter("bfile");
		
		
		System.out.printf("제목 : %s, 내용 : %s, 파일 : %s",btitle,bcontent,bfile);
		
		model.addAttribute("btitle",btitle);
		model.addAttribute("bcontent",bcontent);
		model.addAttribute("bfile",bfile);
		
		Timestamp bdate = new Timestamp(System.currentTimeMillis());
	
		BoardDto bdto = 
				new BoardDto(1,"야야야", "내용이다",bdate, "aaa", 1, 0, 0, 1, "1.jpg");
		
		//-------------------생성자 생성
		BoardDto bbdto = BoardDto.builder()
				.btitle(btitle)
				.bcontent(bcontent)
				.bdate(bdate)
				.bfile(bfile).build();
		//builder - dto 순서 안 맞춰도 됨. 
		
		model.addAttribute("bdto",bdto);
		
		return "notice/noticeView";
		
	}
	
	@RequestMapping("noticeView")
	public String noticeView() {
		return "notice/noticeView";
	}
	

}
