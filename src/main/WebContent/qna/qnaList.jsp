<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna List</title>
<c:import url="../layout/boot.jsp" />
<c:import url="../layout/header.jsp" />
<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/qnaList.css"
	rel="stylesheet">
</head>
<body>
	<div class="body_main">
		<div class="b"></div>
		<!-- 서브 타이틀 -->
		<div class="subTitle_wrap">
			<div class="subTitle_inner">
				<h2>문의사항</h2>
			</div>
		</div>

		<!-- container -->
		<div class="container">
			<div class="qna_filter"></div>
			<table class="qna_tb">
				<colgroup>
					<col style="width: 85px;">
					<col style="width: auto;">
					<col style="width: 96px;">
					<col style="width: 115px;">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">문의번호</th>
						<th scope="col">문의/답변</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${lists}" var="list">
						<c:if test="${list.qna_step == 0}">
							<tr class="${list.qna_ref}">
								<td class="td_num">${list.qna_ref}</td>
								<td class="td_view"><c:if test="${list.qna_check eq 0}">
										<span class="state">미완료</span>
									</c:if> <c:if test="${list.qna_check eq 1}">
										<span class="state stateF">답변완료</span>
									</c:if> <!-- 비밀글일때 --> <c:if test="${list.qna_sec eq 1}">
										<c:if
											test="${member.mem_id ne list.qna_writer && member.mem_grade ne 99}">비밀글입니다. <img
												alt="비밀글" src="${pageContext.request.contextPath}/images/board/lock-line.png"
												style="margin-bottom: 4px;">
										</c:if>
										<c:if
											test="${member.mem_id eq list.qna_writer || member.mem_grade eq 99}">
											<a href="javascript:void(0)" id="showCloseDetail"
												class="view_txt">${list.qna_title} <img alt="비밀글"
												src="./images/board/lock-line.png"
												style="margin-bottom: 4px;"></a>
										</c:if>
									</c:if> <!-- 비밀글 아닐때 --> <c:if test="${list.qna_sec eq 0}">
										<a href="javascript:void(0)" id="showCloseDetail"
											class="view_txt">${list.qna_title}</a>
									</c:if></td>
								<td class="td_writer">${list.qna_writerS}</td>
								<td class="td_date">${list.qna_dateS}</td>
							</tr>
						</c:if>

						<tr class="trQna trQna${list.qna_ref}" style="display: table-row;">
							<td colspan="4" class="qna_wrap" style="display: table-cell;">
								<!-- 질문 --> <c:if test="${list.qna_step == 0}">
									<div class="question">
										<span class="iconQ">질문</span>
										<div style="white-space: pre-line;">
											<c:out value="${list.qna_content}" />
										</div>
										<br>
										<div class="btns_wrap">
											<input type="hidden" class="num" value="${list.qna_num}">
											<%-- <c:if test="${member.grade eq 99}"> --%>
												<a href="javascript:void(0)" class="btn_reply">답변하기 ></a>
											<%-- </c:if> --%>
											<%-- <c:if test="${member.nickname eq list.qna_writer}"> --%>
												<a href="javascript:void(0)" class="btn_update">수정하기</a>
											<%-- </c:if> --%>
											<%-- <c:if
												test="${member.nickname eq list.qna_writer || member.grade eq 99}"> --%>
												<a href="qnaDelete.qna?ref=${list.qna_ref}">삭제하기</a>
											<%-- </c:if> --%>
										</div>
									</div>
								</c:if> <!-- 답변 --> <c:if test="${list.qna_step > 0}">
									<div class="answer">
										<span class="iconA">답변</span>
										<div style="white-space: pre-line;">
											<c:out value="${list.qna_content}" />
										</div>
										<br>
										<div class="btns_wrap">
											<input type="hidden" class="num" value="${list.qna_ref}">
											<%-- <c:if
												test="${member.grade eq 99 && member.nickname eq list.qna_writer}"> --%>
												<a href="javascript:void(0)" class="btn_replyUpdate">수정하기</a>
												<a
													href="qnaAnswerDelete.qna?qna_num=${list.qna_num}&&qna_ref=${list.qna_ref}">삭제하기</a>
											<%-- </c:if> --%>
										</div>
									</div>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<%-- <c:if test="${member.grade ne 99}"> --%>
			<div class="btn_wrap">
				<input type="button" value="문의하기" class="btn_write">
			</div>
			<%-- </c:if> --%>

			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li class="previous"><a
						href="./qnaList.qna?curPage=${pager.startNum-1}"><</a></li>
				</c:if>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<c:if test="${pager.curPage == i}">
						<li class="list"><a href="./qnaList.qna?curPage=${i}"
							style="color: #f23600;">${i}</a></li>

					</c:if>
					<c:if test="${pager.curPage != i}">
						<li class="list"><a href="./qnaList.qna?curPage=${i}">${i}</a></li>
					</c:if>
				</c:forEach>

				<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li class="next"><a
						href="./qnaList.qna?curPage=${pager.lastNum+1}">></a></li>
				</c:if>
			</ul>
		</div>
		<c:import url="../layout/footer.jsp" />
	</div>
	<script type="text/javascript">
		////////////////////////////////////////////////////////////////////
		var openWin;
		var nickname = "${member.mem_id}";

		$('.trQna').hide();

		$('.view_txt').click(function() {
			var i = $(this).parents('tr').attr('class');
			$('.trQna' + i).slideToggle();
		});

		//문의 등록
		$('.btn_write')
				.click(
						function() {
							//window.name = "부모창 이름";
							//window.name = "parentForm";
							//window.open("open할 window", "자식창 이름", "팝업창 옵션");
							//if (nickname != null && nickname != "") {
							openWin = window
									.open("./qnaWrite.qna", "wirteForm",
											"top=100, left=10, width=920, height=700, resizable = no, scrollbars = no");
							/* } else {
								var confirm_val = confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?");
								if (confirm_val) {
									location.href = "../member/memberLogin";
									//이동후에 로그인하면 다시 원래 페이지로 돌아오는 방법이 없을까?
								} else {
									location.href = "./qnaList";
								}
							} */
						});

		function openUpdate(num) {
			openWin = window
					.open("qnaUpdate.qna?qna_num=" + num, "updateForm",
							"top=100, left=10, width=920, height=700, resizable = no, scrollbars = no");
		}

		function openAnswer(num) {
			openWin = window
					.open("qnaAnswer.qna?qna_num=" + num, "answerForm",
							"top=100, left=10, width=920, height=700, resizable = no, scrollbars = no");
		}

		function openAnswerUpdate(num) {
			openWin = window
					.open("qnaAnswerUpdate.qna?qna_num=" + num, "answerForm",
							"top=100, left=10, width=920, height=700, resizable = no, scrollbars = no");
		}

		//문의 수정
		$('.btn_update').click(function() {
			var num = $(this).parent().find('.num').val();

			openUpdate(num);
		});

		//답변
		$('.btn_reply').click(function() {
			var num = $(this).parent().find('.num').val();

			openAnswer(num);
		});

		//답변 수정
		$('.btn_replyUpdate').click(function() {
			var num = $(this).parent().find('.num').val();

			openAnswerUpdate(num);
		})

		//날짜 변환 함수
		function changeDate(date) {
			date = new Date(parseInt(date));
			year = date.getFullYear();
			month = date.getMonth();
			day = date.getDate();
			hour = date.getHours();
			minute = date.getMinutes();
			//second = date.getSeconds();
			strDate = year + "-" + month + "-" + day + " " + hour + ":"
					+ minute;
			return strDate;
		}
	</script>
</body>
</html>
