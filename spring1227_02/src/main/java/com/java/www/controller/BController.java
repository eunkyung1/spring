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
	
	@GetMapping("notice_view") //1개 게시글 가져오기
	public String notice_view(@RequestParam(defaultValue = "1")int bno, Model model) {
		
		Map<String, Object>  map = bService.selectOne(bno);
		
		model.addAttribute("map",map);
		return "customer/notice_view";
	}
	
	//게시글 1개 저장하기.
	@PostMapping("BCommentInsert") 
	@ResponseBody
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		BCommentDto bCommentDto = bService.BCommentInsert(cdto);
	
		return bCommentDto;
	}
	
	//게시글 1개 삭제하기
	@PostMapping("BCommentDelete") 
	@ResponseBody
	public String BCommentDelete(int cno) {
		String result = bService.BCommentDelete(cno);
		
		
		
		return "삭제";
	}

	
	
	
}
