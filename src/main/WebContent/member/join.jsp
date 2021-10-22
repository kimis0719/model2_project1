<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<title>회원가입 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 외부파일 불러오기 -->
<script src="<%=request.getContextPath() %>/member/join.js"></script>

</head>
<body>

	<jsp:include page="../layout/header.jsp" />
		

	<div class="row">
		<div class="leftcolumn">
		<div class="card">
<div class="container">
		<div style="padding: 100px;">
		<form method="post" action="<%=request.getContextPath() %>/Member.member"
			enctype="multipart/form-data">
			<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="4"><h4>회원가입</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width:110px;"><h6>아이디</h6></td>
						<td><input class="form-control" type="text" id="mem_id" name="mem_id" placeholder="아이디" maxlength="20"></td>
						<td style="width:100px;"><button class="btn btn-default" id="idcheck" type="button"><h6>ID중복체크</h6></button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>닉네임</h6></td>
						<td><input class="form-control" type="text" id="mem_nick" name="mem_nick" placeholder="닉네임" maxlength="40"></td>
						<td style="width:100px;"><button class="btn btn-default" id="nickcheck" type="button">닉네임 체크</button></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>비밀번호</h6></td>
						<td><input class="form-control" type="password" id="mem_pass" name="mem_pass" placeholder="비밀번호" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>비밀번호 확인</h6></td>
						<td><input class="form-control" type="password" id="mem_pass2" name="mem_pass2" placeholder="비밀번호 확인" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>이메일</h6></td>
						<td><input class="form-control" type="email" id="mem_email" name="mem_email" placeholder="이메일" maxlength="20"></td>
					</tr>
					<tr>
						<td style="width:140px;"><h6>프로필사진</h6></td>
						<td><input class="form-control" type="file" id="mem_img" name="mem_img"></td>
					</tr>
					<tr>
						<td style="width:110px;"><h6>핸드폰번호</h6></td>
						<td><input class="form-control" type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰번호" maxlength="20"></td>
					</tr>
					<tr>
						<td style="text-align:right" colspan="2"><input class="btn btn-default pull-right" type="submit" value="회원가입"></td>
					</tr>
				</tbody>	
			</table>
		</form>
	  </div>	
	</div>
 </div>
 </div>
 <jsp:include page="../layout/rightcolumn.jsp" />
</div>


	
<jsp:include page="../layout/footer.jsp" />

</body>

</html>