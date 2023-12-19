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

@Controller
@RequestMapping("board")
public class BController {
	
	@Autowired
	BService bService;
	
	@GetMapping("bList")
	public String bList(Model model) {
		
		ArrayList<BoardDto> list = bService.selectAll();
		
		model.addAttribute("list",list);
		
		
		return "board/bList";
	}//bList
	
	@RequestMapping("bView")
	public String bView(@RequestParam(defaultValue = "1")int bno, Model model ) {
		
		Map<String, Object> map = bService.selectOne(bno);
		
		model.addAttribute("map",map);
		
		return "board/bView";
	}//bView
	
	@GetMapping("bInsert")
	public String bInsert() {
		return "board/bInsert";
	}//bList
	
	@PostMapping("bInsert")
	public String bInsert(Model model,BoardDto bdto, @RequestPart MultipartFile files) throws Exception {

		if(!files.isEmpty()) {
			String orgName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}else {
			bdto.setBfile("");
			System.out.println("첨부할 파일이 없습니다.");
		}
		
		bService.bInsert(bdto);
		
		return "board/doBInsert";
	}//bList
	

}
