/**
 중고거래/중고양도 js* 
 */


 $(function(){
	 
//--중고거래와 양도거래 클릭시 다르게 보여주기.
	$('#tabview1').prop('checked',true);
	$('.consolebox1').show();
	$('.consolebox2').hide();
	
	$('input[name="tabview"]').change(function(){
		if($('#tabview1').is(':checked')){
			$('.consolebox1').show();
			$('.consolebox2').hide();
		}else if($('#tabview2').is(':checked')){
			$('.consolebox1').hide();
			$('.consolebox2').show();
		}
	})//input change
	
//--중고양도 내용가져오기
	$("#tabview2").click(function(){
		if($("input:checkbox[id=showCompleted]").is(":checked") == false){
	$.ajax({
		url:"/used/used_transfer",
		type:"post",
		data:{u_btype:"transfer2", page:"1"},
		dataType:"json", //받는파일형태 : text,json,xml
		success:function(data){
		alert("성공");
		console.log(data);
        var hdata = '';
		// JavaScript의 forEach 루프 사용
        data.list2.forEach(function(udto) {
            hdata += '<li>';
            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
            hdata += '<span><img src="/upload/' + udto.u_bfile + '"></span> ';
            hdata += '<div class="used_title">';
            hdata += '<strong>' + udto.u_btitle + '</strong><br>';
            hdata += '</div></a>';
            hdata += '<strong>' + udto.u_bprice +'원'+'</strong>';
            hdata += '<br>'
            // JavaScript에서의 조건문 수정
            if (udto.u_bstatus == '1') {
                hdata += '<span class="used-exchange">거래완료</span>';
            }
            
            if (udto.u_bstatus == '0') {
                hdata += '<span class="used-buy">거래중</span>';
            }
            
            hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
            hdata += '<p>HITS :' + udto.u_bhit + '</p>';
            hdata += '</li>';
        });//forEach

        $(".consolebox2 .fixed-img-collist .clear").html(hdata);
        
    },
	error:function(){
	alert("실패");
	}
	})//ajax끝

		}
	});//click
	
	/*하단 넘버링 구현*/
	/*
	function updatePagination(pageInfo) {
    var paginationHtml = '';
    
    // 첫 페이지
    paginationHtml += '<a href="used_transfer?page=1"><li class="first-num"></li></a>';

    // 이전 페이지
    if (pageInfo.page > 1) {
        paginationHtml += '<a href="used_transfer?page=' + (pageInfo.page - 1) + '"><li class="prev-num"></li></a>';
    } else {
        paginationHtml += '<li class="prev-num"></li>';
    }

    // 페이지 번호
    for (var i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
        if (pageInfo.page == i) {
            paginationHtml += '<li class="num-used on"><div>' + i + '</div></li>';
        } else {
            paginationHtml += '<a href="used_transfer?page=' + i + '"><li class="num"><div>' + i + '</div></li></a>';
        }
    }

    // 다음 페이지
    if (pageInfo.page < pageInfo.maxPage) {
        paginationHtml += '<a href="used_transfer?page=' + (pageInfo.page + 1) + '"><li class="next-num"></li></a>';
    } else {
        paginationHtml += '<li class="next-num"></li>';
    }

    // 마지막 페이지
    paginationHtml += '<a href="used_transfer?page=' + pageInfo.endPage + '"><li class="last-num"></li></a>';

    paginationHtml += '</ul>';

    // 업데이트된 넘버링을 적용
    $(".page_under.page-num-used").html(paginationHtml);
}*/

	
//--중고거래-- 거래가능내역 true, flase
 	$("#showCompleted").click(function(){
	if($("input:checkbox[id=showCompleted]").is(":checked") == true) {
		var possible = 0;
		$.ajax({
			url:"/used/possible_t",
			type:"post",
			data:{"u_bstatus":possible},
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
			  var hdata = '';

                // JavaScript의 forEach 루프 사용
					data.forEach(function(udto) {
                    hdata += '<li>';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
                    hdata += '<span><img src="/upload/' + udto.u_bfile + '"></span> ';
                    hdata += '<div class="used_title">';
                    hdata += '<strong>' + udto.u_btitle + '</strong>';
                    hdata += '</div></a>';
                    hdata += '<strong>' + udto.u_bprice +'원'+'</strong><br>';
                    hdata += '<span class="used-buy">거래중</span>';
                    hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
                    hdata += '<p>HITS :' + udto.u_bhit + '</p>';
                    hdata += '</li>';
                });

                $(".consolebox1 .fixed-img-collist .clear").html(hdata);
			
			},
			error:function(){
			alert("실패");
			}
			})//ajax끝    
	}else{
		
			$.ajax({
			url:"/used/used_trade1",
			type:"post",
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
	
	        var hdata = '';
	
	        // JavaScript의 forEach 루프 사용
	        data.forEach(function(udto) {
	            hdata += '<li>';
	            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
	            hdata += '<span><img src="/upload/' + udto.u_bfile + '"></span> ';
	            hdata += '<div class="used_title">';
	            hdata += '<strong>' + udto.u_btitle + '</strong>';
	            hdata += '</div></a>';
	            hdata += '<strong>' + udto.u_bprice +'원'+'</strong><br>';
	            
	            // JavaScript에서의 조건문 수정
	            if (udto.u_bstatus == '1') {
	                hdata += '<span class="used-exchange">거래완료</span>';
	            }
	            
	            if (udto.u_bstatus == '0') {
	                hdata += '<span class="used-buy">거래중</span>';
	            }
	            
	            hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
	            hdata += '<p>HITS :' + udto.u_bhit + '</p>';
	            hdata += '</li>';
	        });//forEach
	
	        $(".consolebox1 .fixed-img-collist .clear").html(hdata);
	    },
		error:function(){
		}
		})//ajax끝
		
	
	}//else
	
	})//click(#showCompleted)

//--중고양도-- 거래가능내역 true, flase
 	$("#showCompleted2").click(function(){
	if($("input:checkbox[id=showCompleted2]").is(":checked") == true) {
		var possible = 0;
		$.ajax({
			url:"/used/possible_t2",
			type:"post",
			data:{"u_bstatus":possible},
			dataType:"json",
			success:function(data){
			  var hdata = '';

                // JavaScript의 forEach 루프 사용
					data.forEach(function(udto) {
                    hdata += '<li>';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
                    hdata += '<span><img src="/upload/' + udto.u_bfile + '"></span> ';
                    hdata += '<div class="used_title">';
                    hdata += '<strong>' + udto.u_btitle + '</strong>';
                    hdata += '</div></a>';
                    hdata += '<strong>' + udto.u_bprice +'원'+'</strong><br>';
                    hdata += '<span class="used-buy">거래중</span>';
                    hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
                    hdata += '<p>HITS :' + udto.u_bhit + '</p>';
                    hdata += '</li>';
                });

                $(".consolebox2 .fixed-img-collist .clear").html(hdata);
			
			},
			error:function(){
			}
			})//ajax끝    
}else{
		$.ajax({
		url:"/used/used_transfer2",
		type:"post",
		dataType:"json", //받는파일형태 : text,json,xml
		success:function(data){

        var hdata = '';

        // JavaScript의 forEach 루프 사용
        data.forEach(function(udto) {
            hdata += '<li>';
            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
            hdata += '<span><img src="/upload/' + udto.u_bfile + '"></span> ';
            hdata += '<div class="used_title">';
            hdata += '<strong>' + udto.u_btitle + '</strong>';
            hdata += '</div></a>';
            hdata += '<strong>' + udto.u_bprice +'원'+'</strong><br>';
            
            // JavaScript에서의 조건문 수정
            if (udto.u_bstatus == '1') {
                hdata += '<span class="used-exchange">거래완료</span>';
            }
            
            if (udto.u_bstatus == '0') {
                hdata += '<span class="used-buy">거래중</span>';
            }
            
            hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
            hdata += '<p>HITS :' + udto.u_bhit + '</p>';
            hdata += '</li>';
        });//forEach

       $(".consolebox2 .fixed-img-collist .clear").html(hdata);
    },
	error:function(){
	}
	})//ajax끝
	
}//else
})//click(#showCompleted)
	
/*첫번째 사진가지고 list 뿌리기*/  
     $('.image-container').each(function() {
            // span 요소의 데이터 속성에서 이미지 파일명 가져오기
            var imageFiles = $(this).data('images');
            if (imageFiles) {
                // 이미지 파일명을 쉼표로 분할하여 배열로 변환
                var imageArray = imageFiles.split(',');
                // 첫 번째 이미지 파일명 선택
                var firstImage = imageArray[0];
                if (firstImage) {
                    // 첫 번째 이미지 파일명을 img 요소의 src 속성에 설정하여 이미지 출력
                    $(this).find('img').attr('src', '/upload/' + firstImage);
                }
            }
        });
	
	
	
});//jquery