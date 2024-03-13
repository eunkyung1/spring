<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<script>
			if(${result} == 1){
				alert("로그인이 되었습니다.");
				location.href="/";
			}else{
				alert("아이디 또는 패스워드를 확인하시기 바랍니다.");
				location.href="login";
				
			}
			 
		
		</script>
	
	</body>
</html>