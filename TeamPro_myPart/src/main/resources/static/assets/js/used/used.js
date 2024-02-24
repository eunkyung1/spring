/**
 중고거래/중고양도 js(ca_1,sh2)* 
 */
    
 $(function(){
	

//--중고거래와 양도거래 클릭시 페이지 맞게 출력하기
$("#tabview1").click(function() {
    window.location.href = "/used/used_ca1?u_btype=trade1&page=1";
    
});

// tabview2 클릭 시
$("#tabview2").click(function() {
    // used_sh2 페이지 열기
    window.location.href = "/used/used_sh2?u_btype=transfer2&page=1";
});

/*거래가능내역만 보기 유지 및 해제*/
    //중고거래 페이지
    var u_bstatus1 = localStorage.getItem('u_bstatus');
    if (u_bstatus1 === '0') {
        $('#showCompleted').prop('checked', true);
    } else {
        $('#showCompleted').prop('checked', false);
    }

    $('#showCompleted').change(function() {
        if ($(this).is(':checked')) {
            localStorage.setItem('u_bstatus', '0');
        } else {
            localStorage.removeItem('u_bstatus');
        }
    });

    $("#tabview1").click(function() {
        $('#showCompleted').prop('checked', false);
        localStorage.removeItem('u_bstatus');
    });

    //양도 페이지
    var u_bstatus2 = localStorage.getItem('u_bstatus');
    if (u_bstatus2 === '0') {
        $('#showCompleted2').prop('checked', true);
    } else {
        $('#showCompleted2').prop('checked', false);
    }

    $('#showCompleted2').change(function() {
        if ($(this).is(':checked')) {
            localStorage.setItem('u_bstatus', '0');
        } else {
            localStorage.removeItem('u_bstatus');
        }
    });

    $("#tabview2").click(function() {
        $('#showCompleted2').prop('checked', false);
        localStorage.removeItem('u_bstatus');
    });


/* 검색Form */
$("#searchBtn_ca1").click(function(){
    if($("input:checkbox[id=showCompleted]").is(":checked") == true){
        $("input[name=u_bstatus]").val("0");
    } else {
        $("input[name=u_bstatus]").val(""); // checkbox가 체크되어 있지 않으면 빈 값으로 설정
    }
    used_ca1Frm.submit();
});//click

$("#searchBtn_sh2").click(function(){
	if($("input:checkbox[id=showCompleted2]").is(":checked") == true){
		$("input[name=u_bstatus]").val("0");
	}else{
		$("input[name=u_bstatus]").val("");
	}
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
	

//--중고거래-- 거래가능내역 true, flase
 	$("#showCompleted").click(function(){
	if($("input:checkbox[id=showCompleted]").is(":checked") == true) {
		var possible = 0;
		var u_btype = $("input[name='tabview']:checked").attr('class');
		
		$.ajax({
			url:"/used/possible_t",
			type:"post",
			data:{"u_bstatus":possible,"u_btype":u_btype},
			dataType:"json",
			success:function(data){
			  var hdata = '';
                // JavaScript의 forEach 루프 사용
					data.list.forEach(function(udto) {
					var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
                    hdata += '<li class="'+udto.u_bstatus+'">';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno +'&u_btype='+udto.u_btype+ '"> ';
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
				
			    var pdata ='';
			    
			     pdata += '<ul class="page-num-used">';
                pdata += '<a href="used_ca1?page=1&u_btype='+u_btype+'&u_bstatus='+possible+ '&category='+data.category+'&searchWord'+data.searchWord+'"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                pdata += data.page > 1 ? '<a href="used_ca1?page=' + (data.page - 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
				for (var i = data.startPage; i <= data.endPage; i++) {
				    if (data.page == i) {
				        pdata += '<li class="num-used on"><div>' + i + '</div></li>';
				    } else {
				        pdata += '<a href="used_ca1?page=' + i +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord='+data.searchWord+ '"><li class="num-used"><div>' + i + '</div></li></a>';
				    }
				}
                
                // 다음 페이지 링크
                pdata += data.page < data.maxPage ? '<a href="used_ca1?page=' + (data.page + 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                pdata += '<a href="used_ca1?page=' + data.maxPage +'&u_bstatus='+possible+'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+ '"><li class="last-num"></li></a>';
                pdata += '</ul>';
				console.log("trade1 페이지 돌았다.");

			    $(".PageNum").html(pdata);
				    
                
                
			},
			error:function(){
			alert("실패");
			}
			})//ajax끝    
	}else{
		
			$.ajax({
		url:"/used/used_trade1",
			data:{"u_btype":"trade1"},
			type:"post",
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
	
	        var hdata = '';
	
	        // JavaScript의 forEach 루프 사용
	        data.list.forEach(function(udto) {
				var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
				console.log("used_trade1가 돌아요");
	            hdata += '<li class="'+udto.u_bstatus+'">';
	            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno +'&u_btype='+udto.u_btype+'"> ';
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
	        
	        	console.log("trade1 false 페이지 돌 준비");
				
			    var pdata ='';
			    
			    pdata += '<ul class="page-num-used">';
                pdata += '<a href="used_ca1?page=1&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                pdata += data.page > 1 ? '<a href="used_ca1?page=' + (data.page - 1) +'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
				for (var i = data.startPage; i <= data.endPage; i++) {
				    if (data.page == i) {
				        pdata += '<li class="num-used on"><div>' + i + '</div></li>';
				    } else {
				        pdata += '<a href="used_ca1?page=' + i +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord='+data.searchWord+ '"><li class="num-used"><div>' + i + '</div></li></a>';
				    }
				}
                
                // 다음 페이지 링크
                pdata += data.page < data.maxPage ? '<a href="possible_t?page=' + (data.page + 1) +'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                pdata += '<a href="used_ca1?page=' + data.maxPage +'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="last-num"></li></a>';
                pdata += '</ul>';
				console.log("trade1 페이지 돌았다.");

			    $(".PageNum").html(pdata);
				    
	        
	    },
		error:function(){
		}
		})//ajax끝
	}//else
	})//click(#showCompleted)
/*==============================*/
/*       중고양도                 */
/*============================*/

//--중고양도-- 거래가능내역 true, flase
 	$("#showCompleted2").click(function(){
	if($("input:checkbox[id=showCompleted2]").is(":checked") == true) {
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
					data.list.forEach(function(udto) {
					var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
                    hdata += '<li class="'+udto.u_bstatus+'">';
                    hdata += '<a href="usedcontent?u_bno=' + udto.u_bno +'&u_btype='+udto.u_btype+'"> ';
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
				console.log("중고양도 trade1 페이지 돌 준비");
				
			    var pdata ='';
			    
			     pdata += '<ul class="page-num-used">';
                pdata += '<a href="used_sh2?page=1&u_btype='+possible+'&u_bstatus='+u_btype+ '&category='+data.category+'&searchWord'+data.searchWord+'"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                pdata += data.page > 1 ? '<a href="used_sh2?page=' + (data.page - 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                   // 페이지 숫자 링크
				for (var i = data.startPage; i <= data.endPage; i++) {
				    if (data.page == i) {
				        pdata += '<li class="num-used on"><div>' + i + '</div></li>';
				    } else {
				        pdata += '<a href="used_sh2?page=' + i +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord='+data.searchWord+ '"><li class="num-used"><div>' + i + '</div></li></a>';
				    }
				}
                // 다음 페이지 링크
                pdata += data.page < data.maxPage ? '<a href="used_sh2?page=' + (data.page + 1) +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                pdata += '<a href="used_sh2?page=' + data.maxPage +'&u_bstatus='+possible+'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+ '"><li class="last-num"></li></a>';
                pdata += '</ul>';
				console.log("trade1 페이지 돌았다.");

			    $(".PageNum").html(pdata);
				    
                
                
			},
			error:function(){
			alert("실패");
			}
			})//ajax끝    
	}else{
		
			$.ajax({
			url:"/used/used_trade1",
			data:{"u_btype":"transfer2"},
			type:"post",
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
	
	        var hdata = '';
	
	        // JavaScript의 forEach 루프 사용
	        data.list.forEach(function(udto) {
				var price = parseFloat(udto.u_bprice).toLocaleString('ko-KR');
				console.log("중고양도 used_trade1가 돌아요");
	            hdata += '<li class="'+udto.u_bstatus+'">';
	            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno +'&u_btype='+udto.u_btype+'"> ';
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
	        
	        	console.log("중고양도 trade1 false 페이지 돌 준비");
				
			    var pdata ='';
			    
			    pdata += '<ul class="page-num-used">';
                pdata += '<a href="used_sh2?page=1&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="first-num"></li></a>';
                
                // 이전 페이지 링크
                pdata += data.page > 1 ? '<a href="used_sh2?page=' + (data.page - 1) +'&u_btype='+u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="prev-num"></li></a>' : '<li class="prev-num"></li>';
                
                // 페이지 숫자 링크
				for (var i = data.startPage; i <= data.endPage; i++) {
				    if (data.page == i) {
				        pdata += '<li class="num-used on"><div>' + i + '</div></li>';
				    } else {
				        pdata += '<a href="used_sh2?page=' + i +'&u_bstatus='+possible+'&u_btype='+u_btype+'&category='+data.category+'&searchWord='+data.searchWord+ '"><li class="num-used"><div>' + i + '</div></li></a>';
				    }
				}
                
                // 다음 페이지 링크
                pdata += data.page < data.maxPage ? '<a href="used_sh2?page=' + (data.page + 1) +'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="next-num"></li></a>' : '<li class="next-num"></li>';
                
                pdata += '<a href="used_sh2?page=' + data.maxPage +'&u_btype='+data.u_btype+'&category='+data.category+'&searchWord'+data.searchWord+'"><li class="last-num"></li></a>';
                pdata += '</ul>';
				console.log("중고양도 trade1 페이지 돌았다.");

			    $(".PageNum").html(pdata);
				    
	        
	    },
		error:function(){
		}
		})//ajax끝
	}//else

})//click(#showCompleted)

/*글쓰기 버튼 구현*/
$(".CSSbuttonWhite").click(function(){
	let Writer = $("#sid").val();
	if(Writer == ""){
		alert("로그인 후에 글쓰기가 가능합니다.");
	}else{
		window.location.href = "/used/usedWrite";
	}
});//글쓰기 버튼

	
});//jquery