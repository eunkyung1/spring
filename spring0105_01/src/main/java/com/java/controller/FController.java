package com.java.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

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

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
public class FController {
	
	@Autowired BService bService;

	@RequestMapping({"/","main"})//2개를 연결시키려면 {}필요
	public String main() {
		return "main";
	}
	
	@GetMapping("bwrite")
	public String bwrite(Model model) {
		return "bwrite";
	}
	@GetMapping("map")
	public String map() {
		return "map";
	}
	@PostMapping("screenInfo")
	@ResponseBody
	public String screenInfo(String txt) throws Exception {
		String key="8e6d552063ef95c47d3ac174228849d2";
		//오늘날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(System.currentTimeMillis());
		System.out.println("오늘날짜 : "+today);
		
		StringBuilder urlBuilder = new StringBuilder("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json"); 
        urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "="+key);
        urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20240104", "UTF-8")); 
        URL url = new URL(urlBuilder.toString());
        //URL url = new URL("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1?serviceKey=918RE13GA7OY7ZEmUzApgbOeAcQoZ%2FaHsXWcqPAKQ9YNNPj83KOstRMRIUrCFIAcm9qj2R6b7NFZjp%2FYsYzJLg%3D%3D&numOfRows=10&pageNo=2&MobileOS=ETC&MobileApp=AppTest&arrange=A&_type=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();  //String 을 계속 더하면 String변수를 계속 새롭게 만듬.
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line); //json데이터를 sb에 1줄씩 저장
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		
		
		return sb.toString();
	}
	
	//summernote에서 ajax이미지 전송
	@PostMapping("uploadImage")
	@ResponseBody
	public String uploadImage(@RequestPart MultipartFile file) throws Exception {
		String urlName ="";
		
		if(!file.isEmpty()) {
			String orgFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+orgFName; //파일이름 변경
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+upFName); // 파일등록
			file.transferTo(f);//파일 서버로 전송
			urlName = "/upload/"+upFName;
			
		}
		return urlName;
		
	}
	
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1")int bno,Model model) {
		
		BoardDto bdto = bService.selectOne(bno);
		
		model.addAttribute("bdto",bdto);
		return "bview";
	}
	
	//글쓰기 저장
	@PostMapping("bwrite")
	public String bwrite(@RequestPart MultipartFile file, BoardDto bdto,Model model) throws Exception {
		System.out.println("FController bwrite btitle "+bdto.getBtitle());
		//파일 서버로 전송하는 부분
		if(!file.isEmpty()) {
			String orgFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+orgFName; //파일이름 변경
			String uploadUrl = "c:/upload/";
			File f = new File(uploadUrl+upFName); // 파일등록
			file.transferTo(f);//파일 서버로 전송
			bdto.setBfile(upFName); //dto bfile 이름저장
			
		}else {
			bdto.setBfile(""); //
		}
		 System.out.println("FController bwrite bfile"+bdto.getBfile());
		
		//service 연결 
		bService.bwrite(bdto);
		
		model.addAttribute("result","success-bwrite");
		return "result";
	}
	
	//게시글 전체 가져오기
	@GetMapping("blist")
	public String blist(Model model) {
		List<BoardDto> list =bService.selectAll();
		model.addAttribute("list",list);
		return "blist";
	}
	

}
