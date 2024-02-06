/**
 *nUpdate js 
 */
	
$(function(){
	//var sel_Value = '<c:out value="${nbdto.n_btype}"/>';
	var selectElement = $("#bType");
	var options = selectElement.find("option");
	
	options.each(function() {
	      if ($(this).val() == sel_Value) {
	        $(this).prop("selected", true);
	      }
	});//options

	
	$("#nUpdateBtn").click(function(){
		notice_Frm.submit();
	});
	
	/* 업로드할 사진 보여주기*/
    $('#n_bfile').change(function() {
    var fileInput = $(this)[0];
    var filePreviewContainer = $('#filePreviewContainer');
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
	
	
});//제이쿼리