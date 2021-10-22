<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath() %>/board/boardFind.js"></script>
	<script src="<%=request.getContextPath() %>/board/boardDetail.js"></script>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta charset="utf-8">
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






</style>
<link href="${pageContext.request.contextPath}/css/boardList.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/boardDetail.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<div class="row">
		<div class="leftcolumn">
			<br>
			<!-- 글 상세페이지 -->
			<table class="detail" id="detail">
				<tr>
					<th class="detailtitle" colspan="3"><h3>${board.board_title}</h3></th>
				</tr>
				<tr class="detailhead">
					<td class="bnick">${board.board_nick}</td>
					<td class="bdate"><fmt:formatDate value="${board.board_date}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="bcount">조회수 : ${board.board_count}</td>
				</tr>

				<tr>
					<td class="detailcontent" colspan="3">${content}
					<td>
				</tr>
				<tr class="goodnbad" style="text-align: center">
					<td colspan="3" style="text-align: center">

						<div>
							<div class="w3-border w3-center w3-padding">
								<c:choose>
									<c:when test="${sessionScope.member.mem_nick == null }">
										추천 및 비추 기능은 로그인 후 사용 가능합니다.<br />
										추천 : ${board.board_good} 비추 : ${board.board_bad}
										<span class="rec_count"></span>
									</c:when>
									<c:when
										test="${ sessionScope.member.mem_nick == board.board_nick }">
										<br />
										추천 : ${board.board_good} 비추 : ${board.board_bad}
										<span class="rec_count"></span>
									</c:when>

									<c:otherwise>
										<input type="button" value="추천 : ${board.board_good}"
											onclick="location.href='./BoardGoodAction.board?cate_num=${currentCate}&board_num=${board.board_num}&page=${page}'">
										<input type="button" value="비추 : ${board.board_bad}"
											onclick="location.href='./BoardBadAction.board?cate_num=${currentCate}&board_num=${board.board_num}&page=${page}'">
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</td>
				</tr>
				<!--  -->
				<tr style="text-align: center">
					<td class="buttonlist" colspan="3"><c:if
							test="${board.board_nick == sessionScope.member.mem_nick}">
							<input type="button" value="수정"
								onclick="location.href = './BoardUpdateAction.board?board_num=${board.board_num}&cate_num=${currentCate}'">

							<input type="button" value="삭제"
								onclick="location.href = './BoardDelete.board?board_num=${board.board_num}&cate_num=${currentCate}'">
						</c:if> <input type="button" value="목록"
						onclick="location.href = './BoardListAction.board?cate_num=${currentCate}&page=${page}'">
					</td>
				</tr>
			</table>
			<br>
			<!-- 댓글 출력 부분 -->
			<form method="post" class="replywrite" accept-charset="utf-8"
				action="./ReplyWriteAction.reply?cate_num=${currentCate}&board_num=${board.board_num}&page=${page}">
				<table id="reply" class="reply">
					<tbody class="rtbody">
						<tr class=replysec>
							<c:forEach var="r" items="${replylist}">
								<tr class=replylist>
									<c:choose>
										<c:when test="${r.re_yn == 'y'}">
											<td>${r.re_writer}<c:if
													test="${board.board_nick == r.re_writer}">
												(작성자)
											</c:if>
											</td>
											<td class="replycontent">&nbsp;&nbsp;${r.re_content}<br>

											</td>
											<td class="replydate"><fmt:formatDate
													value="${r.re_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td><c:if
													test="${sessionScope.member.mem_nick == r.re_writer}">
													<input type="button" value="삭제"
														onclick="location.href='./ReplyDeleteAction.reply?cate_num=${currentCate}&board_num=${board.board_num}&page=${page}&re_num=${r.re_num}' ">
												</c:if></td>
										</c:when>
										<c:otherwise>
											<td colspan="4">삭제된 댓글입니다.</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>

						</tr>
						<!-- 댓글작성부분 -->
						<tr>
							<c:choose>
								<c:when test="${sessionScope.member.mem_nick != null }">
									<td name="writer" id="writer">
										${sessionScope.member.mem_nick}</td>
									<td colspan="3"><textarea rows="4" cols="120"
											style="resize: none;" id="re_content" name="re_content"></textarea>
										<input type="submit" id="writereply" name="writereply"
										value="댓글작성"></td>
								</c:when>
								<c:otherwise>
									<td colspan="3" style="text-align: center">로그인 후 댓글을 작성해
										주세요.</td>
								</c:otherwise>

							</c:choose>
						</tr>
					</tbody>
				</table>
			</form>

			<%-- <!-- 첨부파일이 있을때만 첨부파일 출력 -->
			<c:if test="${board.board_file != null}">
				<a href="./board/file_down.jsp?file_name=${board.board_file}">
					${board.board_file} </a>
			</c:if> --%>

			<div>
				<ul>
					<c:forEach items="${select.boardFileDTOs}" var="file" varStatus="i">
						<li><a href="./fileDown?file_num=${file.file_num}">${file.file_oname}</a></li>
					</c:forEach>
				</ul>
			</div>

			<table class=boardtable>
				<br>
				<h3>&nbsp;&nbsp;&nbsp;${cateName} 게시판</h3>
				<tr>
					<th class=bnum>번호</th>
					<th class=btitle>제목</th>
					<th class=bwriter>작성자</th>
					<th class=bcount>조회수</th>
					<th class=bgood>추천</th>
					<th class=bdate>작성일</th>
				</tr>

				<c:set var="num" value="${listcount - (page-1) * 10 }" />
				<c:forEach var="b" items="${boardlist}">
					<tr>
						<td class=bnum>${num}<c:set var="num" value="${num-1}" />
						</td>
						<td text-decoration="none" class=btitle><a
							href="./BoardDetailAction.board?cate_num=${currentCate}&board_num=${b.board_num}&page=${page}">
								${b.board_title} </a></td>
						<td class=bwriter>${b.board_nick}</td>
						<td class=bcount>${b.board_count}</td>
						<td class=bgood>${b.board_good}</td>
						<td class=bdate><fmt:formatDate value="${b.board_date}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<table class="downbar">
				<tr>
					<td class="sort">
						<!-- 정렬기능 --> <a class="sort"> <select name="orderselect"
							onchange="orderListToURL(this.value)">
								<option value="./BoardListAction.board?cate_num=${currentCate}"
									<c:if test="${orderName == null}">
										selected
									</c:if>>최신순
									정렬</option>
								<option
									value="./BoardOrderListAction.board?cate_num=${currentCate}&order=board_good"
									<c:if test="${orderName == 'board_good'}">
										selected
									</c:if>>추천순
									정렬</option>
								<option
									value="./BoardOrderListAction.board?cate_num=${currentCate}&order=board_count"
									<c:if test="${orderName == 'board_count'}">
										selected
									</c:if>>조회수
									정렬</option>
						</select>
					</a>
					</td>
					<td class="search">
						<!-- 검색기능 -->
						<div class="search">
							<form action="BoardSearchAction.board?cate_num=${currentCate}"
								method=post accept-charset="utf-8">
								<select name="sel" id="sel">
									<option value="board_title">제목</option>
									<option value="board_content">내용</option>
									<option value="board_nick">작성자</option>
								</select> <input type="text" name="find" id="find">
								<button type="submit" class="btn2 btn-search">검색</button>
							</form>
						</div>
					</td>
					<!-- 글쓰기 -->
					<c:if test="${currentCate != 1 }">
						<a class="boardWrite" align="right"> <input type="button"
							value="글쓰기"
							onclick="location.href='./BoardWriteAction.board?cate_num=${currentCate}'">
						</a>
					</c:if>
				</tr>
			</table>
		</div>

		<br>
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

		<jsp:include page="../layout/rightcolumn.jsp" />
	</div>

	<jsp:include page="../layout/footer.jsp" />

</body>

</html>