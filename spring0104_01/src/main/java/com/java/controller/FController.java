package com.java.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {

	@Autowired BService bService;
	@Autowired HttpSession session;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1") int bno,Model model) {
		BoardDto bdto = bService.selectOne(bno);
		model.addAttribute("bdto",bdto);
		
		return "bview";
	}
	
	@GetMapping("bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	//내용부분 - 이미지 추가 시, 호출.
	@PostMapping("summernoteUpload")
	@ResponseBody
	public String summernoteUpload(@RequestPart MultipartFile file) throws Exception{
		String urllink = "";
		if(!file.isEmpty()) {
			String oriFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+oriFName;
			String fupload = "c:/upload/";
			
			//파일서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			//파일 저장위치
			 urllink = "/upload/"+upFName;
			 System.out.println("summernoteUpload 파일 저장위치 : "+urllink);
		}
		return urllink;
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	
	//button버튼-> submit ->  클릭시 파일 업로드
	@PostMapping("write")
	public String write(BoardDto bdto,@RequestPart MultipartFile file ,Model model) throws Exception {
		System.out.println("FController write getBtitle "+bdto.getBtitle());
		System.out.println("FController write getBcontent "+bdto.getBcontent());
		if(!file.isEmpty()) {
			String oriFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+oriFName;
			String fupload = "c:/upload/";
			
			//파일서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			//bdto bfile추가
			bdto.setBfile(upFName);
			
			//파일 저장위치
			String urllink = "/upload/"+upFName;
		}else {
			bdto.setBfile("");
		}
		System.out.println("파일첨부 이름 : "+bdto.getBfile());
		
		//sevice연결 - 게시글 저장
		bService.write(bdto);
		model.addAttribute("result","write-s");
		return "doFboard";
	}
	
	@GetMapping("blist")
	public String blist(Model model) {
		//전체 게시글 가져오기
		List<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		
		return "blist";
	}
	
	
}
