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

<!-- Template Main CSS File -->
<link href="../assets/css/main2.css" rel="stylesheet">
<link href="../assets/css/used/used.css" rel="stylesheet" type="text/css">
<link href="../assets/css/used/used_total.css" rel="stylesheet" type="text/css">
<link href="../assets/css/review/header2.css" rel="stylesheet" type="text/css">

<!-- Template Main CSS File -->
<script src="../assets/js/used/used.js"></script>

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
					<form action="used_sh2" name="used_sh2Frm" method="get">
						<!-- .검색 폼시작 -->
						<fieldset>
							<legend>게시판 검색 폼</legend>
							<label>
								<input type="checkbox" name="category" value="all" class="MS_input_checkbox used_category" > 전체
							</label> 
							<label> 
								<input type="checkbox" name="category" value="u_btitle" class="MS_input_checkbox used_category"> 제목
							</label> 
							<label> 
								<input type="checkbox" name="category" value="n_bcontent" class="MS_input_checkbox used_category"> 내용
							</label> 
							<span class="key-wrap"> 
								<input type="text" name="searchWord" class="MS_input_txt searchWord"> <a id="searchBtn_sh2"><img src="https://image.makeshop.co.kr/makeshop/d3/basic_simple/bbs/btn_bbs_sch.gif" alt="검색" title="검색"></a>
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
						<input type="hidden" name="session_id" id="session_id" value="${session_id}">
						<input type="radio" name="tabview" id="tabview1" value="trade1" class="trade1">
						<label for="tabview1">중고거래</label> 
						<input type="radio" name="tabview" id="tabview2" value="transfer2" class="transfer2" checked> 
						<label for="tabview2">캠핑장양도</label>
						
						
						<!--중고양도 -->
						<div class="consolebox2">
							<div class="bbs-table-list">
								<div class="view-complete">
									<label> 
									<input type="checkbox" name="shname" class="MS_input_checkbox possible" id="showCompleted2" >거래가능내역보기
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
										<c:forEach var="udto" items="${map2.list2}">
										<li>
											<a href="usedcontent?u_bno=${udto.u_bno}&u_btype=${udto.u_btype}"> 
											<span><img src="/upload/${udto.u_mimg}"></span>
											<div class="used_title">
											<strong>${udto.u_btitle}</strong>
											</div>
											</a> 
											<c:set var="price" value="${udto.u_bprice}" />
											<strong><fmt:formatNumber value="${price}" pattern="#,##0원" /></strong>
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
					<!-- viewtab-menu  -->
				</div>
				<!-- bbs-tit  -->

				<!-- 하단 페이징 & 버튼 -->
				<div class="bbs-btm">
					<div class="bbs-link">
						<a class="CSSbuttonWhite">글쓰기</a>
					</div>

					<!-- 하단 넘버링  -->
					<div>
						<ul class="page-num-used">
							<a href="used_sh2?page=1&category=${map2.category}&searchWord=${map2.searchWord}"><li class="first-num"></li></a>
							<c:if test="${map2.page>1 }">
					       <a href="used_sh2?page=${map2.page-1}&category=${map2.category}&searchWord=${map2.searchWord}"><li class="prev-num"></li></a>
					       </c:if>
					      <c:if test="${map2.page<=1 }">
					       <li class="prev-num"></li>
					       </c:if>
							
					      <c:forEach var="i" begin="${map2.startPage}" end="${map2.endPage}">
					      	<c:if test="${map2.page==i}">
					      	<li class="num-used on"><div>${i}</div></li>
					      	</c:if>
					      	<c:if test="${map2.page!=i}">
					      	<a href="used_sh2?page=${i}&category=${map2.category}&searchWord=${map2.searchWord}">
					    	  <li class="num-used"><div>${i}</div></li>
					      	</a>
					      	</c:if>
					      </c:forEach>
					      
					      <c:if test="${map2.page<map2.maxPage}">
					       <a href="used_sh2?page=${map2.page+1}&category=${map2.category}&searchWord=${map2.searchWord}"><li class="next-num"></li></a>
					     </c:if>
					      <c:if test="${map2.page>=map2.maxPage}">
					       <li class="next-num"></li>
					     </c:if>
					     	<a href="used_sh2?page=${map2.maxPage}&category=${map2.category}&searchWord=${map2.searchWord}"><li class="last-num"></li></a>
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