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
			<div class="container" style="padding: 230px;">
				<div class="jumbotron">
					<div align="center">
						<h2>로그인</h2>
					</div>
					<form method="post"
						action="<%=request.getContextPath()%>/Login.member">
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
							<a href="">ID/PW찾기</a>

							<div style="text-align: right">
								<button type="submit" class="btn btn-default">로그인</button>
							</div>
						</table>
					</form>
				</div>
			</div>
		</div>

		<div class="rightcolumn">
			<div class="card">
				<a href="loginForm.jsp"><button class="btn 로그인">로그인</button></a> <a
					href="join.jsp"><button class="btn 회원가입">회원가입</button></a>
			</div>

			<div class="card">
				<h3>Popular Post</h3>
				<div class="fakeimg">
					<p>Image</p>
				</div>
				<div class="fakeimg">
					<p>Image</p>
				</div>
				<div class="fakeimg">
					<p>Image</p>
				</div>
			</div>
			<div class="card">
				<h3>Follow Me</h3>
				<p>Some text..</p>
			</div>

		</div>
	</div>

	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

	<script>
		//Get the button
		var mybutton = document.getElementById("myBtn");

		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction()
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}

		// When the user clicks on the button, scroll to the top of the document
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>

	<div class="footer">
		<!-- 로고 추가 -->
		<a href="${pageContext.request.contextPath}/qna/qnaList.qna">문의사항</a>
		<p>Copyright© All rights reserved.</p>
		<dl>
			<dt>주소: 서울특별시</dt>
			<dt>상호: CHC</dt>
			<dt>담당자: 홍길동</dt>
			<dt>연락처: 111-1111-1111</dt>
		</dl>
		<h6>본 사이트에서는 각종 청소년유해정보로부터 청소년을 보호하고자 관련법률에 따라 19세미만의 청소년들이 유해정보에
			접근할 수 없도록 청소년취급방침을 마련하여 시행하고 있습니다. 또한 청소년의 건전한 성장을 저해하는 음란 · 불법 등의
			유해정보와 비윤리적 · 반사회적 행위에 대해서는 엄격하게 제재하고 있습니다.</h6>
	</div>

</body>

</html>