<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

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
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/board/boardScript.js"></script>
</head>
<body>
		<!-- header -->
<%-- 	<c:import url="/layout/header.jsp" /> --%>
	<jsp:include page="./layout/header.jsp" />

	<div class="row">
		<div class="leftcolumn">
			<div class="card">
			<table id=table text-align="center">
				<caption><h3>공지</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num" value="${listcount1 - (page-1) * 5 }"  />
				<c:forEach var="b" items="${noticelist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>일상●취미 - 자유게시판</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num2" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${freelist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>일상●취미 - 일상</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num2" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${dailylist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>스포츠 - 축구</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num2" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${sclist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>스포츠 - 야구</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num2" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${bslist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>게임 - 디아2</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num2" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${d2list}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>게임 - FF14</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${ff14list}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>연예 - 영화</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${movielist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="card">
				<table id=table text-align="center">
				<caption><h3>연예 - TV방송</h3></caption>
				<tr>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 5 }" />
				<c:forEach var="b" items="${tvlist}">
					<tr>
						<td text-decoration="none" text-align="center">
							<a href="./BoardDetailAction.do?board_num=${b.board_num}&page=${page}">
								${b.board_title} 
							</a>
						</td>
						<td>${b.board_nick}</td>
						<td>${b.board_count}</td>
						<td>${b.board_good}</td>
						<td><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>

		<div class="rightcolumn">
			<div class="card">
			<input type="button" class="btn login" value="로그인" onclick="location.href='./member/loginForm.jsp'">
				<!-- <button class="btn login">로그인</button> -->
				<button class="btn sing-up">회원가입</button>
			</div>
		</div>
	</div>
		
	<%-- <c:import url="../layout/footer.jsp" /> --%>
	<jsp:include page="./layout/footer.jsp" />

</body>

</html>