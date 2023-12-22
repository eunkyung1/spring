<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doLogin</title>
</head>
<body>

	<script>
		if(${result}==1){
			alert("로그인이 되었습니다.");
			location.href="/";
		}else{
			alert=("아이디 또는 패스워드가 틀렸습니다. 다시 로그인해주시기 바랍니다.")
			location.href="memeber/login";
		}
	</script>

</body>
</html>