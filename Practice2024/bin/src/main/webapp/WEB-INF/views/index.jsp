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
			
			$("#ViewCondition").change(function(){
				$("#ViewCondition").val();
				searchFrm.submit();
			});
			
		});//제이쿼리 최신
	</script>
	
	<body>
	
	<!--▼▼▼ 회원정보 리스트 전체테두리 ▼▼▼ -->
	<div class="table-container">
	<h1 style="font-size: 70px; font-weight: 700;">회원정보 리스트</h1>
	
	<!--검색어 찾기 -->
	<div id="search-container">
	
	<div id="seletBox" style="width: 250px; padding-top: 50px;">
		<input type="button" id="SelectAll" value="전체선택" style="font-weight: 700; margin-right: 10px;">
		<input type="checkbox" class="ch_name" name="gender" value="male" style="display: inline-block; vertical-align: middle;"><label for="male">남자</label>
		<input type="checkbox" class="ch_name" name="gender" value="female" style="display: inline-block; vertical-align: middle;"><label for="female" >여자</label>
	</div>
	
	

	
		<form action="index" name="searchFrm" method="get">
			<div id="searchSection">
				<select id="ViewCondition" name="searchCount">
					<option value="5">5 개</option>
					<option value="10">10 개</option>
					<option value="20">20 개</option>
				</select>
				<select id="searchCategory" name="searchCategory">
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
	  <table style="border-top: 3px solid #14213d;">
	    <thead>
	    <colgroup>
		    <col width="4%">
		    <col width="6%">
		    <col width="6%">
		    <col width="6%">
		    <col width="4%">
		    <col width="10%">
		    <col width="23%">
		    <col width="12%">
		    <col width="10%">
		    <col width="6%">
		    <col width="12%">
	    </colgroup>
	      <tr>
	        <th>번 호</th>
	        <th>아이디</th>
	        <th>비밀번호</th>
	        <th>성 명</th>
	        <th>성 별</th>
	        <th>연락처</th>
	        <th>주&nbsp;&nbsp;소</th>
	        <th>E-mail</th>
	        <th>주민번호</th>
	        <th>접속횟수</th>
	        <th>최근접속</th>
	      </tr>
	    </thead>
	    <tbody style="border-bottom: 2px solid #14213d;">
	    	<c:forEach var="ymdto" items="${map.list}">
		      <tr>
		        <td class="Bno"><input type="checkbox"> </td>
		        <td class="ID">${ymdto.id}</td>
		        <td class="Bpw">${ymdto.pw}</td>
		        <td class="Btitle">${ymdto.name}</td>
		        <td class="Bdate">${ymdto.gender}</td>
		        <td class="Bgroup">${ymdto.phone }</td>
		        <td class="Bfile">${ymdto.address}</td>
		        <td class="Bhit">${ymdto.email}</td>
		        <td class="Bhit">${ymdto.pnumber }</td>
		        <td class="Bdate">${ymdto.login_num}</td>
		        <td class="Bdate">${ymdto.recent_time}</td>
		      </tr>
	    	</c:forEach>
	   
	    </tbody>
	  </table>
	  
	  <!--페이지 넘버링 -->
	  <ul id="PageNum" style="display: flex; list-style: none;">
	  	<a href="index?page=1"><li class="num" ><i class="fa fa-backward" aria-hidden="true"></i></li></a>
	  	<a href="#"><li class="num"><i class="fa fa-chevron-circle-left" aria-hidden="true"></i></li></a>
	  	<c:forEach var="i" begin="${map.startPage}" end="${map.endPage}" >
	  	
	  	</c:forEach>
	  	
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