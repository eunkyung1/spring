<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑중고거래</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="../assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="../assets/vendor/aos/aos.css" rel="stylesheet">
<link href="../assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="../assets/css/main2.css" rel="stylesheet">
<link href="../assets/css/used/used.css" rel="stylesheet" type="text/css">
<link href="../assets/css/review/header2.css" rel="stylesheet" type="text/css">

<!-- Template Main CSS File -->
<script src="../assets/js/used.js"></script>
</head>
<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp"%>
	<!-- End Header -->

	<section class="headerCss">

		<div id="contentWrap">
			<div class="page-body">
				<div class="camp-img-div">
					<img src="/assets/img/campUsed/free-icon-camp-9056684.png"
						alt="중고거래이미지">
					<h1 style="text-align: center;">캠핑중고거래</h1>
				</div>
				<div class="bbs-sch">
					<form action="#" name="form1">
						<input type="hidden" name="s_id" value=""> 
						<input type="hidden" name="code" value="ocamall_image1"> 
						<input type="hidden" name="page" value="1">
						<input type="hidden" name="type" value="s"> 
						<input type="hidden" name="board_cate" value=""> 
						<input type="hidden" name="review_type" value="">
						<!-- .검색 폼시작 -->
						<fieldset>
							<legend>게시판 검색 폼</legend>
							<label>
								<input type="checkbox" name="shname" value="ok" class="MS_input_checkbox"> 이름
							</label> 
							<label> 
								<input type="checkbox" name="ssubject" value="ok" checked="checked" class="MS_input_checkbox"> 제목
							</label> 
							<label> 
								<input type="checkbox" name="scontent" value="ok" class="MS_input_checkbox"> 내용
							</label> 
							<span class="key-wrap"> 
								<input type="text" name="stext" value="" class="MS_input_txt"> <a href="#"> <img src="https://image.makeshop.co.kr/makeshop/d3/basic_simple/bbs/btn_bbs_sch.gif" alt="검색" title="검색"></a>
							</span>
						</fieldset>
					</form>
					<!-- .검색 폼 끝 -->
				</div>

				
				<!-- .bbs-sch -->
				<br> <br> <br>
				<div class="bbs-tit">
					<div class="viewtab-menu">
		
						<!-- 중고거래, 중고양도 체크  -->
						<input type="radio" name="tabview" id="tabview1">
						<label for="tabview1">중고거래</label> 
						<input type="radio" name="tabview" id="tabview2"> 
						<label for="tabview2">중고양도</label>
						
						<!-- 중고거래 -->
						<div class="consolebox1">
							<div class="bbs-table-list">
								<div class="view-complete">
									<label> 
									<input type="checkbox" name="shname" class="MS_input_checkbox" id="showCompleted" >거래가능내역보기
									</label>
								</div>
								<table summary="제목, 작성일, 조회수, 동영상">
									<caption>갤러리 게시글</caption>
									<colgroup>
										<col width="40">
										<col width="40">
										<col width="*">
										<col width="100">
										<col width="100">
									</colgroup>
									<tbody>
									</tbody>
								</table>
								<div class="fixed-img-collist">
									<ul class="clear">
										<c:forEach var="udto" items="${map.list}">
										<li>
											<a href="usedcontent?u_bno=${udto.u_bno}"> 
												<span><img src="/upload/${udto.u_bfile}"></span> 
												<div class="used_title">
												<strong>${udto.u_btitle}</strong>
												</div>
											</a> 
											<strong>${udto.u_bprice}원</strong>
											<br>
											<c:if test="${udto.u_bstatus=='1'}">
											<span class="used-exchange">거래완료</span>
											</c:if>
											
											<c:if test="${udto.u_bstatus=='0'}">
											<span class="used-buy">거래중</span>
											</c:if>
											<p><fmt:formatDate value="${udto.u_bdate}" pattern="yyyy-MM-dd"/></p>
											<p>HITS :${udto.u_bhit}</p>
										</li><!--li  -->
										</c:forEach>
										
										
									</ul>

								</div>
								<!-- fixed-img-collist   -->
							</div>
							<!-- bbs-table-list  -->
						</div>
						<!-- consolebox  -->
						
						<!--중고양도 -->
						<div class="consolebox2">
							<div class="bbs-table-list">
								<div class="view-complete">
									<label> 
									<input type="checkbox" name="shname" value="ok" class="MS_input_checkbox" id="showCompleted2" >거래가능내역보기
									</label>
								</div><!-- End view-complete -->
								<table summary="제목, 작성일, 조회수, 동영상">
									<caption>갤러리 게시글</caption>
									<colgroup>
										<col width="40">
										<col width="40">
										<col width="*">
										<col width="100">
										<col width="100">
									</colgroup>
									<tbody>
									</tbody>
								</table>
								<div class="fixed-img-collist">
									<ul class="clear">
									<li>
										<a href="usedcontent?u_bno=${map.udto.u_bno}"> 
											<span><img src="/upload/${map.udto.u_bfile}"></span> 
											<div class="used_title">
											<strong>${map.udto.u_btitle}</strong>
											</div>
										</a> 
										<strong>${map.udto.u_bprice}원</strong>
										<br>
										<c:if test="${map.udto.u_bstatus=='1'}">
										<span class="used-exchange">거래완료</span>
										</c:if>
										
										<c:if test="${map.udto.u_bstatus=='0'}">
										<span class="used-buy">거래중</span>
										</c:if>
										<p><fmt:formatDate value="${map.udto.u_bdate}" pattern="yyyy-MM-dd"/></p>
										<p>HITS :${map.udto.u_bhit}</p>
										</li>
									</ul>
								</div>
								<!-- fixed-img-collist   -->
							</div>
					<!-- viewtab-menu  -->
				</div>
				<!-- bbs-tit  -->

				<!-- 하단 페이징 & 버튼 -->
				<div class="bbs-btm">
					<div class="bbs-link">
						<a href="usedWrite" class="CSSbuttonWhite">글쓰기</a>
					</div>

					<!-- 하단 넘버링  -->
					<div>
						<ul class="page-num-used">
							<a href="used?page=1"><li class="first-num"></li></a>
							<c:if test="${map.page>1 }">
					       <a href="used?page=${map.page-1}"><li class="prev-num"></li></a>
					       </c:if>
					      <c:if test="${map.page<=1 }">
					       <li class="prev-num"></li>
					       </c:if>
							
					      <c:forEach var="i" begin="${map.startPage}" end="${map.endPage}">
					      	<c:if test="${map.page==i}">
					      	<li class="num-used on"><div>${i}</div></li>
					      	</c:if>
					      	<c:if test="${map.page!=i}">
					      	<a href="used?page=${i}">
					    	  <li class="num"><div>${i}</div></li>
					      	</a>
					      	</c:if>
					      </c:forEach>
					      
					      <c:if test="${map.page<map.maxPage}">
					       <a href="used?page=${map.page+1}"><li class="next-num"></li></a>
					     </c:if>
					      <c:if test="${map.page>=map.maxPage}">
					       <li class="next-num"></li>
					     </c:if>
					     	<a href="used?page=${map.endPage}"><li class="last-num"></li></a>
					    </ul>
			
						
					</div>
					<!-- //하단 페이징 & 버튼 -->

				</div>
				<!-- .page-body -->
			</div>
			<!-- #bbsData -->
		</div>
		<!-- #content -->
		</div>
		<!-- #contentWrap -->
	</section>



	<!-- ======= Footer ======= -->
	<%@include file="../include/footer.jsp"%>
	<!-- End Footer -->
</body>

</html>