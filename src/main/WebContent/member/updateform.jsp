<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.memberDTO"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function openDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
//				document.getElementById('join_zip1').value = data.postcode1;
//				document.getElementById('join_zip2').value = data.postcode2;
				document.getElementById('post').value = data.zonecode;
				document.getElementById('address').value = data.address;
				
			}
		}).open();
	}
</script>
<!-- 외부 자바스크립트 파일 불러오기 -->

<%=request.getContextPath()%>

</head>
<body>

<form method="post" action="<%=request.getContextPath()%>Update.do"></form>
<input type="hidden" name="mem_id" value="${member.mem_id}">
<table border="1" width="500" align="center">
	<caption>개인 정보 수정</caption>
		<tr><td>아이디</td>
			<td>${member.mem_id}  <!-- member : 서비스클래스에서 공유한 공유되는 네임값 --></td>
		</tr>
		
		<tr><td>비밀번호</td>
				<td><input type="password" id="mem_pass" name="mem_pass"></td>		
		</tr>
		
		<tr><td>닉네임</td>
			<td><input type="text" id="mem_nick" name="mem_nick"
					   value="${member.mem_nick}"></td>		
		</tr>
		
		<tr><td></td>
		
		</tr>


</table>

</body>
</html>