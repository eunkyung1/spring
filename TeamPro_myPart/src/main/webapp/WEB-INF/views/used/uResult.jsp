<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>nResult</title>
	</head>
	<body>
		<c:choose>
				<c:when test="${result == 'used-w'}">
					<script>
					 alert("게시글이 저장되었습니다.");
					 location.href="used_ca1";
					</script>			
				</c:when>
				
				<c:when test="${result == 'used-w2'}">
					<script>
					 alert("게시글이 저장되었습니다.");
					 location.href="used_sh2";
					</script>			
				</c:when>
				
				<c:when test="${result == 'used-del1'}">
					<script>
					 alert("게시글이 삭제되었습니다.");
					 location.href="used_ca1";
					</script>			
				</c:when>
				
				<c:when test="${result == 'used-del2'}">
					<script>
					 alert("게시글이 삭제되었습니다.");
					 location.href="used_sh2";
					</script>			
				</c:when>
				

		</c:choose>
		
	</body>
</html>