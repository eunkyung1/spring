<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index페이지 입니다.</title>
</head>
<body>
	<h1>1218_02 메인페이지 입니다.</h1>
	<ul>
		<a href="/"><li>메인화면</li></a>
		<a href="board/bList"><li>공지사항리스트(list)</li></a>
		<a href="mInsert"><li>회원가입</li></a>
		<a href="boardBno/15/100"><li>글번호</li></a>
		<a href="member/login"><li>로그인</li></a>
		<a href="bInsert"><li>공지사항글쓰기(insert)</li></a>
		<a href="bView"><li>공지사항보기(view)</li></a>
		
		
	</ul>
</body>
</html>