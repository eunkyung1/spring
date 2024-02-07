/**
 중고거래/중고양도 js* 
 */


/*
function displayFirstImage() {

}//displayFirstImage
*/    



 $(function(){
	

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
			url:"/used/used_ca1",
			type:"post",
			dataType:"json", //받는파일형태 : text,json,xml
			success:function(data){
	
	        var hdata = '';
	
	        // JavaScript의 forEach 루프 사용
	        data.forEach(function(udto) {
	            hdata += '<li>';
	            hdata += '<a href="usedcontent?u_bno=' + udto.u_bno + '"> ';
	            hdata += '<span><img src="/upload/' + udto.u_mimg + '"></span> ';
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
		url:"/used/used_sh2",
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


	
	
});//jquery