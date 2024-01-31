package com.java.www.controller;


import java.io.File;
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

import com.java.www.dto.NBoardDto;
import com.java.www.service.NBoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("community")
public class CController {
	
	
	@Autowired NBoardService nbService;
	@Autowired HttpSession session;
	
	
	//1.공지사항 리스트
	@GetMapping("nList")
	public String nList(Model model,@RequestParam(defaultValue = "1")int page,@RequestParam(required = false) String searchTitle,
			@RequestParam(required = false) String searchWord) {
		
		//service 연결
		Map<String, Object> map = nbService.selectAll(page);
		
		model.addAttribute("map",map);
		
		return "/community/nList";
		
	}// nList()
	
	//1.공지사항 게시글 보기
	@GetMapping("nView")
	public String nView(@RequestParam(defaultValue = "1") int n_bno, Model model) {
		
		System.out.println("CController nView bno :"+n_bno);
		
		NBoardDto nboardDto = nbService.selectOne(n_bno);
		model.addAttribute("nbdto",nboardDto);
		
		
		
		return "/community/nView";
	}// nView()
	
	//1.공지사항 게시글작성 페이지
	@GetMapping("nWrite")
	public String nWrite() {
		return "/community/nWrite";
	}// nWrite()
	
	@PostMapping("nWrite")
	public String nWrite(@RequestPart MultipartFile files1, NBoardDto nbdto) throws Exception {
		
		if(!files1.isEmpty()) {
			System.out.println("파일이 있어요!!!");
			String orgName = files1.getOriginalFilename();
			System.out.println("CController nWrite 파일첨부 이름 :"+orgName);
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName;
			String upload="C:/upload/";
			File f = new File(upload+newName);
			files1.transferTo(f);
			nbdto.setN_bfile(newName);
		}else {
			nbdto.setN_bfile("");
			System.out.println("파일 첨부가 없습니다.");
		}
		
		nbService.bWrite(nbdto);
		
		
		return "/community/doBnWrite";
	}// nWrite()
	
	//1.공지사항 글수정 페이지
	@GetMapping("nUpdate")
	public String nUpdate() {
		return "/community/nUpdate";
	}// nUpdate()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////공지사항 게시판

	//2.파티원 모집 게시판Pg
	@GetMapping("pList")
	public String partyList() {
		return "/community/pList";
	}// pList()
	
	//2.파티원 모집 게시글보기 Pg
	@GetMapping("pView")
	public String pView() {
		return "/community/pView";
	}// pView()
	
	//2.파티원 모집 작성Pg
	@GetMapping("pWrite")
	public String pWrite() {
		return "/community/pWrite";
	}// pView()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////파티원 모집 게시판
	
	//3.꿀팁 게시판 리스트Pg
	@GetMapping("tList")
	public String tipList() {
		return "/community/tList";
	}// tList()
	
	//3.꿀팁 게시글 보기Pg
	@GetMapping("tView")
	public String tView() {
		return "/community/tView";
	}// tView()
	
	//3.꿀팁 게시글 작성Pg
	@GetMapping("tWrite")
	public String tWrite() {
		return "/community/tWrite";
	}// tWrite()
	
	//3. 꿀팁 게시글 수정Pg
	@GetMapping("tUpdate")
	public String tUpdate() {
		return "/community/tUpdate";
	}// tUpdate()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////꿀팁 게시판
	
	//4.자유 게시판 리스트Pg
	@GetMapping("fList")
	public String fList() {
		return "/community/fList";
	}// fList()

	//4.자유 게시글 보기Pg
	@GetMapping("fView")
	public String fView() {
		return "/community/fView";
	}// fView()
	
	//4.자유 게시글 작성Pg
	@GetMapping("fWrite")
	public String fWrite() {
		return "/community/fWrite";
	}// fWrite()
	
	//4.자유게시글 수정Pg
	@GetMapping("fUpdate")
	public String fUpdate() {
		return "/community/fUpdate";
	}// fUpdate()
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////자유 게시판

}// CController
