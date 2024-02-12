<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>중고거래&캠핑장양도_글작성</title>
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
		<link href="../assets/css/community/listStyle.css" rel="stylesheet">
		<link href="../assets/css/community/viewStyle.css" rel="stylesheet">
		<link href="../assets/css/community/writeStyle.css" rel="stylesheet">
		<link href="../assets/css/used/used_write.css" rel="stylesheet">
		<link href="../assets/css/summernote-lite.css" rel="stylesheet">
		
		<!-- Template nWrite JS File -->
  		<script src="../assets/js/used/usedWrite.js"></script>
  		<script src="../assets/js/summernote.js"></script>
		<script src="../assets/js/summernote-lite.js"></script>
         <script src="../assets/js/lang/summernote-ko-KR.js"></script>

	</head>
	<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp" %>
	<!-- End Header -->
	
		<section class="notice">
			<!-- 중고거래&캠핑장양도_글쓰기 -->
	    	<h1>중고거래&캠핑장양도 글쓰기</h1>
			<form action="usedWrite" name="usedWriteFrm" method="post" enctype="multipart/form-data">
			    <table class="usedW_table">
			     <colgroup>
			        <col width="5%">
			        <col width="30%">
			        <col width="15%">
			        <col width="50%">
	   			</colgroup>
			      <tr>
			        <th style="text-align: center;">
		        	 	<select name="u_btype" id="used_trade" class="bType">
					       <option value="">유형</option>
					       <option value="trade1">중고거래</option>
					       <option value="transfer2">캠핑장양도</option>
					    </select>
			        </th>
			        <th colspan="3" style="text-align: left;"><input type="text" id="used_btitle" name="u_btitle" placeholder=" ※ 게시글 제목을 입력해주세요."> </span></th>
			      </tr>
			      
			      <tr class="usedW_writer">
			        <td style="text-align: center;"><strong>작성자 | </strong></td>
			        <td class="writer_input" colspan="3"><input type="text" name="id" value="aaa" readonly="readonly"> </td>
			      </tr>

			      
			      <tr class="used_top u_bottom">
			        <td class="used_price"><strong>가격  | </strong></td>
			        <td class="used_input1"><input class="used_input1" type="text" name="u_bprice" id="u_bprice" placeholder="숫자만 입력하세요." > <span>원</span></td>
			        <td class="used_region"><strong>거래장소 | </strong></td>
					<td>
						<select name="u_blocal" id="used_region" class="used_region">
					       <option value="서울시">서울시</option>
					       <option value="부산시">부산시</option>
					       <option value="대구시">대구시</option>
					       <option value="인천시">인천시</option>
					       <option value="광주시">광주시</option>
					       <option value="대전시">대전시</option>
					       <option value="울산시">울산시</option>
					       <option value="세종시">울산시</option>
					       <option value="경기도">경기도</option>
					       <option value="강원도">강원도</option>
					       <option value="충청북도">충청북도</option>
					       <option value="충청남도">충청남도</option>
					       <option value="전라북도">전라북도</option>
					       <option value="전라남도">전라남도</option>
					       <option value="경상북도">경상북도</option>
					       <option value="경상남도">경상남도</option>
					       <option value="제주도">제주도</option>
					    </select>
					</td>
			      </tr>
			      
			      <tr>
			        <td colspan="4" class="article"><textarea rows="9" class="used_bcontent" name="u_bcontent" id="summernote" placeholder=" ※ 게시글 내용을 입력해주세요."></textarea> </td>
			      </tr>
			      
			      <tr class="u_files_up">
			      	<td><strong>첨부파일 1 |</strong></td>
			        <td colspan="3" class="article">
			        <span>※해당 사진은 메인사진으로 사용됩니다.</span>
			        <div class="file-preview-container" id="filePreviewContainer1"></div>
			        <input type="file" class="u_files_input" name="uimg">
			        </td>
			      </tr>
			      <tr class="u_files_up">
			      	<td><strong>첨부파일 2 |</strong></td>
			        <td colspan="3" class="article">
			        <div class="file-preview-container" id="filePreviewContainer2"></div>
			        <input type="file" class="u_files_input" name="u_files" ></td>
			      </tr>
			       <tr class="u_files_up">
			      	<td><strong>첨부파일 3 |</strong></td>
			        <td colspan="3" class="article">
			        <div class="file-preview-container" id="filePreviewContainer3"></div>
			        <input type="file" class="u_files_input" name="u_files" ></td>
			      </tr>
			      <tr class="u_files_up u_bottom">
			      	<td><strong>첨부파일 4 |</strong></td>
			        <td colspan="3" class="article">
			        <div class="file-preview-container" id="filePreviewContainer4"></div>
			        <input type="file" class="u_files_input" name="u_files" ></td>
			      </tr>
			      
			    </table>
			   
			</form>
			
			<div class="listBtn">
		    	<a><div class="list" id="u_saveBtn">저장</div></a>
		    	<a href="fList"><div class="list">취소</div></a>
			</div>
 		 </section>
		
		<!-- ======= Footer ======= -->
	  	<%@include file="../include/footer.jsp" %>
	 	<!-- End Footer -->
	</body>
</html>