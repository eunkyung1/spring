<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Registration Form in HTML CSS</title>
    
    <!---Custom CSS File--->
    <link rel="stylesheet" href="../css/mInsert.css">
    
    <!-- ♣♣♣ font ♣♣♣ -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- JQuery 최신 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
    <!--◁◀◁◀ Header ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--◁◀◁◀ Header ▶▷▶▷ -->
  </head>
  <script>
  	$(function(){
  		$("#idChk").click(function(){
  			alert("test");
  		});//아이디 중복체크
  		
  		
  	});//제이쿼리최신
  </script>
  <body>
  <form method="post" action="">
	   <div class="container">
	    <div class="insert">
	    	<table>
		    <caption><h2>회원가입 양식</h2></caption>
		    <tr>
		    	<td class="col1" rowspan="4"">
		    	<div style="width: 150px; height: 200px; border: 2px solid gray; margin: 0 auto;"></div>
		    	<label for="file" style=" display: flex; justify-content: center; align-items: center; margin-top: 10px;"><span id="profileImg">파일선택</span></label>
		    	<input type="file" style="display: none" id="file">
		    	</td>
		    	<td class="col1">이름</td>
		        <td colspan="1"><input type="text" name="name" maxlength="5" style="margin-left: 6px;" placeholder="ex) 홍길동"></td>
		    </tr>
		    <tr>
		        <td class="col1">아이디</td>
		        <td class="col2">
		            <input type="text" name="id" maxlength="10" placeholder="ex) yoonicorn">
		            <input type="button" id="idChk" value="중복확인">
		        </td>
		    </tr>
		    <tr>
		        <td class="col1">비밀번호</td>
		        <td class="col2">
		            <input type="password" name="pw1" id="pw1" maxlength="16" placeholder=" ※ 비밀번호 입력">
		            <p style="padding-top: 6px;">※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%^&*)의 조합
		            10 ~ 16자리</span>로 입력이 가능합니다.</p>
		        </td>
		    </tr>
		    <tr>
		        <td class="col1">비밀번호 확인</td>
		        <td class="col2"><input type="password" name="pw2" id="pw2" maxlength="16" placeholder=" ※ 비밀번호 확인"><strong id="pwchkMsg" style="font-size: 11px; margin-left: 8px;">※비밀번호를 확인해주세요.</strong></td>
		    </tr>
		    <tr>
		        <td class="col1">주민등록번호</td>
		        <td class="col2" colspan="2">
		            <input type="text" name="pnum1" placeholder="920207" style="text-align: center;">
		            <span>-</span>
		            <input type="password" name="pnum2" placeholder="주민번호 뒤 7자리" style="text-align: center;">
		            <input type="button" id="pnumChk" value="중복확인">
		        </td>
		    <tr>
		        <td class="col1">생년월일</td>
		        <td class="col2" colspan="2">
			        <input type=text class="bdate">년&nbsp;<input type=text class="bdate">월&nbsp;<input type=text class="bdate">일
		        </td>
		    </tr>
		    <tr>
		        <td class="col1">성별</td>
		        <td class="col2" colspan="2">
			        <input type="radio" value="male"><label>남자</label>
			        <input type="radio" value="female"><label>여자</label>
		        </td>
		    </tr>
		    <tr>
		        <td class="col1">연락처</td>
		        <td class="col2" colspan="2">
		            <input type="text" name="phone1" placeholder="010" style="text-align: center; width: 70px;">
		            <span>-</span>
		            <input type="text" name="phone2" placeholder="7777" style="text-align: center; width: 70px;">
		            <span>-</span>
		            <input type="text" name="phone3" placeholder="7777" style="text-align: center; width: 70px;">
		        </td>
		    <tr>
		        <td class="col1">이메일</td>
		        <td class="col2" colspan="2">
		            <input type="text" name="mailid">
		            <span>@</span>
		            <input type="text" name="email" placeholder="hanmail.net">
		            <select name="mailslc">
		                <option value="self" selected>직접입력</option>
		                <option value="naver">naver.com</option>
		                <option value="gm">gmail.com</option>
		                <option value="da">daum.com</option>
		                <option value="yah">yahoo.com</option>
		            </select>
		            <input type="button" id="emailChk" value="이메일 중복확인">
		        </td>
		    </tr>
		    <tr>
		        <td class="col1">주소</td>
		        <td class="col2" colspan="2">
		        	<input type="text" id="f_postal" class="addressTxt" name="zipCode"  required />
		            <input type="button" id="addressBtn" class="address" value="우편번호 찾기"><br>
		            <input type="text" class="addressTxt" name="address1" ><br>
		            <input type="text" class="addressTxt" name="address2" style="width: 100%;">
		        </td>
		    </tr>
	    </table>
	  <!-- 회원가입 버튼 -->
	  </div>
		  <div class="create">
	        <input id="cancelBtn" type="button" value="가입취소">
	        <input id="signUpBtn" type="button" value="회원가입">
		  </div>
	  </div>
	  <!-- 회원가입 버튼 -->
  </form>
 </body>
  <!--◁◀◁◀ Footer ▶▷▶▷ -->
  <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  <!--◁◀◁◀ Footer ▶▷▶▷ -->
</html>
