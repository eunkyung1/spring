<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>지도API</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	0c74f5d01be449a3dcaa336db1cd0d99"></script>
		<script src="/js/daum_api2.js"></script>
		<style>
			*{magin:0; padding:0;}
			#map{border:3px solid black;}
			#header{width:100%; height:80px; text-align:center; margin-top:50px;}
			.overlaybox {position:relative;width:360px;height:350px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;padding:15px 10px;}
			.overlaybox div, ul {overflow:hidden;margin:0;padding:0;}
			.overlaybox li {list-style: none;}
			.overlaybox .boxtitle {color:#fff;font-size:16px;font-weight:bold;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png') no-repeat right 120px center;margin-bottom:8px;}
			.overlaybox .first {position:relative;width:247px;height:136px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/thumb.png') no-repeat;margin-bottom:8px;}
			.first .text {color:#fff;font-weight:bold;}
			.first .triangle {position:absolute;width:48px;height:48px;top:0;left:0;background: url('https://anhcorp.com/wp-content/uploads/2020/04/lotte-1-770x450.png') no-repeat; padding:6px;font-size:18px;}
			.first .movietitle {position:absolute;width:100%;bottom:0;background:rgba(0,0,0,0.4);padding:7px 15px;font-size:14px;}
			.overlaybox ul {width:247px;}
			.overlaybox li {position:relative;margin-bottom:2px;background:#2b2d36;padding:5px 10px;color:#aaabaf;line-height: 1;}
			.overlaybox li span {display:inline-block;}
			.overlaybox li .number {font-size:16px;font-weight:bold;}
			.overlaybox li .title {font-size:13px;}
			.overlaybox ul .arrow {position:absolute;margin-top:8px;right:25px;width:5px;height:3px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/updown.png') no-repeat;} 
			.overlaybox li .up {background-position:0 -40px;}
			.overlaybox li .down {background-position:0 -60px;}
			.overlaybox li .count {position:absolute;margin-top:5px;right:15px;font-size:10px;}
			.overlaybox li:hover {color:#fff;background:#d24545;}
			.overlaybox li:hover .up {background-position:0 0px;}
			.overlaybox li:hover .down {background-position:0 -20px;}   
		</style>

	</head>
	<body>
		<div id="header"><h1>다음지도 API</h1></div>
		<button type="button" id="daumMapBtn">버튼</button>
		<div id="map" style="width:100%;height:400px;"></div>

		
	</body>
</html>