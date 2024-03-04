<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Registration Form in HTML CSS</title>
    <!---Custom CSS File--->
    <link rel="stylesheet" href="../css/mInsert.css">
    
    <!--◁◀◁◀ Header ▶▷▶▷ -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--◁◀◁◀ Header ▶▷▶▷ -->
  </head>
  <body>
  <form method="post" action="">
   <div class="container">
    <div class="insert">
    	<table>
	    <caption><h2>회원가입 양식</h2></caption>
	    <tr>
	        <td class="col1"><div style="width: 150px; height: 200px; border: 1px solid black;"></div></td>
	        <td>이름</td>
	        <td colspan="1"><input type="text" name="name" maxlength="5"></td>
	    </tr>
	    <tr>
	    <tr>
	        <td class="col1">아이디</td>
	        <td class="col2">
	            <input type="text" name="id" maxlength="10">
	            <input class='but1' type="button" value="중복확인" onclick="">
	        </td>
	    </tr>
	    <tr>
	        <td class="col1">프로필 사진 등록</td>
	        <td class="col2"><input type="file"></td>
	    </tr>
	    <tr>
	        <td class="col1">비밀번호</td>
	        <td class="col2">
	            <input type="password" name="pwd" maxlength="16">
	            <p>※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%^&*)의 조합
	            10 ~ 16자리</span>로 입력이 가능합니다.</p>
	        </td>
	    </tr>
	    <tr>
	        <td class="col1">비밀번호 확인</td>
	        <td class="col2"><input type="password" name="pwdCheck" maxlength="16"></td>
	    </tr>
	    <tr>
	        <td class="col1">주민등록번호</td>
	        <td class="col2">
	            <input type="text" name="mailid">
	            <span class="a">-</span>
	            <input type="text" name="email">
	            <input class='but2' type="button" value="중복확인">
	        </td>
	    <tr>
	        <td class="col1">생년월일</td>
	        <td class="col2">
		        <input type="date">월
	        </td>
	    </tr>
	    <tr>
	        <td class="col1">성별</td>
	        <td class="col2">
		        <input type="radio" value="male"><label>남자</label>
		        <input type="radio" value="female"><label>여자</label>
	        </td>
	    </tr>
	    <tr>
	    <tr>
	        <td class="col1">연락처</td>
	        <td class="col2">
	            <input type="text" name="mailid">
	            <span class="a">-</span>
	            <input type="text" name="email">
	            <span class="a">-</span>
	            <input type="text" name="email">
	        </td>
	    <tr>
	        <td class="col1">이메일</td>
	        <td class="col2">
	            <input type="text" name="mailid">
	            <span class="a">@</span>
	            <input type="text" name="email">
	            <select name="mailslc">
	                <option value="self" selected>직접입력</option>
	                <option value="naver">naver.com</option>
	                <option value="gm">gmail.com</option>
	                <option value="da">daum.com</option>
	                <option value="yah">yahoo.com</option>
	            </select>
	            <input class='but2' type="button" value="이메일 중복확인" onclick="">
	        </td>
	    </tr>
	    <tr>
	        <td class="col1">주소</td>
	        <td class="col2">
	            <input type="text" name="mailid">
	            <input class='but2' type="button" value="우편번호 찾기"><br>
	            <input type="text" name="email">
	        </td>
	    </tr>
    </table>
    
  </div>
 
  <div class="create">
    
        <input class="but3" type="button" value="가입취소" onclick="">
        <input class="but4" type="button" value="회원가입" onclick="formCheck(this.form)">
    
  </div>
  </div>
  </form>
 </body>
  <!--◁◀◁◀ Footer ▶▷▶▷ -->
  <%@ include file="/WEB-INF/views/include/footer.jsp"%>
  <!--◁◀◁◀ Footer ▶▷▶▷ -->
</html>
