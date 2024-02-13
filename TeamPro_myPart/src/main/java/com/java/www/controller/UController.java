package com.java.www.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.sym;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.www.dto.UsedDto;
import com.java.www.service.UsedService;

@Controller
@RequestMapping("used")
public class UController {
	
	@Autowired UsedService uService;
	
	
	//중고거래 및 양도 - 중고거래
	@GetMapping("used_ca1")
	public String used_ca1(@RequestParam(defaultValue = "1")int page ,Model model,@RequestParam(defaultValue = "2")int u_bstatus,String u_btype,
		@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		Map<String, Object> map =  uService.selectAll(page,category,searchWord);
		//Map<String, Object> mapt =  uService.selectAllt(page,u_bstatus,u_btype);
		model.addAttribute("map",map);
		//model.addAttribute("mapt",mapt);
		
		return "/used/used_ca1";
	}// used()
	
	//중고거래 및 양도 - 중고거래(test)
	@GetMapping("Tused_ca1")
	public String Tused_ca1(@RequestParam(defaultValue = "1")int page ,Model model,int u_bstatus,String u_btype,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		//Map<String, Object> map =  uService.selectAll_t(page,category,searchWord,u_bstatus,u_btype);
		//model.addAttribute("map",map);
		
		return "/used/used_ca1";
	}// used()
	
	
	//중고거래 및 양도 - 양도
	@GetMapping("used_sh2")
	public String used_sh2(@RequestParam(defaultValue = "1")int page,Model model,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord){
		
		Map<String, Object> map2 =  uService.selectAll2(page,category,searchWord);
		model.addAttribute("map2",map2);
		
		
		return "/used/used_sh2";
	}// used_transfer()
	

	
	
	//중고거래&양도 거래가능 checked-true일때 
	/*
	@PostMapping("possible_t")
	@ResponseBody
	public ArrayList<UsedDto> possible_t(int u_bstatus,String u_btype){
		System.out.println("UController used_transfer :"+u_bstatus);
		System.out.println("UController used_transfer :"+u_btype);
		
		ArrayList<UsedDto> list = uService.selectPossible(u_bstatus,u_btype);
		return list;
	}
	*/
	
	//중고거래 거래가능 checked-true일때 하단넘버링
	//@PostMapping("pageNum_ca1")
	@RequestMapping("possible_t")
	@ResponseBody
	public Map<String, Object> page_ca1(int u_bstatus,@RequestParam(defaultValue = "1")int page,String u_btype,String category, String searchWord){
		System.out.println("UController page_ca1 u_bstatus :"+u_bstatus);
		System.out.println("UController page_ca1 u_btype :"+u_btype);
		
		Map<String, Object> map = uService.selectP_num(u_bstatus,page,u_btype,category,searchWord);
		
		return map;
	}
	
	
	//중고거래 거래가능 checked- false일때(ajax)
	@PostMapping("used_trade1")
	@ResponseBody
	public Map<String, Object> used_trade1(@RequestParam(defaultValue = "1")int page ,Model model,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		Map<String, Object> map =  uService.selectAll(page,category,searchWord);
		
		model.addAttribute("map",map);
		
		return map;
	}// used_trade1()

	//중고양도 거래가능 checked- false일때(ajax)
	@PostMapping("used_transfer2")
	@ResponseBody
	public Map<String, Object> used_transfer2(Model model,@RequestParam(defaultValue = "1")int page,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		Map<String, Object> map2 =  uService.selectAll2(page,category,searchWord);
		
		model.addAttribute("map2",map2);
		
		return map2;
	}// used_trade1()
	
	
	
	//중고거래 및 양도 - 뷰
	@GetMapping("usedcontent")
	public String usedcontent(@RequestParam(defaultValue = "1")int u_bno, Model model, String u_btype ) {
		
		Map<String, Object> map = uService.selectOne(u_bno,u_btype);
		model.addAttribute("map",map);
		
		return "/used/usedcontent";
	}// usedcontent()
	
	
	
	
	
	
	//중고거래 및 양도 - 글쓰기
	@GetMapping("usedWrite")
	public String usedWrite() {
		return "/used/usedWrite";
	}// usedWrite()
	
	//중고거래 및 양도 - 글쓰기
	@PostMapping("usedWrite")
	public String usedWrite(@RequestPart MultipartFile uimg, List<MultipartFile> u_files, UsedDto udto, Model model) throws Exception {
		
		String fileUrl = "c:/upload/";
		String orgfileName ="";
		String uploadFileName = "";
		StringBuilder u_bfileName = new StringBuilder();
		int fileCount =0;
		String noImage = "../../assets/img/nView/noImage.png";
		
		
		if(!uimg.isEmpty()) {
			orgfileName = uimg.getOriginalFilename();
			long time = System.currentTimeMillis();
			uploadFileName = time+"_"+orgfileName;
			System.out.println("파일이름 : "+uploadFileName);
			File f = new File(fileUrl+uploadFileName);
			uimg.transferTo(f);
			udto.setU_mimg(uploadFileName);
		}else {
			udto.setU_mimg(noImage);
		}
		
		
		if(!u_files.isEmpty()) {
			for(MultipartFile file:u_files) {
				if(!file.isEmpty()) {
				orgfileName = file.getOriginalFilename();
				long time = System.currentTimeMillis();
				uploadFileName = time+"_"+orgfileName;
				System.out.println("파일이름 : "+uploadFileName);
				File f = new File(fileUrl+uploadFileName);
				file.transferTo(f);
				 if (fileCount > 0) {
		                u_bfileName.append(",");
		            }//if(fileCount)
		            u_bfileName.append(uploadFileName);
		            fileCount++;
				}//if
			}//for
		}//if
		
		udto.setU_bfile(u_bfileName.toString());
		System.out.println("최종파일이름 : "+u_bfileName);
		
		uService.usedWrite(udto);
		
		if(udto.getU_btype().equals("trade1")) {
			model.addAttribute("result","used-w");
		}else {
			model.addAttribute("result","used-w2");
		}
		
		
		return "/used/uResult";
	}// usedWrite()
	
	//중고거래 및 양도 - 글수정
	@GetMapping("usedUpdate")
	public String usedUpdate(@RequestParam(defaultValue = "1")int u_bno, Model model,String u_btype) {
		Map<String, Object> map = uService.selectOne(u_bno,u_btype);
		model.addAttribute("map",map);
		
		return "/used/usedUpdate";
	}// usedUpdate()
	
	//중고거래 및 양도 - 글삭제
	@GetMapping("usedDelete")
	public String usedDelete(@RequestParam(defaultValue = "1")int u_bno, Model model,String u_btype) {
		uService.usedDelete(u_bno);
		if(u_btype.equals("trade1")) {
			model.addAttribute("result","used-del1");
		}else{
			model.addAttribute("result","used-del2");
		}
		
		return "/used/uResult";
	}// usedDelete()
	
	//중고거래 및 양도 - 거래완료 버튼 변경
	@PostMapping("usedComplete")
	@ResponseBody
	public String usedComplete(@RequestParam(defaultValue = "1")int u_bno) {
		int result = uService.usedComplete(u_bno);
		return result+"";
	}// usedComplete()
	

}//controller
