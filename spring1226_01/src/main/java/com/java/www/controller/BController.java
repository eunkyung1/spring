package com.java.www.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class BController {

	@Autowired
	BService bService;
	@Autowired HttpSession session;
	
	
	@GetMapping("notice")
	public String notice(Model model) {
		//page 가지고 와야함.
		
		//service연결
		ArrayList<BoardDto> list = bService.selectAll();
		
		//model전송
		model.addAttribute("list", list);
		
		
		
		
		return "customer/notice";
	}
	
	@GetMapping("notice_view")
	public String notice_view(@RequestParam(defaultValue = "1")int bno, Model model) {
		System.out.println("BController notice_view bno : "+bno);
		
		//db접근
		Map<String, Object> map = bService.selectOne(bno);
		
		model.addAttribute("map",map);
		return "customer/notice_view";
	}
	
	//ajax 댓글 입력
	@PostMapping("BCommentInsert")
	@ResponseBody
	public BCommentDto BCommentInsert(BCommentDto cdto) { //cdate - cno,cdate 없음
		System.out.println("BController BCommentInsert getCcontent : "+cdto.getCcontent());
		System.out.println("BCommentInsert BCommentInsert getCpw : "+cdto.getCpw()); 
		System.out.println("BCommentInsert BCommentInsert getBno : "+cdto.getBno()); 
		
		//id 추가
		cdto.setId((String)session.getAttribute("session_id"));
		
		//db에 저장된 댓글 1개 가져오기 - cno, cdate가 포함되어 있음.
		BCommentDto bCommentDto = bService.bCommentInsert(cdto); //bCommentDto - cno,cdate 포함되어있음.
		
		return bCommentDto;
	}
	
	
	
	
}
