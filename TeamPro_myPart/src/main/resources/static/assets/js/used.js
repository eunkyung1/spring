/**
 중고거래/중고양도 js* 
 */


 $(function(){

	//u_type 종류에 맞게 보여주기
	
	
		 
	 
	 //중고거래와 양도거래 클릭시 다르게 보여주기.
	$('#tabview1').prop('checked',true);
	$('.consolebox1').show();
	$('.consolebox2').hide();
	$('')
	
	$('input[name="tabview"]').change(function(){
		if($('#tabview1').is(':checked')){
			$('.consolebox1').show();
			$('.consolebox2').hide();
		}else if($('#tabview2').is(':checked')){
			$('.consolebox1').hide();
			$('.consolebox2').show();
		}
	})
	
});//jquery