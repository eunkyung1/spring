package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.KakaoDto;
import com.java.dto.OAuthToken;

import jakarta.servlet.http.HttpSession;

@Controller
public class KakaoController {
	
	@Autowired HttpSession session;
	
	@GetMapping("kakaoLogin")
	public String kakaoLogin() {
		return "kakaoLogin";
	}
	//카카오로그인
	@GetMapping("/kakao/oauth")
	//@ResponseBody
	public String oauth(String code) {
		//--------code값 가져오기
		//code 값 받기
		System.out.println("kakao code : "+code);
		//haders 담기
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		//body 담기
		String grant_type ="authorization_code";
		String client_id = "a80cbb0b355a5107849b34c31f0cd9bd";
		String redirect_uri ="http://localhost:8000/kakao/oauth";
		//code = code;
		
		//------------token키 가져오기
		String tokenUrl = "https://kauth.kakao.com/oauth/token";
		
		//공공데이터에서 사용 : HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//url전송 객체 선언
		RestTemplate rt = new RestTemplate();
		
		//HttpHeaders 오브젝트 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", content_type);
		
		//body 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		
		//합치는 오브젝트 생성 : HttpHeades와 MultiValueMap 합쳐서 전송
		HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(params,headers);
		
		//http전송 : post전송, 응답: response
		ResponseEntity<String> response =  rt.exchange(tokenUrl, HttpMethod.POST, tokenRequest,String.class);
		
		//json데이터를 java오브젝트로 변환 : ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken oAuthToken = null;
		
		//json데이터를 java오브젝트로 변경
		try {
			oAuthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("카카오 토큰 키 : "+response);
		System.out.println("카카오 토큰 키 getbody : "+response.getBody());
		System.out.println("카카오 access Access_token객체: "+oAuthToken.getAccess_token()); 
		System.out.println("카카오 access token객체: "+oAuthToken.getExpires_in()); 
		
		//---------사용자 정보 가져오기
		//HttpHeaders 오브젝트 생성
		HttpHeaders headers_user = new HttpHeaders();
		headers_user.add("Content-type", content_type);
		headers_user.add("Authorization", "Bearer "+oAuthToken.getAccess_token());
		
		
		//합치는 오브젝트 생성 : HttpHeades와 MultiValueMap 합쳐서 전송
		HttpEntity<MultiValueMap<String, String>> tokenRequest_user = new HttpEntity<>(headers_user);
		
		//http전송 : post전송, 응답: response
		String userUrl = "https://kapi.kakao.com/v2/user/me";
		ResponseEntity<String> response_user = rt.exchange(userUrl, HttpMethod.POST, tokenRequest_user,String.class);
		
		System.out.println("사용자 정보 response_user : "+response_user);
		
		//---------------------------
		//json데이터를 java오브젝트로 변환 : ObjectMapper
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoDto kakaoDto = null;
		
		//json데이터를 java오브젝트로 변경
		try {
			kakaoDto = objectMapper2.readValue(response_user.getBody(),KakaoDto.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("카카오 사용자 정보 response_user : "+response_user);
		System.out.println("카카오 사용자 정보 KakaoDto id: "+kakaoDto.getId()); 
		System.out.println("카카오 사용자 정보 KakaoDto getConnected_at: "+kakaoDto.getConnected_at()); 
		System.out.println("카카오 사용자 정보 KakaoDto getProperties getNickname: "+kakaoDto.getProperties().getNickname()); 
		
		//-------로그인 member 테이블에 user id: id, pass: id_1234567890
		session.setAttribute("session_id", kakaoDto.getId());
		session.setAttribute("session_name", kakaoDto.getProperties().getNickname());
		
		
		return "redirect:/";
		//return "사용자 정보 response_user :"+response_user;
	}
	
	

}
