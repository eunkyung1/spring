

package com.java.www.controller;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.www.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MController {
	
	//Model 전달방법
	
	
	@GetMapping("member/login") //회원가입으로 가라.
	public String login(Model model) {
		return "member/login";
	}
	
	@PostMapping("member/doLogin") //회원가입으로 가라.
	public String doLogin( String id, //RequestParam을 안 넣어도 되지만, form의 name을 맞춰야함.
			@RequestParam String pw ,
			@RequestParam(defaultValue="1") int bno, // defaultValue : bno를 적지 않아도 값을 출력함 
			Model model) {
			//RequestParam("id") String controller_id  -> RequestParam에 아이디를 설정해뒀기 때문에 뒤에 변수명을 달리해도 id가 그대로 들어옴.
			//RequestParam에서 int는 값을 적지 않고 출력하려면 defaultValue를 지정해줘야 오류가 안남.
		
		
		
		//@requestP
		System.out.println("controller id : "+id);
		System.out.println("controller pw : "+pw);
		System.out.println("controller 게시글번호 : "+bno);
		
		return "/index";
	}
	
	@GetMapping("member/memberInsert") //회원가입으로 가라.
	public String memberInsert(Model model) {
		return "member/memberInsert";
	}
	
	@PostMapping("member/doMemberInsert") //DB에 들렸다가 메인페이지로 가라.
	public String doMemberInsert(HttpServletRequest request, Model model) {
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String phone= request.getParameter("phone");
		String gender= request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		System.out.printf("%s,%s,%s,%s,%s,%s",id,pw,name,phone,gender,
				Arrays.toString(hobbys));
		return "member/memberView";
	}
	
	@RequestMapping("member/memberUpdate")
	public String memberUpdate(Model model) { //Model model와 같음. 
		
		//1.이전버전
		//HttpServletRequest request;
		//request.setAttribute("id", id)
		
		
		//2.spring
		//현재날짜와 시간을 Timestamp파일에 저장
		Timestamp mdate = new Timestamp(System.currentTimeMillis());
		
		MemberDto mdto 
		= new MemberDto("aaa", "1111", "장난꾸러기", "010-1111-1111", "Male", "golf, game", mdate);
		model.addAttribute("mdto",mdto);
		//model.addAttribute("id",id);
		//System.out.println("MemberDto id : "+mdto.getId()); //lombok이 필요함.
		return "member/memberUpdate";
	}
	
	
	
	
	
	/*
	 * //======================ModelAndView 전달방법
	 * 
	 * @RequestMapping("member/memberInsert") public ModelAndView memberInsert() {
	 * //Model model와 같음. ModelAndView mv = new ModelAndView();
	 * 
	 * //id를 전달 String id = "admin";
	 * 
	 * //1.이전버전 //HttpServletRequest request; //request.setAttribute("id", id)
	 * 
	 * 
	 * //2.spring //현재날짜와 시간을 Timestamp파일에 저장 Timestamp mdate = new
	 * Timestamp(System.currentTimeMillis()); MemberDto mdto = new
	 * MemberDto("bbbic", "1111", "방망이", "010-1111-1111", "Male", "golf, game",
	 * mdate);
	 * 
	 * mv.addObject("mdto",mdto); //model.addAttribute("id",id);
	 * mv.setViewName("member/memberInsert");
	 * //System.out.println("MemberDto id : "+mdto.getId()); //lombok이 필요함. return
	 * mv; }
	 */

}
