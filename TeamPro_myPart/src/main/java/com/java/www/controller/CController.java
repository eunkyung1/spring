package com.java.www.controller;

import java.io.File;
import java.util.Map;

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

import com.java.www.dto.NBoardDto;
import com.java.www.dto.NCommentDto;
import com.java.www.service.NBoardService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("community")
public class CController {

	@Autowired
	NBoardService nbService;
	@Autowired
	HttpSession session;

	// 1.공지사항 리스트
	@GetMapping("nList")
	public String nList(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {

		// service 연결
		Map<String, Object> map = nbService.selectAll(page, category, searchWord);

		model.addAttribute("map", map);

		return "/community/nList";
	}// nList()

	// 1.공지사항 리스트 검색
	@GetMapping("search")
	public String search(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {

		// service 연결
		Map<String, Object> map = nbService.selectSearch(page, category, searchWord);

		model.addAttribute("map", map);

		return "/community/nList";
	}// nList()

	// 1.공지사항 1개 게시글 가져오기 /댓글 모두 가져오기
	@GetMapping("nView")
	public String nView(@RequestParam(defaultValue = "1") int n_bno, Model model) {

		System.out.println("CController nView bno :" + n_bno);

		Map<String, Object> map = nbService.selectOne(n_bno);
		model.addAttribute("map", map);
		System.out.println("Controller nView bno :"+n_bno);

		return "/community/nView";
	}// nView()
	

	// 1.공지사항 댓글 저장
	@PostMapping("NCommnetInsert")
	@ResponseBody
	public NCommentDto NCommnetInsert(NCommentDto ncdto) {
		System.out.println("컨트롤러 NCommnetInsert n_ccontent"+ncdto.getN_ccontent());
		NCommentDto nCommentDto = nbService.NCommnetInsert(ncdto);
		
		
		return nCommentDto;
	}// NCommnetInsert
	
	// 1.공지사항 댓글 삭제
	@PostMapping("NCommnetDelete")
	@ResponseBody
	public String NCommnetDelete(int n_cno) {
		int result = nbService.NCommnetDelete(n_cno);
		
		
		return result+"";
	}// NCommnetDelete
	
	
	
	// 1.공지사항 게시글작성 페이지
	@GetMapping("nWrite")
	public String nWrite() {
		return "/community/nWrite";
	}// nWrite()

	@PostMapping("nWrite")
	public String nWrite(@RequestPart MultipartFile files1, NBoardDto nbdto) throws Exception {

		if (!files1.isEmpty()) {
			System.out.println("파일이 있어요!!!");
			String orgName = files1.getOriginalFilename();
			System.out.println("CController nWrite 파일첨부 이름 :" + orgName);
			long time = System.currentTimeMillis();
			String newName = time + "_" + orgName;
			String upload = "C:/upload/";
			File f = new File(upload + newName);
			files1.transferTo(f);
			nbdto.setN_bfile(newName);
		} else {
			nbdto.setN_bfile("");
			System.out.println("파일 첨부가 없습니다.");
		}

		nbService.bWrite(nbdto);

		return "/community/doBnWrite";
	}// nWrite()

	// 1.공지사항 게시글 삭제
	@GetMapping("nDelete")
	public String nDelete(@RequestParam(defaultValue = "1") int n_bno, Model model) {

		String result = nbService.nDelete(n_bno);

		model.addAttribute("result", "nView-D");
		return "/community/nResult";
	}// nUpdate()

	// 1.공지사항 글수정 페이지
	@GetMapping("nUpdate")
	public String nUpdate(@RequestParam(defaultValue = "1") int n_bno, Model model) {
		Map<String, Object> map = nbService.selectOne(n_bno);

		model.addAttribute("map", map);
		return "/community/nUpdate";
	}// nUpdate()

	@PostMapping("donUpdate")
	public String donUpdate(NBoardDto nbdto, @RequestPart MultipartFile files1, Model model) throws Exception {
		String orgName = "";
		String newName = "";

		if (!files1.isEmpty())
			orgName = files1.getOriginalFilename();
		long time = System.currentTimeMillis();
		newName = time + "_" + orgName;
		String upload = "c:/upload/";
		File f = new File(upload + newName);
		files1.transferTo(f);
		nbdto.setN_bfile(newName);

		nbService.donUpdate(nbdto);
		model.addAttribute("result", "Update-S");
		return "/community/nResult";

	}// nUpdate()

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 공지사항
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 게시판

	// 2.파티원 모집 게시판Pg
	@GetMapping("pList")
	public String partyList() {
		return "/community/pList";
	}// pList()

	// 2.파티원 모집 게시글보기 Pg
	@GetMapping("pView")
	public String pView() {
		return "/community/pView";
	}// pView()

	// 2.파티원 모집 작성Pg
	@GetMapping("pWrite")
	public String pWrite() {
		return "/community/pWrite";
	}// pView()

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 파티원
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 모집
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 게시판

	// 3.꿀팁 게시판 리스트Pg
	@GetMapping("tList")
	public String tipList() {
		return "/community/tList";
	}// tList()

	// 3.꿀팁 게시글 보기Pg
	@GetMapping("tView")
	public String tView() {
		return "/community/tView";
	}// tView()

	// 3.꿀팁 게시글 작성Pg
	@GetMapping("tWrite")
	public String tWrite() {
		return "/community/tWrite";
	}// tWrite()

	// 3. 꿀팁 게시글 수정Pg
	@GetMapping("tUpdate")
	public String tUpdate() {
		return "/community/tUpdate";
	}// tUpdate()

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 꿀팁
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 게시판

	// 4.자유 게시판 리스트Pg
	@GetMapping("fList")
	public String fList() {
		return "/community/fList";
	}// fList()

	// 4.자유 게시글 보기Pg
	@GetMapping("fView")
	public String fView() {
		return "/community/fView";
	}// fView()

	// 4.자유 게시글 작성Pg
	@GetMapping("fWrite")
	public String fWrite() {
		return "/community/fWrite";
	}// fWrite()

	// 4.자유게시글 수정Pg
	@GetMapping("fUpdate")
	public String fUpdate() {
		return "/community/fUpdate";
	}// fUpdate()

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 자유
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 게시판

}// CController
