<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Yoonicorn 로그인</title>
	</head>
	<!-- ♣♣♣ CSS ♣♣♣ -->
	<link href="../css/login.css" rel="stylesheet">
	
	<!-- ♣♣♣ font ♣♣♣ -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- JQuery 최신 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!--◁◀◁◀ Header ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--◁◀◁◀ Header ▶▷▶▷ -->
	
	<script>
		$(function(){
			
		});//제이쿼리 최신
	</script>
	
	<body>
		<h1 style="font-size: 70px;">로 그 인</h1>
	
		<form class="form">
		    <div class="flex-column"><label>아이디 </label></div>
		    <div class="inputForm">
		    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" height="20"><path d="M304 128a80 80 0 1 0 -160 0 80 80 0 1 0 160 0zM96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM49.3 464H398.7c-8.9-63.3-63.3-112-129-112H178.3c-65.7 0-120.1 48.7-129 112zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3z"/></svg>
	         <input placeholder="아이디" class="input" type="text">
		    </div>
		    
		    <div class="flex-column"><label>비밀번호 </label></div>
		      <div class="inputForm">
		        <svg xmlns="http://www.w3.org/2000/svg" width="20" viewBox="-64 0 512 512" height="20"><path d="m336 512h-288c-26.453125 0-48-21.523438-48-48v-224c0-26.476562 21.546875-48 48-48h288c26.453125 0 48 21.523438 48 48v224c0 26.476562-21.546875 48-48 48zm-288-288c-8.8125 0-16 7.167969-16 16v224c0 8.832031 7.1875 16 16 16h288c8.8125 0 16-7.167969 16-16v-224c0-8.832031-7.1875-16-16-16zm0 0"></path><path d="m304 224c-8.832031 0-16-7.167969-16-16v-80c0-52.929688-43.070312-96-96-96s-96 43.070312-96 96v80c0 8.832031-7.167969 16-16 16s-16-7.167969-16-16v-80c0-70.59375 57.40625-128 128-128s128 57.40625 128 128v80c0 8.832031-7.167969 16-16 16zm0 0"></path></svg>        
		        <input placeholder="비밀번호" class="input" type="password">
		      </div>
	    
		    <div class="flex-row">
		      <div>
		      <input type="radio">
		      <label>아이디 저장 </label>
		      </div>
		      <span class="span">비밀번호 찾기</span>
		    </div>
		    <button class="button-submit">로그인</button>
		    <p class="p">회원이 아니세요? <a href="mInsert" style="text-decoration: none;"><span class="span">회원가입</span></a>
		
	    	</p><p class="p line" style="color: #d80032; font-weight: 700;">소셜 계정으로 로그인</p>
	
		    <div class="flex-row">
		      <button class="logbtn google">
		        <svg xml:space="preserve" style="background-image: url('https://i.jobkorea.kr/content/images/login/ver_1/sns_kakao_large.svg');" id="Layer_1" width="32" height="32"></svg>
			        카카오 로그인
			      </button>
			      
			      <button class="logbtn apple">
					<svg xml:space="preserve" style="background-image:url('https://i.jobkorea.kr/content/images/login/ver_1/sns_naver_large.svg') ;" id="Capa_1" width="32" height="32"></svg>
			        네이버 로그인 
				  </button>
			  </div>
		  </form>
		<div class="content1" style="background-image: url('../css/img/login.png'); width: 100%; height: 320px; margin:30px auto;">
		  <div class="text" style="color: #d9d9d9; ">Yoonicorn 서비스는 항상 당신과 함께합니다.</div>
		  <div class="p" style="color: #d9d9d9;">앞써나가는 그룹웨어 시스템</div>
		</div>
	</body>
	<!--◁◀◁◀ Footer ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--◁◀◁◀ Footer ▶▷▶▷ -->
	
</html>