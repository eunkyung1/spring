<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  
   <!-- include summernote css/js -->
	<link href="/css/summernote/summernote-lite.css" rel="stylesheet">
	<script src="/js/summernote/summernote-lite.js"></script>
	<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
	
	 <script>
  	$(function(){
  		$('#summernote').summernote({

  			height: 500,                 // 최초 글쓰기 높이
  		  minHeight: 500,             // 최소 높이
  		  maxHeight: 500,             // 최대 높이
  		  focus: true,                  // set focus to editable area after initializing summernote
  		  lang:"ko-KR",
  		  placeholder:"최대 2000자까지 입력할 수 있습니다.",
			// 추가 부분
          toolbar: [
		// [groupName, [list of button]]
		['fontname', ['fontname']],
		['fontsize', ['fontsize']],
		['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		['color', ['forecolor','color']],
		['table', ['table']],
		['para', ['ul', 'ol', 'paragraph']],
		['height', ['height']],
		['insert',['picture','link','video']],
		['view', ['codeview','fullscreen', 'help']]
		],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
  		
  		//callback함수 호출
  		callbacks: { //여기 부분이 이미지를 첨부하는 부분
				  onImageUpload : function(files) { //이미지를 열기를 하는 순간.
				  //이미지 업로드 함수 호출 - 매개변수 : 이미지파일, 현재 위치 
					uploadFile(files[0],this); //이미지 업로드 호출 & 현재 위치점.
				  },
				  onPaste: function (e) {
				   var clipboardData = e.originalEvent.clipboardData;
				   if (clipboardData && clipboardData.items &&
				   clipboardData.items.length) {
				       var item = clipboardData.items[0];
				if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
				  e.preventDefault();
				       }
				   }
				 }
				} //callbacks
			
  		});//summernote
  	});//jquery
  	
  	//summernote 이미지 추가 - file
  	function uploadFile(file,this_editor){
  		var form_data = new FormData(); //form태그 없어도 form 저장 보낸다는 개념
  		form_data.append("file",file);
  		//form에 있는 데이터를 넘길 때 사용.
  		
  		//ajax
  		$.ajax({
  			url:"/summernoteUpload"
  			,type:"post"
  			,data:form_data
  			,cashe:false
  			,contentType:false
  			,enctype:"multipart/form-data"
  			,processData:false
  			,success:function(data){
  				console.log("파일저장위치 : "+data);
  				$(this_editor).summernote('editor.insertImage',data);
  				
  			}
  			,error:function(){
  				alert("실패");
  			}
  		});//ajax
  	}//uploadFile
  	
  	
  	
  	
  	
  </script>
</head>
<body>
<section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="bwrite" name="bwrite" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" id="summernote" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write button">작성완료</button>
        <button type="button" class="cancel button" onclick="javascript:location.href='blist'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>