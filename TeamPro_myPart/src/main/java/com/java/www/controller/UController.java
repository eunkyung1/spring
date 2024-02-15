package com.java.www.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import com.java.www.dto.UsedDto;
import com.java.www.service.UsedService;

@Controller
@RequestMapping("used")
public class UController {
	
	@Autowired UsedService uService;
	
	
	//중고거래 및 양도 - 중고거래
	@GetMapping("used_ca1")
	public String used_ca1(@RequestParam(defaultValue = "1")int page ,Model model,@RequestParam(defaultValue = "2")int u_bstatus,@RequestParam(required = false) String u_btype,
		@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		
		u_btype = "trade1";
		
			
		Map<String, Object> map =  uService.selectAll(page,category,searchWord,u_bstatus,u_btype);
		model.addAttribute("map",map);
		
		return "/used/used_ca1";
	}// used()

	
	//중고거래 및 양도 - 양도
	@GetMapping("used_sh2")
	public String used_sh2(@RequestParam(defaultValue = "1")int page ,Model model,@RequestParam(defaultValue = "2")int u_bstatus,@RequestParam(required = false) String u_btype,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord){
		
		u_btype = "transfer2";
		
		Map<String, Object> map =  uService.selectAll(page,category,searchWord,u_bstatus,u_btype);
		model.addAttribute("map",map);
		
		
		return "/used/used_sh2";
	}// used_transfer()
	


	//중고거래 거래가능 checked-true일때 하단넘버링
	@RequestMapping("possible_t")
	@ResponseBody
	public Map<String, Object> page_ca1(@RequestParam(defaultValue = "1")int page,String category, String searchWord,@RequestParam(defaultValue = "2")int u_bstatus,@RequestParam(required = false) String u_btype){
		System.out.println("UController page_ca1 u_bstatus :"+u_bstatus);
		System.out.println("UController page_ca1 u_btype :"+u_btype);
		
		Map<String, Object> map = uService.selectP_num(u_bstatus,page,u_btype,category,searchWord);
		
		return map;
	}
	
	
	//중고거래 거래가능 checked- false일때(ajax)
	@PostMapping("used_trade1")
	@ResponseBody
	public Map<String, Object> used_trade1(@RequestParam(defaultValue = "1")int page ,Model model,@RequestParam(defaultValue = "2")int u_bstatus,@RequestParam(required = false) String u_btype,
			@RequestParam(required = false) String category, @RequestParam(required = false) String searchWord) {
		System.out.println("UController page_ca1 u_bstatus :"+u_bstatus);
		System.out.println("UController page_ca1 u_btype :"+u_btype);
		
		
		Map<String, Object> map =  uService.selectAll(page,category,searchWord,u_bstatus,u_btype);
		
		model.addAttribute("map",map);
		
		return map;
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
		String noImage = "nImage.jpg";
		String orgfileName ="";
		String uploadFileName = "";
		StringBuilder u_bfileName = new StringBuilder();
		System.out.println(u_files);
		
		int fileCount =0;
		
		
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
	
	//중고거래 및 양도 - 글수정 불러오기
	@GetMapping("usedUpdate")
	public String usedUpdate(@RequestParam(defaultValue = "1")int u_bno, Model model,String u_btype) {
		Map<String, Object> map = uService.selectOne(u_bno,u_btype);
		model.addAttribute("map",map);
		
		return "/used/usedUpdate";
	}// usedUpdate()
	
	//중고거래 및 양고 - 글수정 저장
	@PostMapping("usedUpdate")
	public String usedUpdate(UsedDto udto, @RequestPart MultipartFile uimg, @RequestPart("u_files")List<MultipartFile> u_files, Model model) throws Exception {
	
		String fileUrl = "c:/upload/";
		String orgfileName ="";
		String uploadFileName = "";
		System.out.println(u_files);
		
		
		if(!uimg.isEmpty()) {
			orgfileName = uimg.getOriginalFilename();
			long time = System.currentTimeMillis();
			uploadFileName = time+"_"+orgfileName;
			System.out.println("파일이름 : "+uploadFileName);
			File f = new File(fileUrl+uploadFileName);
			uimg.transferTo(f);
			udto.setU_mimg(uploadFileName);
		};//if(umimg)
		
	    // 이전 파일명들을 가져옴
	    String file1 = udto.getFile1();
	    String file2 = udto.getFile2();
	    String file3 = udto.getFile3();

	    // 새로운 파일명들을 저장할 변수
	    String newFile1 = file1;
	    String newFile2 = file2;
	    String newFile3 = file3;
		
	    // u_files 리스트를 반복하며 각 파일에 대해 처리
	    for (int i = 0; i < u_files.size(); i++) {
	        MultipartFile file = u_files.get(i);
	        if (!file.isEmpty()) {
	            orgfileName = file.getOriginalFilename();
	            long time = System.currentTimeMillis();
	            uploadFileName = time + "_" + orgfileName;
	            File f = new File(fileUrl + uploadFileName);
	            file.transferTo(f);

	            // 새 파일명 설정
	            if (i == 0) {
	                newFile1 = uploadFileName;
	            } else if (i == 1) {
	                newFile2 = uploadFileName;
	            } else if (i == 2) {
	                newFile3 = uploadFileName;
	            }//else if
	        }//file.isEmpty
	    }//for

	    // 파일명을 Dto 객체에 설정
	    udto.setFile1(newFile1);
	    udto.setFile2(newFile2);
	    udto.setFile3(newFile3);

	    // 파일명들을 ','로 구분하여 udto에 설정
	    String bfile = Stream.of(newFile1, newFile2, newFile3)
	                         .filter(fileName -> fileName != null && !fileName.isEmpty())
	                         .collect(Collectors.joining(","));
	    udto.setU_bfile(bfile);
		System.out.println("최종 bfile : "+bfile);
		
		uService.usedDoUpdate(udto);
		
		if(udto.getU_btype().equals("trade1")) {
			model.addAttribute("result","used-up");
		}else {
			model.addAttribute("result","used-up2");
		}
		return "/used/uResult";
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
