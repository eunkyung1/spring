package com.java.www.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.www.dto.BoardDto;
import com.java.www.dto.MemberDto;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("member")
public class MemberController {
	
	
	@RequestMapping("mInsert")
	public String mInsert() {
		return "member/memberInsert";
	}
	
	@RequestMapping("doMInsert")
	public String doMInsert(MemberDto mdto, HttpServletRequest request,
			String id, 
			String pw,
			String name,
			String phone,
			String gender,
			Model model) {
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		
		String[] hobbys = request.getParameterValues("hobby");
		
		for(int i=0; i<hobbys.length;i++) {
			String hobby = hobbys[0];
			hobby += ","+hobbys[i];
			
			mdto = new MemberDto(id, pw, name, phone, gender, hobby, mdate);
		model.addAttribute("mdto",mdto);
		}
		return "member/memberView";
	}
	
	@RequestMapping("mView")
	public String mView(Model model) {
		
		return "member/memberView";
	}
	
	@RequestMapping("mUpdate")
	public String mUpdate(Model model) {
	

		return "member/memberUpdate";
	}
	
	
	@RequestMapping("doMUpdate")
	public String doMUpdate(MemberDto mdto, Model model) {
		return "member/memberView";
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value="login")
	public String login() {
		return "member/login";
	}
	
	
	@PostMapping("doLogin")
//--------------방법2	
	public String doLogin(MemberDto memberDto 
			,BoardDto boardDto
			,Model model) {
		System.out.println("controller id : "+memberDto.getId());
		System.out.println("controller bno : "+boardDto.getBno());
		System.out.println("controller id : "+memberDto.getId());
		System.out.println("controller pw : "+memberDto.getPw());
	 	
		
		String id = memberDto.getId();
		String pw= memberDto.getPw();
		int bno = boardDto.getBno();
		
//----------방법1	
/*	public String doLogin(@RequestParam(required = false) String id, //@RequestParam 생략가능
			String pw, @RequestParam(defaultValue = "1") int bno,	//type이 달라도 name이 같으면 자동 형변환 가능. 
													//int가 값이 없으면 오류출력. defaultValue 값이 필수. 
			HttpServletRequest request,Model model) {*/
/*
 * System.out.println("controller id :"+id);
 * System.out.println("controller pw :"+pw);
 * System.out.println("controller bno :"+bno);
 */
		
		MemberDto mdto = new MemberDto();
		mdto.setId(id);
		System.out.println("mdto.getId: "+mdto.getId());
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		//전체생성자
		MemberDto mdto2 = new MemberDto(id, pw, "홍씨아저씨", "010-1111-1111", "Male", "game,golf",mdate);
		
		//부분생성자
		MemberDto mdto3 = MemberDto.builder().id(id).pw(pw).name("박카스").gender("Female").build();
		
		System.out.println("controller mdto3 name : "+mdto3.getName());
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("bno",bno);
		model.addAttribute("mdto",memberDto);
		
		return "member/doLogin";
	}
	
	
}
