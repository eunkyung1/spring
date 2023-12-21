package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	BService bService;
	
	// --------------------게시글 전체 가져오기
	@GetMapping("search") // 게시글 검색
	public String search(@RequestParam(defaultValue = "1") int page, @RequestParam(required = false) String category,
			@RequestParam(required = false) String searchWord, Model model) {
		System.out.println("bController search category : " + category);
		System.out.println("bController search searchWord : " + searchWord);
		
		
		//db에서 가져오기
		Map<String, Object> map = bService.selectSearch(page,category,searchWord);
		//model 저장
		model.addAttribute("map",map);
		System.out.println("게시글 총개수 : "+ (int)map.get("countAll"));
		
		
		
		return "board/bList";
	}// search

	// --------------------게시글 전체 가져오기
	@GetMapping("bList")
	public String bList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String searchWord, Model model) {
		// db에서 가져오기
		Map<String, Object> map = bService.selectAll(page,category,searchWord);

		// model 저장
		model.addAttribute("map", map);
		System.out.println("list개수 : " + ((List) map.get("list")).size());
		// System.out.println("게시글 총 개수 : " +(int)map.get("countAll"));

		return "board/bList";
	}// bList


	// -----------------------게시글 1개 가져오기,
	@GetMapping("bView")
	public String bView(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController bno :" + bno);
		// db에서 가져오기
		Map<String, Object> map = bService.selectOne(bno);
		// Model 저장
		model.addAttribute("map", map);

		return "board/bView";
	}// bView

	// -----------글쓰기 화면보기
	@GetMapping("bInsert")
	public String bInsert() {
		return "board/bInsert";
	}// bInsert

	@PostMapping("bInsert")
	public String bInsert(@RequestPart MultipartFile files, BoardDto bdto, Model model) throws Exception {
		// files - input type="file" name="files" 여야 함.

		if (!files.isEmpty()) { // 파일첨부를 했으면
			String orgName = files.getOriginalFilename();
			System.out.println("BController 파일첨부 이름 : " + orgName);
			long time = System.currentTimeMillis();
			String newName = time + "_" + orgName; // 중복방지를 위해 새로운 이름 변경
			String upload = "C:/upload/"; // 파일업로드 위치
			File f = new File(upload + newName);
			files.transferTo(f); // 파일을 저장위치에 저장시킴.
			bdto.setBfile(newName); // 파일이름을 BoardDto에 저장시킴.
		} else { // 파일첨부가 없으면
			bdto.setBfile("");
			System.out.println("파일 첨부가 없습니다.");
		}

		// db로 전송
		bService.bInsert(bdto);
		return "board/doBInsert";
	}// bInsert

	// -------------다중업로드 화면보기
	@GetMapping("bInsert2")
	public String bInsert2() {
		return "board/bInsert2";
	}

	// --------------다중업로드 저장
	@PostMapping("bInsert2")
	public String bInsert2(List<MultipartFile> files, BoardDto bdto, Model model) throws Exception {
		// files - input type="file" name="files" 여야 함.
		// 복수개 일때는 List<MultipartFile> files로 받음.
		String orgName = "";
		String newName = "";
		String mergeName = "";
		int i = 0;
		for (MultipartFile file : files) {
			// for(int i=0;i<files.size();i++){} //동일함.

			// 파일첨부하기
			orgName = file.getOriginalFilename();
			System.out.println("BController 파일첨부 이름 : " + orgName);
			long time = System.currentTimeMillis();
			newName = time + "_" + orgName;
			String upload = "C:/upload/"; // 파일업로드 위치
			File f = new File(upload + newName);
			file.transferTo(f); // 파일을 저장위치에 저장시킴.

			// 파일이름 저장하기
			if (i == 0)
				mergeName += time + "_" + orgName; // 중복방지를 위해 새로운 이름 변경
			else
				mergeName += "," + time + "_" + orgName; // 중복방지를 위해 새로운 이름 변경
			i++;
		}
		bdto.setBfile(mergeName); // 파일이름을 BoardDto에 저장시킴.
		System.out.println("BController 최종 파일첨부 이름 : " + mergeName);

		// db연결 - 내용저장
		bService.bInsert(bdto);

		return "board/doBInsert";
	}

	// -----게시글 삭제하기
	@PostMapping("bDelete")
	public String bDelete(@RequestParam(defaultValue = "1") int bno) {
		System.out.println("BController bDelete bno : " + bno);
		bService.bDelete(bno);
		return "board/bDelete";
	}

	// -----게시글 수정페이지 보기
	@PostMapping("bUpdate")
	public String bUpdate(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController bUpdate bno : " + bno);
		Map<String, Object> map = bService.selectOne(bno);

		model.addAttribute("map", map);
		return "board/bUpdate";
	}

	// -----게시글 수정페이지 저장
	@PostMapping("doBUpdate")
	public String doBUpdate(BoardDto bdto, @RequestPart MultipartFile files) throws Exception {
		System.out.println("bController doBUpate bno : " + bdto.getBno());
		String orgName = "";
		String newName = "";
		if (!files.isEmpty()) { // 파일업로드가 되어있으면
			orgName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			newName = time + "_" + orgName;
			// newName = String.format("%s_%d",orgName,time);
			String upload = "C:/upload/"; // 파일업로드 위치
			File f = new File(upload + newName); // 파일생성
			files.transferTo(f); // 파일을 저장위치에 저장시킴.
			bdto.setBfile(newName); // dto파일이름 저장
		}

		// db전송
		bService.doBUpdate(bdto); // 파일 업로드가 없으면 기존파일이름 그대로 사용

		return "board/doBUpdate";
	}

	// -----게시글 답변달기페이지 보기
	@PostMapping("bReply")
	public String bReply(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController bUpdate bno : " + bno);
		Map<String, Object> map = bService.selectOne(bno);

		model.addAttribute("map", map);
		return "board/bReply";
	}

	// 답변달기 저
	@PostMapping("doBReply")
	public String doBReply(@RequestPart MultipartFile files, BoardDto bdto, Model model) throws Exception {
		// files - input type="file" name="files" 여야 함.
		// 답변달기 - bgroup , bstep, bindent 값은 bdto에 담겨져 있음. 필수적으로 필요함.
		if (!files.isEmpty()) { // 파일첨부를 했으면
			String orgName = files.getOriginalFilename();
			System.out.println("BController doBReply 파일첨부 이름 : " + orgName);
			long time = System.currentTimeMillis();
			String newName = time + "_" + orgName; // 중복방지를 위해 새로운 이름 변경
			String upload = "C:/upload/"; // 파일업로드 위치
			File f = new File(upload + newName);
			files.transferTo(f); // 파일을 저장위치에 저장시킴.
			bdto.setBfile(newName); // 파일이름을 BoardDto에 저장시킴.
		} else { // 파일첨부가 없으면
			bdto.setBfile("");
			System.out.println("doBReply 파일 첨부가 없습니다.");
		}

		// db로 전송
		bService.doBReply(bdto);

		return "board/doBReply";
	}// bInsert

	// ----------------------------------------------------------
	// ----------- 다중업로드 ----------------------
	// ----------------------------------------------------------
	@GetMapping("bList2")
	public String bList2(@RequestParam(defaultValue = "1") int page,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String searchWord,
			Model model) {
		// db에서 가져오기
		Map<String, Object> map = bService.selectAll(page,category,searchWord);

		// model 저장
		model.addAttribute("map", map);
		System.out.println("list개수 : " + ((List) map.get("list")).size());
		System.out.println("게시글 총 개수 : " + (int) map.get("countAll"));

		return "board/bList2";
	}// bList

	@GetMapping("bView2")
	public String bView2(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("BController bno :" + bno);
		// db에서 가져오기
		Map<String, Object> map = bService.selectOne(bno);
		// Model 저장
		model.addAttribute("map", map);

		return "board/bView2";
	}// bView
}
