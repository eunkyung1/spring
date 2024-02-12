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
	 $('#u_bprice').on('input', function() {
	            var value = $(this).val();
	            // 정규 표현식을 사용하여 숫자가 아닌 문자를 제거합니다.
	            var newValue = value.replace(/[^\d]/g, '');
	            // 변경된 값을 다시 입력란에 설정합니다.
	            $(this).val(newValue);
	        });
	        
	
	        
	        

});//jquery