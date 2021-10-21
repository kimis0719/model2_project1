<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 추가</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
	background: #EEEEEE;
	position: relative;
}

body {
	opacity: 1;
}

/* Header/Blog Title */
.header {
	padding: 30px;
	text-align: center;
	background: #EEEEEE;
}

.header h1 {
	font-size: 40px;
}

input[type=text]:focus {
	width: 50%;
}

.affix {
	top: 0;
	width: 100%;
	z-index: 9999 !important;
}

.navbar {
	margin-bottom: 0px;
}

.affix ~ .container-fluid {
	position: relative;
	top: 50px;
}

/* Create two unequal columns that floats next to each other */
/* Left column */
.leftcolumn {
	float: left;
	width: 75%;
}

/* Right column */
.rightcolumn {
	float: left;
	width: 25%;
	background-color: #f1f1f1;
	padding-left: 20px;
}

/* Fake image */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
}

/* Set a style for all buttons */
.btn {
	border: none;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}

.btn2 {
	border: none;
	color: white;
	padding: 4px 12px;
	font-size: 16px;
	cursor: pointer;
}

.로그인 {
	background-color: #EC5E5E;
}

.로그인:hover {
	background-color: #EC5E5E;
}

.회원가입 {
	background-color: #e7e7e7;
	color: black;
}

.회원가입:hover {
	background: #ddd;
}

.btn-info {
	background-color: #EC5E5E;
}

.btn-info:hover {
	background-color: #EC5E5E;
}

.btn-search {
	background-color: #EC5E5E;
}

.btn-search:hover {
	background-color: #EC5E5E;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

#myBtn {
	display: none;
	position: fixed;
	bottom: 20px;
	right: 30px;
	z-index: 99;
	font-size: 18px;
	border: none;
	outline: none;
	background-color: #EC5E5E;
	color: white;
	cursor: pointer;
	padding: 15px;
	border-radius: 4px;
}

#myBtn:hover {
	background-color: #555;
}

/* Footer */
.footer {
	padding: 25px;
	text-align: center;
	background-color: #222222;
	color: #919191;
	margin-top: 25px;
}
/* footer address a{
    display: block; /* a 태그는 인라인요소라 수평으로 출력돼서 블록으로 강제로 수직으로 출력되도록 함*/
}
*
/

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */




@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	padding: 8px;
	background: #ffffff;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

td {
	padding: 8px;
	background-color: #fbfbfb;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #ffffff;
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<div class="row">
		<div class="leftcolumn">
					<div class="card">
				<table id=table text-align="center">
				<caption><h3>게시판 관리</h3></caption>
				<tr>
					<th width=>카테고리 코드</th>
					<th width=>카테고리 이름</th>
					<th width=>게시판 번호</th>
					<th width=>게시판 이름</th>
					<th width=>관리</th>
				</tr>
				
				<c:forEach var="c" items="${catelist}">
					<tr>
						<td >${c.cate_code}</td>
						<td >
							<c:choose>
								<c:when test="${c.cate_code == 1}">
									공지
								</c:when>
								<c:when test="${c.cate_code == 2}">
									일상●취미
								</c:when>
								<c:when test="${c.cate_code == 3}">
									스포츠
								</c:when>
								<c:when test="${c.cate_code == 4}">
									게임
								</c:when>
								<c:otherwise>
									연예
								</c:otherwise>
							</c:choose>
						</td>
						<td >${c.cate_num}</td>
						<td >${c.cate_name}</td>
						<td >
							<c:if test="${c.cate_num != 1}">
									<input type="button" value="삭제" onclick="location.href='./BoardKillAction.board?cate_num=${c.cate_num}'">
							</c:if>
						</td>
					</tr>
				</c:forEach>
				</table>
				
				<form method="post" action="./BoardAdd.board" accept-charset="utf-8">
					<table>
						<tr>
							<td width="700"><select id="catecode" name="catecode"> 
									<option value="">코드</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
							<td><td>
							<td><input type="text" id="catename" name="catename" placeholder="게시판명 입력" size=10></td>
							<td></td>
							<td><input type="submit" value="추가"></td>
						</tr>
					</table>
				</form>

				
			</div>
		
		</div>
		<jsp:include page="../layout/rightcolumn.jsp" />
	</div>

	<jsp:include page="../layout/footer.jsp" />