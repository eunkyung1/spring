<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>중고거래&캠핑장 양도</title>
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
	<link href="../assets/css/used/used_total.css" rel="stylesheet" type="text/css">
	<link href="../assets/css/review/reviewcontent.css" rel="stylesheet" type="text/css">
	<link href="../assets/css/review/siteReview.css" rel="stylesheet" type="text/css">
	<link href="../assets/css/review/listStyle2.css" rel="stylesheet" type="text/css">
	<link href="../assets/css/review/header2.css" rel="stylesheet" type="text/css">
	
	
	<!-- Template Main JS File -->
	<script src="../assets/js/used/usedTotal.js"></script>

</head>
<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp"%>
	<!-- End Header -->
	
	
	<section class="headerCss">
		<div id="contentWrap">
			<div id="content">
				<div id="bbsData">
					<div class="page-body">
						<div class="camp-img-div">
							<img src="/assets/img/campUsed/free-icon-camp-8486682.png" alt="캠핑용품리뷰">
							<c:if test="${map.udto.u_btype == 'trade1'}">
							<h1>중고거래</h1>
							</c:if>
							<c:if test="${map.udto.u_btype == 'transfer2'}">
							<h1>캠핑장양도</h1>
							</c:if>
						</div>
		
						<br> <br> <br>
						<div class="bbs-tit">
							<c:if test="${map.udto.u_btype == 'trade1'}">
							<h3>중고거래</h3>
							</c:if>
							<c:if test="${map.udto.u_btype == 'transfer2'}">
							<h3>캠핑장양도</h3>
							</c:if>
						</div>
						<dl class="prd-tinfo">
				
							<dt>
								<a class="tinfo_img"><img src="/upload/${map.udto.u_mimg}" /></a>
							</dt>
							<dd>
								<ul>
									<li class="name"><span class="tit">중고거래명 : </span> <a>${map.udto.u_btitle}</a></li>
									<li class="price"><span class="tit">판매가 : </span>
									<c:set var="price" value="${map.udto.u_bprice}" />
									<fmt:formatNumber value="${price}" pattern="#,##0원" />
									</li>
									<li class="u_local"><span class="tit">판매지역 : </span>${map.udto.u_blocal}</li>
								</ul>
							</dd>
						</dl>
						<br>
						
					<form id="comment_form">
						<input type="hidden" id="session" value="${session_id}"/>
						<input type="hidden" id="u_btype" value="${map.udto.u_btype}"/>
						<input type="hidden" id ="u_bstatus" value="${map.udto.u_bstatus}"/>
						
						<div class="bbs-table-view" >
							<table summary="게시글 보기">
								<caption>게시글 보기</caption>
								<thead>
									<tr class="bbs-table-btitle">
										<th><div class="tb-center ${map.udto.u_bno}">${map.udto.u_btitle }</div></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="cont-sub line" style="padding:0 0 5px 0;">
											<div class="cont-sub-des">
												<div class="${map.udto.id}">
													<span class="writer"><strong>작성자 :</strong> ${map.udto.id}</span> 
												</div>
												<div class="cont_top_date">
													<span class="content_date"><fmt:formatDate value="${map.udto.u_bdate}" pattern="yyyy-MM-dd HH:dd"/></span>
													<span class="content_hit"><strong>조회:</strong> ${map.udto.u_bhit}</span>
												</div>
											</div>
											<div class="cont_top_price">
												<span class="content_bprice"><strong>가격 : </strong>
												<c:set var="price" value="${map.udto.u_bprice}" />
												<fmt:formatNumber value="${price}" pattern="#,##0원" />
												</span>
												<span class="content_blocal"><strong>판매지역 : </strong>${map.udto.u_blocal}</span>
											</div>
										</td>
									</tr>
									<tr>
										<td class="data-bd">
											<div class="data-bd-cont">
												${map.udto.u_bcontent }
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<div id="comment_list_0"></div>
								
								<div class="bfile img_Upload line">
									<tr>
										<div class="img_name">
											<td><strong>이미지</strong></td>
										</div>
										
										<c:set var="fileNames" value="${map.udto.u_bfile}" />
										<c:set var="fileNameList" value="${fn:split(fileNames, ',')}" />
										
										<div class="bfile_ucontent">
										    <div class="u_images-container">
										    	
										        <div class="u_image">
									            <img src="/upload/${map.udto.u_mimg}" class="modal-u_trigger">
										        <c:if test="${map.udto.u_mimg != 'noPhoto_b.jpg' }">
										            <span id="u_image_mimg">${map.udto.u_mimg}</span>
										        </c:if>
										        
										        <c:if test="${map.udto.u_mimg == 'noPhoto_b.jpg' }">
										            <span id="u_image_mimg">이미지가 없습니다.</span>
										        </c:if>
										        </div>
										        <c:forEach var="fileName" items="${fileNameList}">
										            <div class="u_image">
										                <img src="/upload/${fileName}" class="modal-u_trigger" data-modal-image="/upload/${fileName}">
										                <span>${fileName}</span>
										            </div>
										        </c:forEach>
										    </div>
										    
										    <div class="image_show">
										    <h9 class="image_show_text">이미지를 클릭하면 크게 보실 수 있습니다.</h9>
										    </div>
										
										</div>
									</tr>
								</div>
								
								<!-- 모달창 -->
								<div id="u_myModal" class="u_modal">
								  <div class="u_modal-content">
								    <span class="close">&times;</span>
								    <img id="u_modalImage" src="" alt="모달 이미지">
								  </div>
								</div>
								

								
								<!-- 삭제,수정, 목록버튼 -->
								<div class="u_listBtn">
									<button type="button" class="u_list" id="u_listBtn">목록</button>
									<button type="button" class="u_list u_delBtn pri">삭제</button>
									<button type="button" class="u_list u_updateBtn pri">수정</button>
									<button type="button" class="u_list u_comple pri">거래완료</button>
								</div>

								
								<!-- 댓글입력창 -->
								<table>
									<tr>
										<textarea class="u_replycont" placeholder=" ※ 댓글을 입력하세요. (타인을 향한 욕설 및 비방은 무통보 삭제됩니다.)"></textarea>
										<button id="u_replybtn">등록</button>
									</tr>
								</table>

								<!-- 이전글/다음글-->
								<table
									style="margin-top: -150px; position: relative; top: 120px; font-size: 14px; width: 1100px;">
									<tr>
										<td colspan="4"><strong>이전글</strong> <span class="separator">|</span>
											<c:if test="${map.preudto!=null}">
											<a href="usedcontent?u_bno=${map.nextudto.u_bno}&u_btype=${map.nextudto.u_btype}">${map.preudto.u_bno} || ${map.preudto.u_btitle}</a></td>
										</c:if>
										<c:if test="${map.preudto==null }">
											다음글 없습니다.
										</c:if>
									</tr>
									<tr>
										<td colspan="4"><strong>다음글</strong> <span class="separator">|</span>
										<c:if test="${map.nextudto!=null}">
											<a href="usedcontent?u_bno=${map.nextudto.u_bno}&u_btype=${map.nextudto.u_btype}">${map.nextudto.u_bno} || ${map.nextudto.u_btitle}</a></td>
										</c:if>
										<c:if test="${map.nextudto==null }">
											다음글 없습니다.
										</c:if>
									</tr>
								</table>
								<!-- 이전글/다음글 끝-->

							
						</div>
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

</body>
</html>