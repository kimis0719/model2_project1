<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=kr>
 
<head> 
<title>공지게시판</title>
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
				<!-- 페이지 처리 -->
				<center>
				<c:if test="${listcount > 0 }">
					
					<!-- 1페이지로 이동 -->
					<a href="./BoardListAction.do?page=1" 
					style="text-decoration: none"> << </a>
					
					<!-- 이전블럭으로 이동 -->
					<c:if test="${startPage > 10 }"> 
						<a href ="./BoardListAction.do?page=${startPage - 10 }">[이전]</a>
					</c:if>
					
					<!-- 각 블럭에 10개의 페이지 출력 -->
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == page }">		<!-- 현재 페이지 -->
							[${i}]
						</c:if>
						<c:if test="${i != page }">		<!-- 현재페이지가 아닌 경우 -->
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
				</center>
				</div>
				
		</div>

		<div class="rightcolumn">
			<div class="card">
				<button class="btn login">로그인</button>
				<button class="btn sign-up">회원가입</button>
			</div>
		</div>
	</div>

	<c:import url="../layout/footer.jsp" />


</body>

</html>