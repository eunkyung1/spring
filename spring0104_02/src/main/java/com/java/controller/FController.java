package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
public class FController {
	
	@Autowired BService bService;

	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("bwrite")
	public String bwrite() {
		
		return "bwrite";
	}
	@PostMapping("bwrite")
	public String bwrite(BoardDto bdto,@RequestParam(defaultValue = "1")int bno,@RequestPart MultipartFile file, Model model) throws Exception {
		if(!file.isEmpty()) {
			String orgFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+orgFName;
			String fupload = "c:/upload/";
			
			//파일서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			//bdto bfile 추가
			bdto.setBfile(upFName);
			
			//파일 저장위치
			String urllink = "/upload/"+upFName;
		}else {
			bdto.setBfile("");
		}
		System.out.println("파일첨부 이름 : "+bdto.getBfile());
		
		//service 연결 - 게시글 저장	
		bService.bwrite(bdto);
		model.addAttribute("result","write-s");
		
		return "doFboard";
	}
	@PostMapping("summernoteUpload")
	@ResponseBody
	public String summernoteUpload(@RequestPart MultipartFile file) throws Exception {
		String urllink="";
		if(!file.isEmpty()) {
			String orgName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+orgName;
			String fupload= "c:/upload/";
			
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			urllink = "/upload/"+upFName;
			System.out.println("summernoteUpload 파일 저장위치 : "+urllink);
			
			
		}
		
		return urllink;
	}
	
	
	@GetMapping("blist")
	public String blist(Model model) {
		List<BoardDto> list = bService.selectAll();
		
		model.addAttribute("list",list);
		
		return "blist";
	}
	
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1")int bno,BoardDto bdto,Model model) {
		bdto = bService.selectOne(bno);
		
		model.addAttribute("bdto",bdto);
		return "bview";
	}
}
