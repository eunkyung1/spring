<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항_글보기</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <meta content="" name="description">
	    <meta content="" name="keywords">
	
	    <!-- Favicons -->
	    <link href="assets/img/favicon.png" rel="icon">
	    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
	
	    <!-- Google Fonts -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
	
	    <!-- Vendor CSS Files -->
	    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
	    <link href="../assets/vendor/aos/aos.css" rel="stylesheet">
	    <link href="../assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
	    <link href="../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
	
	    <!-- Template Main CSS File -->
 		<link href="../assets/css/main2.css" rel="stylesheet">
       	<link href="../assets/css/header.css" rel="stylesheet">
		<link href="../assets/css/commuinty/viewStyle.css" rel="stylesheet">
	</head>
	<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp" %>
	<!-- End Header -->
	
		<section class="notice">
		
			<!-- 공지사항 글보기 -->
	    	<h1 style="float: left; margin: 40px 0 0 700px; font-weight: 700; position: relative; left:50px;">공지사항 게시글</h1>
		    <table>
		     <colgroup>
		        <col width="10%">
		        <col width="51%">
		        <col width="15%">
		        <col width="12%">
		        <col width="12%">
   			</colgroup>
		     <tr id="notice_top">
		        <th style="text-align: center;"><strong>${map.nbdto.n_bno}</strong></th>
		        
		        <c:if test="${map.nbdto.n_btype=='instapayment'}">
		        <th style="text-align: left;"><span>[공지사항]&nbsp${map.nbdto.n_btitle}</span></th>
		        </c:if>
		        
		        <c:if test="${map.nbdto.n_btype=='event'}">
		        <th style="text-align: left;"><span>[이벤트]&nbsp${map.nbdto.n_btitle}</span></th>
		        </c:if>
		        
		        <th style="text-align: right;"><strong>작성일</strong></th>
		        <th>
				<fmt:formatDate value="${map.nbdto.n_bdate}" pattern="yyyy-MM-dd"/>
				</th>
		      </tr>
		      <tr id="notice_top2">
		        <td style="text-align: center;"><strong>작성자</strong ></td>
		        <td>${nbdto.id}</td>
		        <td style="text-align: right;"><strong>조회수</strong></td>
		        <td>${map.nbdto.n_bhit}</td>
		      </tr>
		      <tr>
		        <td colspan="4" class="article notice_content" >${map.nbdto.n_bcontent}</td>
		      </tr>
		       <tr id="notice_bfile">
		        <td class="article" style="text-align: center;"><strong>첨부파일</strong>
		        </td>
		      
		        <c:if test="${map.nbdto.n_bfile!=null}">
		        <td colspan="3">${map.nbdto.n_bfile} 

		        </td>
		        </c:if>
		        
		        <c:if test="${map.nbdto.n_bfile==null}">
		        <td colspan="3">※첨부파일 없음</td>
		        </c:if>
		      </tr>
		    
		      <tr style="border-bottom: 2px solid #009223;">
		      	<td><strong>이미지 파일</strong></td>
		      	<td colspan="3" id="notice_img" ><img src="/upload/${map.nbdto.n_bfile} " style="width:50%"></td>
		      </tr>
		    
		    </table>
		    
		    <!-- 버튼 -->
		    <div class="listBtn">
		    	<a href="nList"><button class="list">목록</button></a>
		    	<button class="list">삭제</button>
		    	<a href="nUpdate?n_bno=${nbdto.n_bno}"><button class="list">수정</button></a>
		    </div>
		    
		     <!-- 댓글입력-->
		    <table id="replyPw">
			    <tr>
				    <td id="replyBorder">
					 	<strong>댓글 비밀번호&nbsp;&nbsp;</strong><input type="password" name="replyPw" id="replyIPw" placeholder=" ※ 입력시 비밀글로 저장">
				    </td>
			    </tr>
		    </table>
			 <table style="position: relative; bottom: 200px;">
			  <tr>
			  	<td style="display: flex; border: 1px solid white; margin: -80px 0 0 -20px;">
				  	<textarea placeholder=" ※ 댓글을 입력하세요. (타인을 향한 욕설 및 비방은 무통보 삭제됩니다.)" style="width: 1200px; "></textarea>
				  	<button id="replybtn">등록</button>
			  	</td>
			  </tr>
		   	</table>
		    <!-- 이전글/다음글-->
		    <table id="view_title">
		      <tr>
		        <td colspan="4"><strong>다음글</strong> <span class="separator">|</span><a href="#"> [키즈잼] 2월 프로그램 안내</a></td>
		      </tr>
		      <tr>
		        <td colspan="4"><strong>이전글</strong> <span class="separator">|</span><a href="#"> [키즈잼] 2020년 1분기 정기 휴관일 안내</a></td>
		      </tr>
		    </table>
		    <!-- 이전글/다음글 끝-->
		    
		    <!-- 댓글보기-->
		    <table style="margin-top: 70px;">
		      <td style="font-weight: 700">총<strong style="color: #009223">&nbsp;&nbsp;5</strong>&nbsp;개의 댓글이 등록되었습니다.</td>
			  <tr>
				<td><strong>댓글 작성자</strong> | <span style="color: blue;">aaa</span>&nbsp;&nbsp;<span>[2024-12-12 15:27:23:00]</span>
				<li id="replyTxt">&nbsp;&nbsp;댓글내1용일 들어갑니다. <br>ex)이벤트 너무 좋아요! 꼭 참여해서 혜택받아볼게요!</li>
				<li id="replyBtn">
					<button id="rDelBtn">삭제</button>
					<button id="rUBtn">수정</button>
				</li>
				</td>			
			  </tr>
			  <tr>
				<td><strong>댓글 작성자</strong> | <span style="color: blue;">aaa</span>&nbsp;&nbsp;<span>[2024-12-12 15:27:23:00]</span>
				<li id="replyTxt">&nbsp;&nbsp;댓글내용일 들어갑니다. <br>ex)이벤트 너무 좋아요! 꼭 참여해서 혜택받아볼게요!</li>
				<li id="replyBtn">
					<button id="rDelBtn">삭제</button>
					<button id="rUBtn">수정</button>
				</li>
				</td>			
			  </tr>
			  <tr>
				<td><strong>댓글 작성자</strong> | <span style="color: blue;">aaa</span>&nbsp;&nbsp;<span>[2024-12-12 15:27:23:00]</span>
				<li id="replyTxt">&nbsp;&nbsp;댓글내용일 들어갑니다. <br>ex)이벤트 너무 좋아요! 꼭 참여해서 혜택받아볼게요!</li>
				<li id="replyBtn">
					<button id="rDelBtn">삭제</button>
					<button id="rUBtn">수정</button>
				</li>
				</td>			
			  </tr>
			  <tr>
				<td><strong>댓글 작성자</strong> | <span style="color: blue;">aaa</span>&nbsp;&nbsp;<span>[2024-12-12 15:27:23:00]</span>
				<li id="replyTxt">&nbsp;&nbsp;댓글내용일 들어갑니다. <br>ex)이벤트 너무 좋아요! 꼭 참여해서 혜택받아볼게요!</li>
				<li id="replyBtn">
					<button id="rDelBtn">삭제</button>
					<button id="rUBtn">수정</button>
				</li>
				</td>			
			  </tr>
			  <tr>
				<td><strong>댓글 작성자</strong> | <span style="color: blue;">aaa</span>&nbsp;&nbsp;<span>[2024-12-12 15:27:23:00]</span>
				<li id="replyTxt">&nbsp;&nbsp;댓글내용일 들어갑니다. <br>ex)이벤트 너무 좋아요! 꼭 참여해서 혜택받아볼게요!</li>
				<li id="replyBtn">
					<button id="rDelBtn">삭제</button>
					<button id="rUBtn">수정</button>
				</li>
				</td>			
			  </tr>
			  
		    </table>
		    <!-- 댓글보기 끝-->
 		 </section>
		
		<!-- ======= Footer ======= -->
	  	<%@include file="../include/footer.jsp" %>
	 	<!-- End Footer -->
	</body>
</html>