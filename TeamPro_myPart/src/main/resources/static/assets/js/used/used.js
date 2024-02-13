/**
 중고거래/중고양도 js(ca_1,sh2)* 
 */
    
 $(function(){
	
/*글쓰기 로그인 막기*/
$(".CSSbuttonWhite").click(function(){
	var sessionId = $('#session_id').val();	
	if(!sessionId){
		alert("로그인 후에 글을 작성할 수 있습니다.");
		return false;
	}else{
		window.location.href = '/used/usedWrite';
	}
});

//--중고거래와 양도거래 클릭시 페이지 맞게 출력하기
$("#tabview1").click(function() {
    // used_ca1 페이지 열기
    window.location.href = "/used/used_ca1";
});

// tabview2 클릭 시
$("#tabview2").click(function() {
    // used_sh2 페이지 열기
    window.location.href = "/used/used_sh2";
});

/* 검색Form */
$("#searchBtn_ca1").click(function(){
	used_ca1Frm.submit();
});//click

$("#searchBtn_sh2").click(function(){
	used_sh2Frm.submit();
});//click

/* 체크박스 1개만 체크*/

 	$('.used_category[value="all"]').prop('checked', true);
    $('.used_category').click(function() {
        // 클릭된 체크박스의 상태를 확인합니다.
        var isChecked = $(this).prop('checked');
        
        // 모든 체크박스의 상태를 초기화합니다.
        $('.used_category').prop('checked', false);
        
        // 클릭된 체크박스의 상태만 변경합니다.
        $(this).prop('checked', isChecked);
    });
/* 거래가능내역 checked 유지*/

    var showCompletedChecked = false; // 체크박스의 상태를 저장하는 변수

    // 체크박스 클릭 이벤트 핸들러
    $("#showCompleted").click(function() {
        // 체크박스의 상태를 반전시킴
        showCompletedChecked = !showCompletedChecked;

        // 서버에 체크 상태를 저장하는 AJAX 요청 함수 호출
        saveCheckboxState(showCompletedChecked);
    });

    // 페이지가 로드될 때 서버에서 체크박스의 상태를 가져오는 함수 호출
    getCheckboxState();
    
function getCheckboxState() {
    $.ajax({
        url: "/get_checkbox_state",
        type: "get",
        success: function(response) {
            // 서버에서 받은 체크박스 상태를 변수에 저장
            showCompletedChecked = response.checked;

            // 체크박스의 상태를 서버에서 가져온 상태로 설정
            $("#showCompleted").prop("checked", showCompletedChecked);
        },
        error: function(xhr, status, error) {
            console.error('Error getting checkbox state:', error);
        }
    });
}//function(getCheckboxState)
function saveCheckboxState(checked) {
    $.ajax({
        url: "/save_checkbox_state",
        type: "post",
        data: {
            "checked": checked
        },
        success: function(response) {
            console.log("Checkbox state saved successfully.");
        },
        error: function(xhr, status, error) {
            console.error('Error saving checkbox state:', error);
        }
    });
}//function(saveCheckboxState)



	

//--중고거래-- 거래가능내역 true, flase
 	$("#showCompleted").click(function(){
	if($("input:checkbox[id=showCompleted]").is(":checked") == true) {
		var possible = 0;
		var u_btype = $("input[name='tabview']:checked").attr('class');
		
		$.ajax({
			url:"/used/possible_t",
			type:"post",
			data:{"u_bstatus":possible,"u_btype":u_btype},
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
			  var hdata = '';
                // JavaScript의 forEach 루프 사용
					data.list.for
					
					Each(function(udto) {
					var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
                    hdata += '<li class="'+udto.u_bstatus+'">';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
                    hdata += '<span><img src="/upload/' + udto.u_mimg + '"></span> ';
                    hdata += '<div class="used_title">';
                    hdata += '<strong>' + udto.u_btitle + '</strong>';
                    hdata += '</div></a>';
                    hdata += '<strong>' + price +'원'+'</strong><br>';
                    hdata += '<span class="used-buy">거래중</span>';
                    hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
                    hdata += '<p>HITS :' + udto.u_bhit + '</p>';
                    hdata += '</li>';
                });//forEach
                $(".consolebox1 .fixed-img-collist .clear").html(hdata);
				console.log(u_btype);
				console.log("페이지 돌 준비");
				console.log(data.u_btype);
				
			    var pdata ='';
			    
			     pdata += '<ul class="page-num-used">';
                pdata += '<a href="possible_t?page=1&u_btype='+possible+'&u_bstatus='+u_btype+'"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                pdata += data.page > 1 ? '<a href="possible_t?page=' + (data.page - 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
                for (var i = data.startPage; i <= data.endPage; i++) {
                    pdata += data.page == i ? '<li class="num-used on"><div>' + i + '</div></li>' : '<a href="possible_t?page=' + i +'&u_bstatus='+possible+'&u_btype='+u_btype+ '"><li class="num"><div>' + i + '</div></li></a>';
                }
                
                // 다음 페이지 링크
                pdata += data.page < data.maxPage ? '<a href="possible_t?page=' + (data.page + 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                pdata += '<a href="possible_t?page=' + data.endPage +'&u_bstatus='+possible+'&u_btype='+data.u_btype+ '"><li class="last-num"></li></a>';
                pdata += '</ul>';
				console.log("페이지 돌았다.");

			    $(".PageNum").html(pdata);
				    
                
                
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
				var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
				console.log("used_trade1가 돌아요");
	            hdata += '<li class="'+udto.u_bstatus+'">';
	            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
	            hdata += '<span><img src="/upload/' + udto.u_mimg + '"></span> ';
	            hdata += '<div class="used_title">';
	            hdata += '<strong>' + udto.u_btitle + '</strong>';
	            hdata += '</div></a>';
	            hdata += '<strong>' + price +'원'+'</strong><br>';
	            
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
		var u_btype = $("input[name='tabview']:checked").attr('class');
		$.ajax({
			url:"/used/possible_t",
			type:"post",
			data:{"u_bstatus":possible,"u_btype":u_btype},
			dataType:"json",
			success:function(data){
			  var hdata = '';
			  var pdata='';

                // JavaScript의 forEach 루프 사용
					data.forEach(function(udto) {
					var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
                    hdata += '<li>';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
                    hdata += '<span><img src="/upload/' + udto.u_mimg + '"></span> ';
                    hdata += '<div class="used_title">';
                    hdata += '<strong>' + udto.u_btitle + '</strong>';
                    hdata += '</div></a>';
                    hdata += '<strong>' + price +'원'+'</strong><br>';
                    hdata += '<span class="used-buy">거래중</span>';
                    hdata += '<p>' + new Date(udto.u_bdate).toLocaleDateString() + '</p>';
                    hdata += '<p>HITS :' + udto.u_bhit + '</p>';
                    hdata += '</li>';
                });//forEach

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
        data.list2.forEach(function(udto) {
			var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
            hdata += '<li>';
            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
            hdata += '<span><img src="/upload/' + udto.u_mimg + '"></span> ';
            hdata += '<div class="used_title">';
            hdata += '<strong>' + udto.u_btitle + '</strong>';
            hdata += '</div></a>';
            hdata += '<strong>' + price +'원'+'</strong><br>';
            
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


/*거래가능내역보기 하단 넘버링*/

function pageNum (){
	
$(document).on("click", ".page-num-used a", function(e) {
    e.preventDefault(); // 기본 동작 중단
    
    var page = ("#u_page").val();
    var u_btype = $("input[name='tabview']:checked").attr('class');
    var u_bstatus = $(".clear li").attr("class");
    var checkedValue = '';
    $('.used_category:checked').each(function(){
		checkedValue = $(this).val();
	});
    var searchWord = $(".searchWord").val();
   
    if (u_bstatus == 0) {
        $.ajax({
            url: "/used/pageNum_ca1",
            type: "post",
            data: {"u_bstatus": u_bstatus, "page": page, "u_btype": u_btype,"category":checkedValue,"searchWord":searchWord},
            dataType: "json",
            success: function(data) {
                var hdata = '<ul class="page-num-used">';
                hdata += '<a href="used_ca1?page=1"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                hdata += data.page > 1 ? '<a href="pageNum_ca1?page=' + (data.page - 1) + '"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
                for (var i = data.startPage; i <= data.endPage; i++) {
                    hdata += data.page == i ? '<li class="num-used on"><div>' + i + '</div></li>' : '<a href="pageNum_ca1?page=' + i + '"><li class="num"><div>' + i + '</div></li></a>';
                }
                
                // 다음 페이지 링크
                hdata += data.page < data.maxPage ? '<a href="pageNum_ca1?page=' + (data.page + 1) + '"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                hdata += '<a href="pageNum_ca1?page=' + data.endPage + '"><li class="last-num"></li></a>';
                hdata += '</ul>';
                
                // 페이지 번호를 보여줄 요소에 HTML 삽입
                $(".PageNum").html(hdata);
                
                
                
                
                
            },
            error: function() {
                // 오류 처리
            }//error
        });//ajax
  }
    
    /*else{
		 $.ajax({
            url: "/used/pageNum_ca1",
            type: "post",
            data: {"u_bstatus": u_bstatus, "page": page, "u_btype": u_btype},
            dataType: "json",
            success: function(data) {
                var hdata = '<ul class="page-num-used">';
                hdata += '<a href="used_ca1?page=1"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                hdata += data.page > 1 ? '<a href="used_ca1?page=' + (data.page - 1) + '"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
                for (var i = data.startPage; i <= data.endPage; i++) {
                    hdata += data.page == i ? '<li class="num-used on"><div>' + i + '</div></li>' : '<a href="used_ca1?page=' + i + '"><li class="num"><div>' + i + '</div></li></a>';
                }
                
                // 다음 페이지 링크
                hdata += data.page < data.maxPage ? '<a href="used_ca1?page=' + (data.page + 1) + '"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                hdata += '<a href="used_ca1?page=' + data.endPage + '"><li class="last-num"></li></a>';
                hdata += '</ul>';
                
                // 페이지 번호를 보여줄 요소에 HTML 삽입
                $(".PageNum").html(hdata);
            },
            error: function() {
                // 오류 처리
            }//error
        });//ajax
	}//else
	*/

});//click
}//fucntion




	
});//jquery