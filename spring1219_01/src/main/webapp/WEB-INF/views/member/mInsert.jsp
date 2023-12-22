<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="/js/mInsert.js" ></script>
		<link href="/css/mInsert.css" rel="stylesheet" />

	</head>
	<body>
	  <div>
	   <h1>회원가입</h1>
	   <form name="memberFrm" id="memberFrm" method="post" action="#">
	   <!-- action은 페이지가 넘어감. -->
		   <table>
		     <tr>
		       <th>아이디</th>
		       <td>
				   <input type="text" name="id" id="id" > <!-- pom.xml에 선언했기 때문에 jstl 사용가능 -->
		           <button type="button" id="idCheckBtn">아이디 확인</button>
		           <br>
		           <span id="chkTxt"></span>
		       </td>
		     </tr>
		     <tr>
		       <th>패스워드</th>
		       <td><input type="password" name="pw" id="pw" ></td>
		     </tr>
		     <tr>
		       <th>이름</th>
		       <td><input type="text" name="name" id="name" ></td>
		     </tr>
		     <tr>
		       <th>전화번호</th>
		       <td><input type="text" name="phone" id="phone" ></td>
		     </tr>
		     <tr>
		       <th>성별</th>
					<td>
					<input type="radio" name="gender" id="Male" value="Male">
					<label for="Male">남자</label> 
					<input type="radio" name="gender" id="Female" value="Female"> 
					<label for="Female">여자</label>
					</td>
				</tr>
		     <tr>
		       <th>취미</th>
		       <td>
		         <input type="checkbox" name="hobby" id="game" value="game">
		         <label for="game">게임</label>
		         
		         <input type="checkbox" name="hobby" id="golf" value="golf">
		         <label for="golf">골프</label>
		         
		         <input type="checkbox" name="hobby" id="run" value="run">
		         <label for="run">조깅</label>
		         
		         <input type="checkbox" name="hobby" id="cook" value="cook">
		         <label for="cook">요리</label>
		         
		         <input type="checkbox" name="hobby" id="book" value="book">
		         <label for="book">독서</label>
		       </td>
		     </tr>
		   </table>
		   <button type="button" id="savebtn">저장</button>
		   <button type="button" onclick="javascript:location.href='/'">취소</button>
	   </form>
	  </div>
	
	</body>
</html>