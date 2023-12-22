/**
 *login -> loginCheck 
 */

$(function(){
	let chkKeyUp=0;
	
	//회원가입버튼
	$("#savebtn").click(function(){
		if(chkKeyUp!=1){
		alert("아이디 중복체크를 하셔야 합니다.");
		return false;
		}else{
			alert("다음으로 진행합니다");
		}
		
	$.ajax({
		url:"/member/mInsert",
		type:"post",
		data:$("#memberFrm").serialize(), //form의 데이터 전체를 한번에 보내줌.
		dataType:"text", //받는파일형태 : text,json,xml
		success:function(data){
			alert("성공");
			console.log("data"+data);
			if(data="Complete"){
				alert("회원가입이 완료되었습니다.");
				location.href="/";
			}
		},
		error:function(){
		alert("실패");
		}
		})
		//ajax끝
	
	});
	
	

	//아이디 확인 버튼 클릭 후 아이디가 수정되었는지 확인 작업
	$("#id").keyup(function(){
		console.log("key up 발생");
			$("#chkTxt").text("아이디 중복체크 하셔야 합니다.");
			$("#chkTxt").css({"color":"black","font-wight":"700"});
		chkKeyUp = 0;
		
	})
	
	$("#idCheckBtn").click(function(){
		//아이디 중복체크
		alert("아이디 중복체크를 합니다.");
		console.log($("#id").val());
		if($("#id").val().length<1){
			alert("아이디를 입력하셔야 체크 가능합니다.");
			$("#id").focus();
			return false;
		};
		//ajax
		$.ajax({
			url:"/member/idCheck",
			type:"post",
			//data:$("#memberFrm").serialize(), //form의 데이터 전체를 한번에 보내줌.
			data:{"id":$("#id").val()}, //data는 MCOntroller idCheck mdto로 넘겨짐
			//data:{"id":$("#id").val(),"pw":$("#pw").val()}, //데이터를 개별적으로 보냄
			//contentType:"", //내가보내는 파일형태
			dataType:"text", //받는파일형태 : text,json,xml
			success:function(data){
				alert("성공");
				if(data=="available"){
					alert("아이디를 사용할 수 있습니다.");
					$("#chkTxt").text("아이디 사용가능합니다.");
					$("#chkTxt").css({"color":"blue","font-wight":"700"});
					
				}else{
					alert("아이디를 사용할 수 없습니다.")
					$("#chkTxt").text("아이디 사용불가능합니다.");
					$("#chkTxt").css({"color":"orange","font-wight":"700"});
				}
				console.log("data : "+data)
				chkKeyUp=1;
			},
			
			error:function(){
				alert("실패");
			}
			
		
			
			
		})
		//ajax끝
		
		
		
	});//click
});
