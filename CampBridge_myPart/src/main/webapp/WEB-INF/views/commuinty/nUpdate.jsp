<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항_글수정</title>
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
		<link href="../assets/css/commuinty/listStyle.css" rel="stylesheet">
		<link href="../assets/css/commuinty/viewStyle.css" rel="stylesheet">
		<link href="../assets/css/commuinty/writeStyle.css" rel="stylesheet">
		<script src="../assets/js/summernote-lite.js"></script>
        <script src="../assets/js/summernote/lang/summernote-ko-KR.js"></script>
		<link href="../assets/css/summernote-lite.css" rel="stylesheet">
		
		<!-- Template nWrite JS File -->
  		<script src="../assets/js/nUpdate.js"></script>
	</head>

	<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp" %>
	<!-- End Header -->
	
		<section class="notice">
		
			<!-- 공지사항 글수정 -->
	    	<h1 style="float: left; margin: 40px; font-weight: 700; position: relative; left:235px; top: 30px;">공지사항 수정</h1>
		
			<form action="donUpdate" name="notice_Frm" id="notice_Frm" method="post" enctype="multipart/form-data">
				<input type="hidden" name="n_bfile" value="${nbdto.n_bfile}">
				<input type="hidden" name="n_bno" value="${nbdto.n_bno}">
			    <table>
			     <colgroup>
			        <col width="10%">
			        <col width="70%">
			        <col width="10%">
			        <col width="10%">
	   			</colgroup>
			      <tr>
			        <th style="text-align: center;">
			        
		        	 	<select name="n_btype" id="bType" class="bType">
					       <option value="instapayment" >공지사항</option>
					       <option value="event">이벤트</option>
					    </select>
			        </th>
			        <th colspan="3" style="text-align: left;"><input type="text" id="n_btitle" name="n_btitle" value="${nbdto.n_btitle }"></span></th>
			      </tr>
			      <tr style="border-bottom: 2px solid #009223">
			        <td style="text-align: center;"><strong>작성자 | </strong style="text-align: center;"></td>
			        <td><input type="text" value="${nbdto.id}" readonly="readonly" style="border: 1px solid transparent;"> </td>
			      </tr>
			      <tr>
			        <td colspan="4" class="article"><textarea rows="9" name="n_bcontent" id="summernote">${nbdto.n_bcontent }</textarea> </td>
			      </tr>
			      <tr style="border-bottom: 2px solid #009223; line-height: 20px;">
			        <td colspan="4" class="article"><input type="file" name="files1" id="n_bfile" value="${nbdto.n_bfile}"></td>
			      </tr>
			    </table>
			</form>
			
			<div class="listBtn">
		    	<a><div class="list" id="nUpdateBtn">수정</div></a>
		    	<a href="nList"><div class="list">취소</div></a>
			</div>
 		 </section>
		
		<!-- ======= Footer ======= -->
	  	<%@include file="../include/footer.jsp" %>
	 	<!-- End Footer -->
	</body>
</html>