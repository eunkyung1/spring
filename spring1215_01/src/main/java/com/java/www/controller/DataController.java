package com.java.www.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;

@Controller
//@RestController //모두 .jsp파일로 보내지말고 데이터로 넘겨라.
public class DataController {

	@RequestMapping("mInsert")
	public String mInsert() {
		return "mInsert"; 
	}
	
	@ResponseBody
	@RequestMapping("boardBno/{bno}/{bhit}")  //@PathVariable {}값을 int bno로 넘긴다는 의미.
	public String boardBno(@PathVariable int bno, @PathVariable int bhit ) {
		String txt ="boardBno 글번호 : "+bno;
		txt +="조회수 bhit : "+bhit;
		
		return txt; 
	}
	@ResponseBody
	@RequestMapping("idCheck")
	public Map<String,Object> idCheck(String id) {
		//db검색 select * from board where id=?
		Map<String,Object> map = new HashMap<>();
		ArrayList<MemberDto> list = new ArrayList<>();
		
		if(id.equals("aaa")) {
			map.put("result","fail"); //사용불가능
		}else {
			map.put("result", "success"); //사용가능
		}
		list.add(new MemberDto("ccc","2222","멍닝","010-1111","Male",
				"game,golf,run", new Timestamp(System.currentTimeMillis())));
		list.add(new MemberDto("ddd","3333","동고래","010-1111-2222","Male",
				"game,run,book", new Timestamp(System.currentTimeMillis())));
		map.put("name", "홍길동");
		map.put("phone", "010-5555-8888");
		map.put("bno", 1);
		map.put("mdto", new MemberDto("bbb","1111","궁궁","010","Female",
				"game,golf", new Timestamp(System.currentTimeMillis())));
		
		
		//Json포맷 자동 변환 - Map,list
		return map;
	}
	
	@RequestMapping("aaa")
	public String aaa() {
		return "aaa"; //aaa.jsp 파일 열기
	}
	
	@ResponseBody //데이터로 리턴
	
	@RequestMapping("bbb")
	public String bbb() {
		String txt = "{'id':'aaa','pw':'1111','name':'홍길동'}";
		return txt; // ResponseBody-  return을 web에 넣어줘 라는 의미
	}
	
	
}
