package com.java.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class FController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	//카카오로그인 
	@GetMapping("/kaka")
	@ResponseBody
	public String oauth(String code) {
		
		//코드 값 받기
		System.out.println("kakao code : "+ code);
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		String content_type = "application/x-www-form-urlencoded;charset=utf-8"; 
		String grant_type = "authorization_code";
		String client_id  = "8163b507808574be423ace9ad35d9f43";
		String redirect_uri  = "http://localhost:8000/kakao/oauth";
		//code = code;
		
		//토큰키 받기
		//java에서 url 접속
		//HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		//headers,body
		//headers 부분
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		
		//body부분 - HttpBodt MultiValueMap 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); //url를 쓰기 위한 map
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		//HttpEntity에 HttpHeaders headers, MultiValueMap params을 1개로 합치기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers); 
		
		//카카오서버로 url전송해서 토큰키 return 받기
		//매개변수 : url링크, 전송방식-post, (header,body),String.class형태로 전송
		ResponseEntity<String> response =  rt.exchange(tokenUrl, HttpMethod.POST, kakaoTokenRequest,String.class);
		
		System.out.println("카카오 토큰 요청 응답 : "+response);
		return "success";
	}
	
	
	
	
	
	
	
}//Fcontroller
