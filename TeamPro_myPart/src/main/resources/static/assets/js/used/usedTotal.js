/**
 usedcontent.jsp* 
 */


$(function(){


/*수정,삭제,거래완료 버튼 구현*/
	$(".u_updateBtn").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
		var u_btype = $("#u_btype").val();
		window.location.href = '/used/usedUpdate?u_bno='+u_bno+'&u_btype='+u_btype;
	});
	
	$(".u_delBtn").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
		window.location.href = '/used/usedDelete?u_bno='+u_bno+'&u_btype='+u_btype;window.location.href = '/used/usedDelete?u_bno='+u_bno+'&u_btype='+u_btype;
		window.location.href = '/used/usedDelete?u_bno='+u_bno+'&u_btype='+u_btype;
	});
	
	$("#u_listBtn").click(function(){
		var u_btype = $("#u_btype").val();
		if(u_btype == "trade1"){
			window.location.href="/used/used_ca1";
		}else{
			window.location.href="/used/used_sh2";
		}	
	});
	
	$(".u_comple").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
		var u_btype = $("#u_btype").val();
		if(confirm("거래완료로 변경하시겠습니까?")){
			$.ajax({
				url:"/used/usedComplete",
				type:"post",
				data:{"u_bno":u_bno},
				dataType:"json", //받는파일형태 : text,json,xml
				success:function(data){
				 if(data == 1){
				  var hdata = '';
					hdata+='<button type="button" class="u_list">목록</button>';
					hdata+='<button type="button" class="u_list u_delBtn pri">삭제</button>';
					hdata+='<button type="button" class="u_list u_updateBtn pri">수정</button>';
	                $(".u_listBtn").html(hdata);
	                alert("거래가 완료되었습니다.")
	                 window.location.href = '/used/usedcontent?u_bno='+u_bno+'&u_btype='+u_btype;
				 }
				},
				error:function(){
				alert("실패");
				}
				})//ajax끝
			
		}else{
			alert("거래완료 취소하였습니다.");
		}
		
		
	});
	
	/*작성자 아니면 (.pri)버튼 hide & show*/
	var sessionID = $('#session').val();
	var author = $('.writer').parent().attr('class');
	
	if(sessionID != author || sessionID==""){
		$('.pri').hide();
	}else{
		$('.pri').show();
	};
	
	/*b_ustatus가 1이면 거래완료 버튼 hide*/
	var u_bstatus = $("#u_bstatus").val();
	if(u_bstatus == 1){
		$(".u_comple").hide();
	}
	
 /*이미지 모달창 열기*/
  $('.modal-u_trigger').click(function() {
      var imgSrc = $(this).attr('src'); // 클릭한 이미지의 경로를 가져옵니다.
      $('#u_modalImage').attr('src', imgSrc); // 모달 창의 이미지 소스를 설정합니다.
      $('#u_myModal').css('display', 'block'); // 모달 창을 보여줍니다.
    });

    // 모달 창을 닫기 위한 이벤트 리스너 추가
    $('.close').click(function() {
      $('#u_myModal').css('display', 'none'); // 모달 창을 숨깁니다.
    });

    // 모달 창 외부를 클릭하여 모달 창을 닫기 위한 이벤트 리스너 추가
    $(window).click(function(event) {
      if (event.target == $('#u_myModal')[0]) {
        $('#u_myModal').css('display', 'none'); // 모달 창을 숨깁니다.
      }
    });
});//jquery