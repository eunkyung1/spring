/**
 *
 */
$(function(){
daum_api();	
	
//ajax으로 영화정보 가져오기 함수		
function screen_data(){
		let content = "";

		var position = new kakao.maps.LatLng(37.49887, 127.026581);  
		$.ajax({
				url:"../movieAPI",
				type:"post",
				dataType:"json",
				data:{"txt":txt},
				success:function(data){
				alert("영화정보를 가져옵니다.");
				console.log("영화정보 : "+data);
				let iarr=data.boxOfficeResult.dailyBoxOfficeList;
				
				content = '<div class="overlaybox">' +
    '    <div class="boxtitle">금주 영화순위</div>' +
    '    <div class="first">' +
    '        <div class="triangle text">1</div>' +
    '        <div class="movietitle text">'+iarr[0].movieNm+'</div>' +
    '    </div>' +
    '    <ul>' +
    '        <li class="up">' +
    '            <span class="number">2</span>' +
    '            <span class="title">'+iarr[1].movieNm+'</span>' +
    '            <span class="arrow up"></span>' +
    '            <span class="count">2</span>' +
    '        </li>' +
    '        <li>' +
    '            <span class="number">3</span>' +
    '            <span class="title">'+iarr[2].movieNm+'</span>' +
    '            <span class="arrow up"></span>' +
    '            <span class="count">6</span>' +
    '        </li>' +
    '        <li>' +
    '            <span class="number">4</span>' +
    '            <span class="title">'+iarr[3].movieNm+'</span>' +
    '            <span class="arrow up"></span>' +
    '            <span class="count">3</span>' +
    '        </li>' +
    '        <li>' +
    '            <span class="number">5</span>' +
    '            <span class="title">'+iarr[4].movieNm+'</span>' +
    '            <span class="arrow down"></span>' +
    '            <span class="count">1</span>' +
    '        </li>' +
    '    </ul>' +
    '</div>'
				
				
				},
				error:function(){
				alert("실패");
				}
				})//ajax끝
				console.log("screen_data : "+content)
				return content;
		}//screen_data
		
		
function daum_api(){
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.502, 127.026581), // 지도의 중심좌표
		        level: 4 // 지도의 확대 레벨
		    };

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

	
		// 커스텀 오버레이를 생성합니다
		var customOverlay = new kakao.maps.CustomOverlay({
		    position: position,
		    //content: content,
		    content: screen_data(),
		    xAnchor: 0.3,
		    yAnchor: 0.91
		});

		// 커스텀 오버레이를 지도에 표시합니다
		customOverlay.setMap(map);
		}