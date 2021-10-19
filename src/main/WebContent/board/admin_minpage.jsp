<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=kr>

<head>
<title>메인페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="../layout/header.jsp" />
	<%-- <jsp:include page="./CateListAction.do"></jsp:include> --%>
	<c:import url="/CateListAction.do" />
	<div class="row">
		<div class="leftcolumn">
			<div class="card">
				<h2>일상●취미</h2>
				<table border=1 width=700 align=center>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</table>
			</div>
			<div class="card">
				<h2>스포츠</h2>
				<table border=1 width=700 align=center>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</table>
			</div>
			<div class="card">
				<h2>게임</h2>
				<table border=1 width=700 align=center>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<c:set var="num" value="${listcount - (page-1) * 10 }" />
					<%-- <c:forEach var="b" items="${boardlist}"> --%>
				</table>
			</div>
			<div class="card">
				<h2>연애</h2>
				<table border=1 width=700 align=center>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</table>
			</div>
		</div>
		<div class="rightcolumn">
			<div class="card">
				<button class="btn login">로그인</button>
				<button class="btn sing-up">회원가입</button>
			</div>
		</div>
	</div>


	<c:import url="../layout/footer.jsp" />
</body>

</html>