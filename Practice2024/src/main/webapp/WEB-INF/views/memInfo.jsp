<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			* {margin: 0 auto;}
			table{ border-collapse : collapse; }  /*이중선 제거*/
			th,td{
			      width: 100px;
			      height: 25px;
			      text-align: center;
			      border: 1px solid #000;
			      
			      vertical-align: top;	/* 위 */
			      vertical-align: bottom;   /* 아래 */
			      vertical-align: middle;   /* 가운데 */
			    }
			th:nth-child(10) {width:20px;}
			.title{ 
					width : 250px;
					font-size: 30px;
					margin-top: 15px;
					margin-bottom : 15px;
				  }
		</style>
		
	</head>
	<body>
		<div class="title">인 사 기 록 카 드</div>
		<table>
			<tr>
				<th>사번</th>
				<td></td>
				<th colspan="3">성명</th>
				<th>입사일</th>
				<td></td>
				<th>퇴사년월일</th>
				<td></td>
				<td colspan="2" rowspan="6">사진</td>
			</tr>		
			<tr>
				<th>부서명</th>
				<td></td>
				<th>한글</th>
				<td colspan="2"></td>
				<th>주민등록번호</th>
				<td></td>
				<th>전화번호</th>
				<td></td>
				
			</tr>		
			<tr>
				<th>직위</th>
				<td></td>
				<th>한자</th>
				<td colspan="2"></td>
				<th>생년월일</th>
				<td></td>
				<th>핸드폰번호</th>
				<td></td>
			</tr>		
			<tr>
				<th>성별</th>
				<td>남, 여</td>
				<th>영문</th>
				<td colspan="2"></td>
				<th>E-Mail 주소</th>
				<td colspan="3"></td>
			</tr>		
			<tr>
				<th>본적</th>
				<td colspan="8"></td>
			</tr>
			<tr>
				<th>현주소</th>
				<td colspan="8"></td>
			</tr>
			
			<tr>
				<th rowspan="2">신체상황</th>
				<th>신장</th>
				<th>체중</th>
				<th colspan="2">시력</th>
				<th>색맹</th>
				<th>혈액형</th>
				<th>특기사항</th>
				<th>최종학교명</th>
				<th colspan="2">전공과목</th>
			</tr>
			<tr>
				<td>cm</td>
				<td>kg</td>
				<td colspan="2">(좌) (우)</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="2"></td>
			</tr>
			
			<tr>
				<th rowspan="2">병역관계</th>
				<th>역종</th>
				<th>군별</th>
				<th>병과</th>
				<th>군번</th>
				<th>입대일자</th>
				<th>전역일자</th>
				<th>미필사유</th>
				<th>혼인구분</th>
				<th rowspan="2">종교</th>
				<th rowspan="2"></th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>기혼, 미혼</td>
				<td></td>
			</tr>
			<tr>
				<th colspan="11">가족사항</th>
			</tr>
			<tr>
				<th>관계</th>
				<th>성명</th>
				<th>생년월일</th>
				<th>연령</th>
				<th>학력</th>
				<th>직업</th>
				<th>동거여부</th>
				<th colspan="4">비고</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4"></td>
			</tr>
			<tr>
				<th colspan="11">자격, 면허</th>
			</tr>
			<tr>
				<th colspan="2">년월일</th>
				<th colspan="4">종별</th>
				<th colspan="2">시행청</th>
				<th colspan="3">비고</th>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td colspan="4"></td>
				<td colspan="2"></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td colspan="4"></td>
				<td colspan="2"></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td colspan="4"></td>
				<td colspan="2"></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td colspan="4"></td>
				<td colspan="2"></td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td colspan="4"></td>
				<td colspan="2"></td>
				<td colspan="3"></td>
			</tr>
			
			
		</table>
	
	</body>
</html>