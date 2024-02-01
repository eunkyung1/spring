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
	public String notice_view(@RequestParam(defaultValue = "1") int bno, Model model) {
		
		System.out.println("BController notice_view bno : "+bno);
		//service연결
		Map<String, Object> map = bService.selectOne(bno);
		
		//model 전송
		model.addAttribute("map",map);
		
		return "customer/notice_view";
	}
	
	//댓글 1개 저장
	@PostMapping("BCommentInsert") //1개 게시글 가져오기
	@ResponseBody
	public BCommentDto BCommentInsert(BCommentDto cdto) {
		
		System.out.println("BController BCommentInsert getBno : "+cdto.getBno());
		System.out.println("BController BCommentInsert getCcontent : "+cdto.getCcontent());
		//service연결- 저장시간, cno 가져오기
		BCommentDto bCommentDto = bService.bCommentInsert(cdto);
		
		return bCommentDto;
	}
	
	@PostMapping("BCommentDelete") //1개 게시글 가져오기
	@ResponseBody //ajax-데이터전송
	public String BCommentDelete(int cno) {
		
		System.out.println("BController BCommentInsert getBno : "+cno);
		//service연결 - 댓글 삭제
		String result = bService.BCommentDelete(cno);
		return "삭제처리";
	}
	
	@PostMapping("BCommentUpdate") //1개 게시글 가져오기
	@ResponseBody //ajax-데이터전송
	public BCommentDto BCommentUpdate(BCommentDto cdto) {
		System.out.println("BController BCommentInsert getCno : "+cdto.getCno());
		
		//service연결 - 댓글 삭제
		BCommentDto bCommentDto = bService.BCommentUpdate(cdto);
		return bCommentDto;
	}
	
	
	
	
}
