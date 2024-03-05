<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원리스트</title>
	</head>
	<!-- ♣♣♣ CSS ♣♣♣ -->
	<link href="../css/index.css" rel="stylesheet">
	<link href="../css/mailList.css" rel="stylesheet">
	
	<!-- ♣♣♣ font ♣♣♣ -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- JQuery 최신 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!--◁◀◁◀ Header ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/sidebar.jsp"%>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--◁◀◁◀ Header ▶▷▶▷ -->
	
	<script>
		$(function(){
			$("#listInsertBtn").click(function(){
				alert("test");
			});//#listInsertBtn(등록버튼)
			
			$("#listDelBtn").click(function(){
				if(confirm("삭제하시겠습니까?")){
				}//if(삭제확인)
			});//#listInsertBtn(등록버튼)
			
			$("#SelectAll").click(function(){
				alert("전체선택 버튼 test");
			});//#SelectAll(전체선택)
			
			$("#searchBtn").click(function(){
				alert("검색어 test");
			});//#searchBtn(검색어)
			
		});//제이쿼리 최신
	</script>
	
	<body>
	
	<!--▼▼▼ 회원정보 리스트 전체테두리 ▼▼▼ -->
	<div class="table-container">
	<h1 style="font-size: 70px; font-weight: 700;">전체 메일</h1>
	
	<!--검색어 찾기 -->
	<div id="search-container">
	
	<div id="seletBox" style="width: 250px; padding-top: 50px;">
		<input type="button" id="SelectAll" value="전체선택" style="font-weight: 700; margin-right: 10px;">
		<input type="checkbox" value="male" style="display: inline-block; vertical-align: middle;"><label for="male">읽음</label>
		<input type="checkbox" value="female" style="display: inline-block; vertical-align: middle;"><label for="female">안읽음</label>
	</div>
		<form action="" method="get">
			<div id="searchSection">
				<select id="ViewCondition">
					<option value="5">5 개</option>
					<option value="10">10 개</option>
					<option value="20">20 개</option>
				</select>
				<select id="searchCategory">
					<option value="all">전체</option>
					<option value="bno">번호</option>
					<option value="btitle">제목</option>
				</select>
				<input type="text" id="searchWord" name="" placeholder=" ※검색어를 입력하세요.">
				<input type="button" id="searchBtn" value="검 색">
			</div>
		</form>
	</div>
	<!--검색어 찾기 끝 -->
	
	<hr style="border: 2px solid #14213d; margin-bottom: 20px;">
	<div class="mail_toolbar">
	 <div class="mail_check">
		<button type="button" class="button_read" disabled>
			<span class="text">읽음</span>
		</button>	 	
	 </div><!--mail_check  -->
	 <div class="mail_check">
	 	<button type="button" class="button_del" disabled>
	 		<span class="text">삭제</span>
	 	</button>
	 </div>
	</div>
	  <table style="border-top: 3px solid #14213d;">
	  	<tr>200/200</tr>
	    <thead>
	    <colgroup>
		    <col width="4%">
		    <col width="10%">
		    <col width="71%">
		    <col width="15%">
	    </colgroup>
	    
	      <tr>
	        <th>번 호</th>
	        <th>보낸사람</th>
	        <th>제목</th>
	        <th>보낸날짜</th>
	      </tr>
	    </thead>
	    <tbody style="border-bottom: 2px solid #14213d;">
	     
	      <tr>
	        <td class="Bno"><input type="checkbox"> </td>
	        <td class="ID">jskarat123</td>
	        <td class="Btitle">메일 제목입니다.</td>
	        <td class="Bdate">2024-02-07 12:17:11</td>
	      </tr>
	      <tr>
	        <td class="Bno"><input type="checkbox"> </td>
	        <td class="ID">jskarat123</td>
	        <td class="Btitle">메일 제목입니다.</td>
	        <td class="Bdate">2024-02-07 12:17:11</td>
	      </tr>
	      <tr>
	        <td class="Bno"><input type="checkbox"> </td>
	        <td class="ID">jskarat123</td>
	        <td class="Btitle">메일 제목입니다.</td>
	        <td class="Bdate">2024-02-07 12:17:11</td>
	      </tr>
	      <tr>
	        <td class="Bno"><input type="checkbox"> </td>
	        <td class="ID">jskarat123</td>
	        <td class="Btitle">메일 제목입니다.</td>
	        <td class="Bdate">2024-02-07 12:17:11</td>
	      </tr>
	      <tr>
	        <td class="Bno"><input type="checkbox"> </td>
	        <td class="ID">jskarat123</td>
	        <td class="Btitle">메일 제목입니다.</td>
	        <td class="Bdate">2024-02-07 12:17:11</td>
	      </tr>
	     
	    </tbody>
	  </table>
	  
	  <!--페이지 넘버링 -->
	  <ul id="PageNum" style="display: flex; list-style: none;">
	  	<li class="num"><i class="fa fa-backward" aria-hidden="true"></i></li>
	  	<li class="num"><i class="fa fa-chevron-circle-left" aria-hidden="true"></i></i></li>
	  	<li class="num">1</li>
	  	<li class="num">2</li>
	  	<li class="num">3</li>
	  	<li class="num">4</li>
	  	<li class="num">5</li>
	  	<li class="num"><i class="fa fa-chevron-circle-right" aria-hidden="true"></i></li>
	  	<li class="num"><i class="fa fa-forward" aria-hidden="true"></i></li>
	  </ul>
	  <!--페이지 넘버링 끝 -->
	<!--▣ 버튼 ▣ -->
	<div class="button-container">
	  <input type="button" id="listInsertBtn" value="등록">
	  <input type="button" id="listDelBtn" value="삭제">
	</div>
	<!--▣ 버튼 ▣-->
	</div>
	<!-- ▲▲▲ 회원정보 리스트 전체 테두리 끝 ▲▲▲-->
	
	
	</body>
	
	<!--◁◀◁◀ Footer ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--◁◀◁◀ Footer ▶▷▶▷ -->
</html>