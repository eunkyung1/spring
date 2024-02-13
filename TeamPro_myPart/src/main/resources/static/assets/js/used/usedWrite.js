/**
 * used.js파일
 */

/*usedWrite*/

$(function(){
	/*제목,내용,가격 막기*/
	$("#u_saveBtn").click(function(){
		if($("#used_btitle").val().length<1){
			alert("제목을 입력하셔야 합니다.");
			$(".used_input1").focus();
			return false;
		};
		if($(".used_bcontent").val().length<1){
			alert("내용을 작성하셔야 합니다.");
			$(".used_bcontent").focus();
			return false;
		};	
		var uPrice= $("#u_bprice").val().trim();
		 if(uPrice ===""){
	            alert("가격을 작성하셔야 합니다.");
	            $(".used_input1").focus();
	            return false;
		};
		
		var selectedValue=$("#used_trade").val();
		if(selectedValue === null || selectedValue===""){
			alert("유형을 선택하셔야 합니다.");
			return false;
		};
		
		usedWriteFrm.submit();
		
	});//click
	
/*사진 미리보기*/
	imgName = $("#filePreviewContainer1").text();
	alert(imgName);

    var imageUrl = "/upload/imgName";
    if (imageUrl) {
        var previewItem = $('<div class="file-preview-item"></div>');
        previewItem.append('<img src="' + imageUrl + '" alt="File Preview" class="file-preview-img">');
        $('.file-preview-container').append(previewItem);
    }

 $(document).on('change', '.u_files_input', function() {
        var fileInput = this;
        var filePreviewContainer = $(this).prev('.file-preview-container');
        filePreviewContainer.empty(); // 기존에 표시된 미리보기 초기화

        // 선택한 모든 파일에 대해 미리보기 생성
        for (var i = 0; i < fileInput.files.length; i++) {
            var file = fileInput.files[i];
            var reader = new FileReader();

            reader.onloadend = (function (file) {
                return function () {
                    // 파일 미리보기 표시
                    var previewItem = $('<div class="file-preview-item"></div>');
                    previewItem.append('<img src="' + reader.result + '" alt="File Preview" class="file-preview-img">');
                    filePreviewContainer.append(previewItem);
                };
            })(file);

            if (file) {
                reader.readAsDataURL(file);
            }
        }
    });	

	/*가격 숫자만 입력가능*/
    // 입력란에 입력이 발생할 때 이벤트 처리
     $('#u_bprice').on('input', function() {
        // 입력된 값 가져오기
        var value = $(this).val();
        // 숫자 이외의 문자가 있는지 확인하는 정규식
        var regex = /^[0-9]*$/;
        // 숫자와 일치하지 않는 문자가 입력된 경우
        if (!regex.test(value)) {
            // 입력된 값에서 숫자 이외의 문자를 모두 제거하여 다시 입력란에 설정
            $(this).val(value.replace(/\D/g, ''));
            console.log("Invalid input");
        }
});      
	
	        
	        

});//jquery