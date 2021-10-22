<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<title>로그인 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="<%=request.getContextPath()%>/member/login.js"></script>
</head>
<body>

	<jsp:include page="../layout/header.jsp" />

	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<div class="container" style="padding: 230px;">
					<div class="jumbotron">
						<div align="center">
							<h2>로그인</h2>
						</div>
						<form method="post" action="./Login.member">
							<table class="table table-bordered table-hover" align="center">
								<div class="form-group">
									<label for="mem_id">ID:</label> <input type="text"
										class="form-control" id="mem_id" name="mem_id"
										placeholder="아이디" maxlength="20">
								</div>
								<div class="form-group">
									<label for="mem_pass">Password:</label> <input type="password"
										class="form-control" id="mem_pass" name="mem_pass"
										placeholder="비밀번호" maxlength="20">
								</div>
								<a href="<%=request.getContextPath()%>/member/searchId.jsp">ID/PW찾기</a>

								<div style="text-align: right">
									<button type="submit" class="btn login">로그인</button>
								</div>
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