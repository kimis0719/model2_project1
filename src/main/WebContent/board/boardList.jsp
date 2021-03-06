<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang=kr>

<head>
<title>게시판 페이지</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/boardScript.js"></script>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<jsp:include page="../layout/header.jsp" />



	<div class="row">
		<div class="leftcolumn">
		<div align="right">
				<!-- 정렬기능 -->
				<a class="sort">
					<select name="orderselect" onchange="orderListToURL(this.value)">
						<option value="./BoardListAction.board?cate_num=${currentCate}"
							<c:if test="${orderName == null}">
								selected
							</c:if>
						>최신순 정렬</option>
						<option value="./BoardOrderListAction.board?cate_num=${currentCate}&order=board_good" 
							<c:if test="${orderName == 'board_good'}">
								selected
							</c:if>
						>좋아요 정렬</option>
						<option value="./BoardOrderListAction.board?cate_num=${currentCate}&order=board_count"
							<c:if test="${orderName == 'board_count'}">
								selected
							</c:if>
						>조회수 정렬</option>						
					</select> 
				</a>
				<!-- 글쓰기 -->
				<c:if test="${currentCate != 1 }">
					<!-- <a class="boardWrite" align="right"> --> 
					<input type="button"
						value="글쓰기"
						onclick="location.href='./BoardWriteAction.board?cate_num=${currentCate}'">
					<!-- </a> -->
				</c:if>
				</div>
			<table id=table align="center">
				<br>
				<!-- 게시판명이 들어갈 자리 -->
				<tr text-align="center">
					<th width=>번호</th>
					<th width=>제목</th>
					<th width=>작성자</th>
					<th width=>조회수</th>
					<th width=>추천</th>
					<th width=>작성일</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 10 }" />
				<c:forEach var="b" items="${boardlist}">
					<tr>
						<td>${num}<c:set var="num" value="${num-1}" />
						</td>
						<td text-decoration="none">
							<a href="./BoardDetailAction.board?cate_num=${currentCate}&board_num=${b.board_num}&page=${page}">
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

			


			<div style="" align="center">
				<c:if test="${listcount > 0 }">
					<!-- 1페이지로 이동 -->
					<a href="./BoardListAction.board?cate_num=${currentCate}&page=1"
						style="text-decoration: none"> << </a>

					<!-- 이전블럭으로 이동 -->
					<c:if test="${startPage > 10 }">
						<a
							href="./BoardListAction.board?cate_num=${currentCate}&page=${startPage - 10 }">[이전]</a>
					</c:if>

					<!-- 각 블럭에 10개의 페이지 출력 -->
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == page }">
							[${i}]
						</c:if>
						<c:if test="${i != page }">
							<a
								href="./BoardListAction.board?cate_num=${currentCate}&page=${i}">[${i}]</a>
						</c:if>
					</c:forEach>

					<!-- 다음블럭으로 이동 -->
					<c:if test="${endPage < pageCount }">
						<a
							href="./BoardListAction.board?cate_num=${currentCate}&page=${startPage + 10 }">[다음]</a>
					</c:if>

					<!-- 마지막 페이지로 이동 -->
					<a
						href="./BoardListAction.board?cate_num=${currentCate}&page=${pageCount}"
						style="text-decoration: none"> >> </a>
				</c:if>
			</div>

		</div>


		<jsp:include page="../layout/rightcolumn.jsp" />
	</div>
		<div align="center">
				<!-- 검색기능 -->
				<div class="search"> 
						<form action="BoardSearchAction.board?cate_num=${currentCate}" method=post accept-charset="utf-8">
							<select name="sel" id="sel">
								<option value="board_title">제목</option>
								<option value="board_content">내용</option>
								<option value="board_nick">작성자</option>
							</select> 
							<input type="text" name="find" id="find"> 
							<button type="submit" class="btn btn-info2">
							<span class="glyphicon glyphicon-search"></span> 검색
							</button>
						</form>
					</div>
			</div>

<%-- <c:import url="../layout/footer.jsp" /> --%>
	<jsp:include page="../layout/footer.jsp" />


</body>

</html>