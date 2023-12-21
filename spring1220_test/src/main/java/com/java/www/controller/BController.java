package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("bList")
	public String bList(BoardDto bdto, Model model) {
		
		ArrayList<BoardDto> list = bService.selectAll();
		
		model.addAttribute("list",list);
		
		return "board/bList";
	}
	
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1")int bno, BoardDto bdto, Model model) {
		
		Map<String , Object> map = bService.selectOne(bno);
		
		model.addAttribute("map",map);
		
		
		return "board/bView";
	}
	
	@GetMapping("bInsert")
	public String bInsert() {
		return "board/bInsert";
	}
	
	@PostMapping("bInsert")
	public String bInsert(@RequestPart MultipartFile files, BoardDto bdto, Model model) throws Exception {
		
		String orgName="";
		String newName="";
		if(!files.isEmpty()) {
			orgName=files.getOriginalFilename();
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}else {
			bdto.setBfile("");
			System.out.println("파일 첨부가 없습니다.");
		}
		bdto.setId((String)session.getAttribute("session_id"));
		bService.bInsert(bdto);
		
		
		return "board/doBInsert";
	}
	
	@PostMapping("bUpdate")
	public String bUpdate(@RequestParam(defaultValue = "1")int bno, BoardDto bdto, Model model) {
		Map<String, Object> map = bService.selectOne(bno);

		model.addAttribute("map", map);

		return "board/bUpdate";
	}
	
	
	@PostMapping("doBUpdate")
	public String doBUpdate(@RequestPart MultipartFile files, BoardDto bdto) throws Exception {
		
		String orgName="";
		String newName="";
		if(!files.isEmpty()) {
			orgName=files.getOriginalFilename();
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}


		return "board/doBUpdate";
	}
	
	@PostMapping("bDelete")
	public String bDelete(@RequestParam(defaultValue = "1")int bno) {
		bService.bDelete(bno);
		return "board/bDelete";
	}
	
	@PostMapping("bReply")
	public String bReply(@RequestParam(defaultValue = "1")int bno, BoardDto bdto, Model model) {
		System.out.println("BController bUpdate bno : "+bno);
		Map<String,Object> map = bService.selectOne(bno);
		
		model.addAttribute("map",map);
		return "board/bReply";
	}
	
	@PostMapping("doBReply")
	public String doBReply(@RequestPart MultipartFile files, BoardDto bdto, Model model) throws Exception {
	
		String orgName="";
		String newName="";
		if(!files.isEmpty()) {
			orgName=files.getOriginalFilename();
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}else {
			bdto.setBfile("");
			System.out.println("파일 첨부가 없습니다.");
		}
		
		bService.doBReply(bdto);
		
		
		
		return "board/doBReply";
	}

}
