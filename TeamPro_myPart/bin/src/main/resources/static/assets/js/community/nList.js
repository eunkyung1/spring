/**
 공지사항  
 **/

 $(function(){
	 
	 $("#searchBtn").click(function(){
		 nListSearchFrm.submit();
	 });
	 
	 /* 글쓰기 관리자 외에 페이지 이동 막기 */
	  $("#n_write").click(function(event){
			   
			   event.preventDefault();
		   		$.ajax({
		   			url:"/community/session_check",
		   			type:"get",
		   			dataType:"text",
		   			success:function(data){
		   			console.log(data);
		   			if(data =='imposs'){
		   				alert("관리자 외에 글쓰기가 불가합니다.");
		   			}else{
		   				window.location.href = $("#n_write").attr("href");
		   			}
		   			},
		   			error:function(){
		   			alert("실패");
		   			}
		   			});
	 
				 });//click
		   	
		   	
		   	
		   		
		   	});//jquery
