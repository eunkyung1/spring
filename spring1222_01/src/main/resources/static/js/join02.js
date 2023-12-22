/**
 * 
 */


$(function(){
	$("#addressBtn").click(function(){
		 new daum.Postcode({
		    oncomplete: function(data) {
				$("#f_postal").val(data.zonecode);
				$("#address1").val(data.address);
			  }
				 }).open();

	});//click
	$("#saveBtn").click(function(){
	$.ajax({
		
			url: "/member/mInsert",
			type: "post", //get, post
			data: $("#agreeFrm").serialize(), //복수개의 데이터 보낼경우 : form에있는 모든 입력데이터를 한번에 전송 : $(form태크 id값).serialize()
			dataType: "text", //받는 파일형태 - text, json, xml
			//contentType:"json",//※필요시 사용 내가보내는 파일형태
			success: function(data) {
				alert("성공")
				console.log("data : " + data)
				if(data=="가입완료"){
					alert("회원가입이 완료되었습니다.")
					location.href="/"
				}
			}, //success
			error: function() {
				alert("실패")
			}//error
		});//ajax
	
	})//click
	
	
});//jquery
