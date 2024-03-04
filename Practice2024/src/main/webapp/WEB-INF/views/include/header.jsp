<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Header</title>
		<style>
			.nav{width: 110px; color: yellow; border: none; font-size:20px; font-weight: 700; list-style: none; } 
			.headerNav{text-decoration: none; color: yellow}
			.headerNav:hover{text-decoration: none; color: #ccff33; transition: all 0.4s;}
			li {width: 30px; height: 30px; padding: 5px; text-align: center; display: flex; align-items: center; 
				justify-content: center;margin: 3px; margin-top: 30px; }
		</style>
		</head>
		<header style="border: 1px solid black; width: 100%; height:100px; position: fixed; left: 0; top: 0; background: #14213d;">
			<div id="navGrid" style="display: flex; justify-content: space-between;">
			<div id="logo" style="width: 100px; height: 100px; font-size: 30px; text-align: center; font-weight: 700; color: yellow; line-height: 100px; margin-left: 30px;"><a href="/" style="text-decoration: none; color:#ffb703; ">Yoonicorn</a></div>
				<nav class="navigation" style="margin-right: 100px;">
					<ul style="display: flex; justify-content: flex-end; width: 700px">
						<c:if test="${session_id==null }">
							<li class="nav"><a class="headerNav" href="login">로그인</a></li>
							<li class="nav"><a class="headerNav" href="mInsert">회원가입</a></li>
						</c:if>
						<c:if test="${session_id!=null }">
							<li class="nav"><a class="headerNav" href="#">로그아웃</a></li>
							<li class="nav"><a class="headerNav" href="#">회원정보</a></li>
						</c:if>
						<li class="nav"><a class="headerNav" href="#">게시판</a></li>
						<li class="nav"><a class="headerNav" href="#">다음지도</a></li>
						<li class="nav"><a class="headerNav" href="#">공공데이터</a></li>
					</ul>
				</nav>
			</div>
		</header>
	</html>