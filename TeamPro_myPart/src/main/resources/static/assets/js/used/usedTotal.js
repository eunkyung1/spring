/**
 usedcontent.jsp* 
 */


$(function(){
	
/*수정,삭제 버튼 구현*/
	$(".u_updateBtn").click(function(){
		window.location.href = '/used/usedUpdate';
		var u_bno =  $(this).closest('tr').find('.tb-center').attr('class').split(' ')[1];
		alert(u_bno);
		
	});//click(update)
	
	/*작성자 아니면 (.pri)버튼 hide & show*/
	var sessionID = $('#session').val();
	var author = $('.writer').parent().attr('class');
	
	if(sessionID != author || sessionID==""){
		$('.pri').hide();
	}else{
		$('.pri').show();
	};
	
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