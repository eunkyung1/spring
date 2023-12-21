<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/read.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
	<form action="/" method="post" id="bFrm" name="bFrm" >
	<input type="hidden" name="bno" value="${map.bdto.bno}">
    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${map.bdto.btitle}</strong></td>
      </tr>
      <tr>
        <td>${session_id }</td>
        <td>조회수</td>
        <td>${map.bdto.bhit}</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${map.bdto.bcontent}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>파일 이름</strong> <span class="separator">|</span>${map.bdto.bfile }</td>
      </tr>
      <tr>
        <td colspan="3"><strong>파일 이미지</strong> <span class="separator">|</span><img src="/upload/${map.bdto.bfile}"></td>
      </tr>
      <tr>
      <c:if test="${map.bdtonext!=null}">
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span><a href="bView?bno=${map.bdtonext.bno}">${map.bdtonext.bno} || ${map.bdtonext.btitle}</a></td>
      </c:if>
      <c:if test="${map.bdtonext==null}">
        <td colspan="3"><strong>다음 글은 없습니다.</strong></td>
      </c:if>
      </tr>
      <c:if test="${map.bdtoprev!=null}">
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span><a href="bView?bno=${map.bdtoprev.bno}">${map.bdtoprev.bno} ||${map.bdtoprev.btitle}</a></td>
      </c:if>
      <c:if test="${map.bdtoprev==null}">
        <td colspan="3"><strong>이전글은 없습니다.</strong></td>
      </c:if>
      </tr>
    </table>
    <script>
    $(function(){
    	$(".updateBtn").click(function(){
    		alert("수정페이지로 이동합니다.");
    		$("#bFrm").attr("action","bUpdate").submit();
    	});
    	$(".listBtn").click(function(){
    		alert("수정페이지로 이동합니다.");
    		$("#bFrm").attr("action","bList").submit();
    	});
    	$(".deleteBtn").click(function(){
    		if(confirm("게시글을 삭제하시겠습니까?")){
    		$("#bFrm").attr("action","bDelete").submit();
    		}
    	});
    	$(".replyBtn").click(function(){
    		alert("수정페이지로 이동합니다.");
    		$("#bFrm").attr("action","bReply").submit();
    	});
    });
    
    </script>

   <div class="list listBtn">목록</div>
   <div class="list deleteBtn">삭제</div>
   <div class="list updateBtn">수정</div>
   <div class="list replyBtn">답변달기</div>
  </section>
	</form>
</body>
</html>