<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<title>메인 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

input[type=text] {
	width: 130px;
	box-sizing: border-box;
	border: 5px solid #EC5E5E;
	border-radius: 4px;
	font-size: 15px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
	-webkit-transition: width 0.4s ease-in-out;
	transition: width 0.4s ease-in-out;
	outline: none;
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
}
table {
  border-collapse: collapse;
  width: 100%;
}
th{
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
tr:hover {background-color: #ffffff;}
</style>
</head>
<body>

	<%-- <jsp:include page="./CateListAction.do"></jsp:include> --%>
	 <c:import url="/CateListAction.do" />
	
	<div class="row">
		<div class="leftcolumn">
			<table align = "center">
				<br><!-- 게시판명이 들어갈 자리 -->
				<tr>
					<th width = 100>번호</th>
					<th width = 700>제목</th>
					<th width = 100>조회수</th>
					<th width = 150>작성일</th>
				</tr>
				
					<c:set var="num" value="${listcount - (page-1) * 10 }"/>	
					<c:forEach var="b" items="${boardlist}">
						<tr>
							<td>${num} 
								<c:set var="num" value="${num-1}"/>	
							</td>
							<td> 
								<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								 	${b.board_subject}
								 </a>	
							</td>
							<td> ${b.board_name}	</td>
							<td> 
								<fmt:formatDate value="${b.board_date}" pattern="yyyy-MM-dd HH:mm:ss EEE요일"/> 
							</td>
							<td> ${b.board_readcount}</td>
						</tr>
					</c:forEach>
				</table><br>
				
				<div style="text" align="center" >
				<c:if test="${listcount > 0 }">
					<!-- 1페이지로 이동 -->
					<a href="./BoardListAction.do?page=1" style="text-decoration: none"> << </a>
					
					<!-- 이전블럭으로 이동 -->
					<c:if test="${startPage > 10 }"> 
						<a href ="./BoardListAction.do?page=${startPage - 10 }">[이전]</a>
					</c:if>
					
					<!-- 각 블럭에 10개의 페이지 출력 -->
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == page }">
							[${i}]
						</c:if>
						<c:if test="${i != page }">
							<a href="./BoardListAction.do?page=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<!-- 다음블럭으로 이동 -->
					<c:if test="${endPage < pageCount }"> 
						<a href ="./BoardListAction.do?page=${startPage + 10 }">[다음]</a>
					</c:if>
					
					<!-- 마지막 페이지로 이동 -->
					<a href="./BoardListAction.do?page=${pageCount}" style="text-decoration: none"> >> </a>
				</c:if>
				</div>
				
			</table>
		</div>

		<div class="rightcolumn">
			<div class="card">
				<button class="btn 로그인">로그인</button>
				<button class="btn 회원가입">회원가입</button>
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