/**
 usedcontent.jsp* 
 */


$(function(){
// 이미지 URL
var imageUrl = "/assets/img/nView/noImage_camp.jpg";

// 파일명 추출
var filename = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
	/*
var mainImage = $("#u_image_mimg").text();
var defaultImageUrl = "../../assets/img/nView/noImage.png";

if(!mainImage) {
	console.log("이미지가 없으니깐 돌아요!");
	mainImage = defaultImageUrl;
	$('#imageElement').attr('src', imageUrl);
}
*/




/*수정,삭제,거래완료 버튼 구현*/
	$(".u_updateBtn").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
		var u_btype = $("#u_btype").val();
		window.location.href = '/used/usedUpdate?u_bno='+u_bno+'&u_btype='+u_btype;
	});
	
	$(".u_delBtn").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
		var u_btype = $("#u_btype").val();
		window.location.href = '/used/usedDelete?u_bno='+u_bno+'&u_btype='+u_btype;
	});
	
	$(".u_comple").click(function(){
		var u_bno =  $(this).parent().parent().find('.tb-center').attr('class').split(' ')[1];
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
				 }
				},
				error:function(){
				alert("실패");
				}
				})//ajax끝
			
		}else{
			alert("오류가 발생하였습니다. 다시 시도하시기 바랍니다.");
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